package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.UIManager;

import componentes.MyFrame;
import componentes.MyHelpJTextPane;
import componentes.MyJTextPane;
import control.resources.Icons;
import control.resources.Texts;

public class ActionsControl {

	private final Font boldFont;
	private final Font plainFont;
	private MainControl control;
	private Font toCopyFont;
	private AttributeSet sa;
	private List<Font> fonts;
	private List<AttributeSet> attributes;

	//Abre la ayuda
	public void doOpenHelp(JTextPane jTextPane) {
		JOptionPane pane = new JOptionPane(MyHelpJTextPane.getCompleteHelpPanel(),JOptionPane.PLAIN_MESSAGE);
		JDialog dialog = pane.createDialog(jTextPane, Texts.get("menu_help"));
		dialog.setBounds(100, 100, 800, 600);
		dialog.setVisible(true);
		
	}
	
	//coherencia de las apariencias
	public void ajustSkinFont(MyFrame jFrame, String tema) {
		//pone en negrita el menuItem con el nombre del LookAndFeel seleccionado y se la quita a las demás.
		JMenu skin = jFrame.getjMenuBar().getSkin();
		for (int i = 0; i < skin.getItemCount(); i++) {
			if (skin.getItem(i).getName().equals(tema)) {
				skin.getItem(i).setFont(boldFont);
			} else {
				skin.getItem(i).setFont(plainFont);
			}
		}
	}
	
	//cambio de idioma
	public void doChangeLanguaje(Locale locale, MyFrame jFrame) {
		
		//locale para que la clase Texts detecte automáticamente el cambio
		Texts.setLocale(locale);
		Texts.setTexts(jFrame);
		String language = locale.toString().substring(0, 2);
		
		//ajute del icono
		jFrame.getjPanel().getjToolBar().getLanguageButton().setIcon(ActionsControl.getLocIcon(language));
		
		//coherencia del idioma
		if (language.equals("es")) {
			jFrame.getjMenuBar().getSpanish().setFont(boldFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getSpanish().setFont(boldFont);
		} else {
			jFrame.getjMenuBar().getSpanish().setFont(plainFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getSpanish().setFont(plainFont);
		}
		if (language.equals("en")) {
			jFrame.getjMenuBar().getEnglish().setFont(boldFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getEnglish().setFont(boldFont);
		} else {
			jFrame.getjMenuBar().getEnglish().setFont(plainFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getEnglish().setFont(plainFont);
		}
		if (language.equals("de")) {
			jFrame.getjMenuBar().getGerman().setFont(boldFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getGerman().setFont(boldFont);
		} else {
			jFrame.getjMenuBar().getGerman().setFont(plainFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getGerman().setFont(plainFont);
		}
		if (language.equals("fr")) {
			jFrame.getjMenuBar().getFrench().setFont(boldFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getFrench().setFont(boldFont);
		} else {
			jFrame.getjMenuBar().getFrench().setFont(plainFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getFrench().setFont(plainFont);
		}
		if (language.equals("it")) {
			jFrame.getjMenuBar().getItalian().setFont(boldFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getItalian().setFont(boldFont);
		} else {
			jFrame.getjMenuBar().getItalian().setFont(plainFont);
			jFrame.getjPanel().getjToolBar().getLanguagePopUp().getItalian().setFont(plainFont);
		}
	}

	//cambio de fuente
	public void doChangeFont(String newFont , JTextPane jTextPane) {
		StyledEditorKit.FontFamilyAction styledEditorKit = new StyledEditorKit.FontFamilyAction(null, newFont);
		styledEditorKit.actionPerformed(null);
		//es importante devolver el foco, así el usuario puede seguir escribiendo sin pausa
		jTextPane.requestFocus();
	}

	//cambio de tamaño
	public void doChangeFontSize(int newSize, JTextPane jTextPane) {
		StyledEditorKit.FontSizeAction styledEditorKit = new StyledEditorKit.FontSizeAction(null, newSize);
		styledEditorKit.actionPerformed(null);
		jTextPane.requestFocus();
	}
	
	//cambio de color
	public void doChangeColor(Color newColor) {
		StyledEditorKit.ForegroundAction styledEditorKit = new StyledEditorKit.ForegroundAction(null, newColor);
		styledEditorKit.actionPerformed(null);
	}
	
	public void doCopy(JTextPane jTextPane) {
		doCopySelectedFormat(jTextPane);
		// copia el teto normalmente
		jTextPane.copy();
	}
	
	private void doCopySelectedFormat(JTextPane jTextPane) {
		//detecta el texto a copiar
		StyledDocument document = jTextPane.getStyledDocument();
		fonts = new LinkedList<Font>();
		attributes = new LinkedList<AttributeSet>();
		int start = jTextPane.getSelectionStart();
		int end = jTextPane.getSelectionEnd();

		// Copia caracter a caracter una lista de las fuentes seleccionadas.
		for (int i = start; i < end; i++) {
			sa = document.getCharacterElement(i).getAttributes();
			toCopyFont = jTextPane.getStyledDocument().getFont(sa);
			fonts.add(toCopyFont);
			attributes.add(sa);
		}if (attributes.size() > 0) {
			//se deja constancia de que hay un estilo copiado
			control.setFontCopied(true);
		}
	}
	
	//cierra la aplicación con confirmación
	public void doClose(MyFrame jFrame) {
		int opcion = JOptionPane.showConfirmDialog(jFrame, Texts.get("exit_text"), Texts.get("exit_title"),
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (opcion == 0) {
			System.exit(0);
		}
	}
	
	public void doCut(MyJTextPane jTextPane) {
		this.doCopySelectedFormat(jTextPane);
		jTextPane.cut();
	}
	
	//obtiene icono en función del lenguaje
	public static Icon getLocIcon(String language) {
		if (language.equals("es")) {
			return Icons.SpainM();
		} else if (language.equals("en")) {
			return Icons.UnitedKindomM();
		} else if (language.equals("de")) {
			return Icons.GermanyM();
		} else if (language.equals("fr")) {
			return Icons.FranceM();
		} else {
			return Icons.ItalyM();
		}

	}
	
	//pide confirmación para un nuevo documento
	public void doNewDocument(MyFrame jFrame) {
		int opcion = JOptionPane.showConfirmDialog(jFrame, Texts.get("exit_text"), Texts.get("new_title"),
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (opcion == 0) {
			jFrame.getjPanel().getjTextPane().newDocument();
		}
	}
	
	//abre el selector de idiomas
	public void doOpenLagChooser(MyFrame jFrame) {
		// cordenadas del click en la pantalla
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();

		// coordenadas del jTextPane
		Point pt = new Point(jFrame.getjPanel().getLocation());
		SwingUtilities.convertPointToScreen(pt, jFrame.getjPanel());
		int xT = (int) pt.getX();
		int yT = (int) pt.getY();

		// calcula posición relativa y aplica pequeños ajustes
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().show(jFrame.getjPanel().getjToolBar(), x - xT + 10,
				y - yT + 15);
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().setVisible(true);
	}
	
	public void doPaste(JTextPane jTextPane) {
		// Se pega el texto
		jTextPane.paste();

		// Se etablecen los atributos de cada caracter pegado
		if (control.isFontCopied()) {
			int textLength = attributes.size();
			int position = jTextPane.getCaretPosition();
			for (int i = 0; i < textLength; i++) {
				jTextPane.getStyledDocument().setCharacterAttributes(position - textLength + i, 1, attributes.get(i),
						true);
			}
		}
	}
	
	//pega solamente el formato del primer caracter copiado  en el texto seleccionado
	public void doPasteOnlyFormat(JTextPane jTextPane) {
		if (control.isFontCopied()) {
			int start = jTextPane.getSelectionStart();
			int end = jTextPane.getSelectionEnd();
			for (int i = 0; i < end-start; i++) {
				jTextPane.getStyledDocument().setCharacterAttributes(start + i, 1, attributes.get(0),
						true);
			}
		}
	}
	
	//cambia la apariencia general si la solicitada se encuantra en el sistema
	public static void doSkinChange(String tema) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (tema.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	//Devuelve una cadena de texto con información sobre la aplicación
	public String getInfo() {
		String info = String.format("%s %s.   %s\n\n%s\n%s\n%s", Texts.get("by"), Texts.get("name"), Texts.get("ies"),
				Texts.get("rights"), Texts.get("icons_by"), Texts.get("fagIcons_by"));
		return info;
	}


	// CONSTRUCTOR
	public ActionsControl(MainControl control, MyFrame jFrame) {
		this.control = control;
		plainFont = jFrame.getjPanel().getFont();
		boldFont = new Font(plainFont.getFontName(), Font.BOLD, plainFont.getSize() + 2);
	}

	// GETTERS
	public Font getBoldFont() {
		return boldFont;
	}

	public Font getPlainFont() {
		return plainFont;
	}

	public MainControl getControl() {
		return control;
	}
}
