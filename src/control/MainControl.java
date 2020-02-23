package control;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import componentes.MyFrame;
import componentes.MyJTextPane;
import control.resources.Constants;
import control.resources.Texts;

public class MainControl {

	private ActionsControl actions;
	private ImageControler images;
	private FileControler files;
	private MyJTextPane jTextPane;
	private MyFrame jFrame;
	private JComboBox<String> fontsizeCB;
	private JComboBox<String> fontCB;
	private boolean fontCopied;
	private static boolean UIControled = false;

	/*	 Desde la clase MainControl se parametrizan los metodos que llegan vacios y se
	     llama a actions, files o images cuando es necesario	 */

	
	
	//abrir la ayuda 
	public void openHelp() {
		this.actions.doOpenHelp(jTextPane);
	}

	// cargar fichero
	public void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showOpenDialog(jTextPane);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fileChooser.getSelectedFile();
			this.files.doOpenFile(fichero.getAbsolutePath(), jTextPane.getStyledDocument());
		}
	}

	//guardar fichero
	public void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showSaveDialog(jTextPane);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fileChooser.getSelectedFile();
			this.files.doSaveFile(fichero.getAbsolutePath(), jTextPane.getStyledDocument());
		}
	}

	//limpiar documento
	public void newDocument() {
		this.actions.doNewDocument(jFrame);
	}
	
	//salir de la aplicación
	public void close() {
		this.actions.doClose(jFrame);
	}

	public void copy() {
		this.actions.doCopy(jTextPane);
	}

	public void cut() {
		this.actions.doCut(jTextPane);
	}

	public void paste() {
		this.actions.doPaste(jTextPane);

	}

	public void selectAll() {
		this.jTextPane.selectAll();
	}

	public void pasteOnlyText() {
		this.jTextPane.paste();
	}

	public void pasteOnlyFormat() {
		this.actions.doPasteOnlyFormat(jTextPane);
	}

	public void insertImage() {
		// seleccion de fichero
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showOpenDialog(jTextPane);

		// Iserción de la posible imagen del archivo
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			images.InsertIcon(jTextPane, new ImageIcon(file.getAbsolutePath()));
		}
	}

	
	// devuelve el indice de un  String dentro de un Array de Strings
	public static int getIndexIn(String[] arrayFrom, String toSearch) {
		for (int i = 0; i < arrayFrom.length; i++) {
			if (arrayFrom[i].equals(toSearch)) {
				return i;
			}
		}
		return -1;
	}

	//abre la ventana emergente con información sobre la aplicación
	public void showInfo() {
		String info = actions.getInfo();
		JOptionPane.showMessageDialog(jTextPane, info, Texts.get("title_window"), JOptionPane.INFORMATION_MESSAGE);
	}

	
	//Métodos de cambio de lenguaje
	
	public void chLanguageSpanish() {
		Locale locale = Locale.forLanguageTag("es");
		this.actions.doChangeLanguaje(locale, jFrame);
	}

	public void chLanguageEnglish() {
		Locale locale = Locale.ENGLISH;
		this.actions.doChangeLanguaje(locale, jFrame);
	}

	public void chLanguageItalian() {
		Locale locale = Locale.ITALIAN;
		this.actions.doChangeLanguaje(locale, jFrame);
	}

	public void chLanguageGerman() {
		Locale locale = Locale.GERMAN;
		this.actions.doChangeLanguaje(locale, jFrame);
	}

	public void chLanguageFrench() {
		Locale locale = Locale.FRENCH;
		this.actions.doChangeLanguaje(locale, jFrame);
	}

	
	//cambio de apariencia
	public void skinChange(String skin) {
		
		//cambio de apariencia
		ActionsControl.doSkinChange(skin);
		
		//coherencia de la apariencia
		this.actions.ajustSkinFont(jFrame, skin);

		// orden para recargar toda la apariencia general
		SwingUtilities.updateComponentTreeUI(jFrame);
	}

	//abrir menu de idiomas
	public void openLagChooser() {
		this.actions.doOpenLagChooser(jFrame);
	}

	
	public void changeFontSize() {
		if (!UIControled) {
			int size = Integer.parseInt((String) fontsizeCB.getSelectedItem());
			this.actions.doChangeFontSize(size, jTextPane);
		}
	}

	public void changeFont() {
		if (!UIControled) {
			String font = (String) fontCB.getSelectedItem();
			this.actions.doChangeFont(font, jTextPane);
		}
	}

	public void changeFontSizeFromMenu() {
		JComboBox<String> jcb = new JComboBox<String>(Constants.FONT_SIZE_LIST);
		
		// Dialogo emergente con las opciones
		JOptionPane.showMessageDialog(null, jcb, Texts.get("label_size"), JOptionPane.QUESTION_MESSAGE);
		this.actions.doChangeFontSize(Integer.parseInt((String) jcb.getSelectedItem()), jTextPane);

	}

	public void changeFontFromMenu() {
		JComboBox<String> jcb = new JComboBox<String>(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		
		// Dialogo emergente con las opciones
		JOptionPane.showMessageDialog(jTextPane, jcb, Texts.get("label_font"), JOptionPane.QUESTION_MESSAGE);
		this.actions.doChangeFont((String) jcb.getSelectedItem(), jTextPane);

	}

	//obtención de un icono en función del lenguaje seleccionado
	public static Icon getLanguageIcon() {
		String language = Texts.getLocale().toString().substring(0, 2);
		return ActionsControl.getLocIcon(language);
	}

	public void changeColor() {
		/*
		 * Este método esta mal en los apuntes de la tarea del curso, no se accede a el
		 * de forma estática
		 */
		Color newColor = JColorChooser.showDialog(null, Texts.get("color_chooser"), Color.BLACK);
		this.actions.doChangeColor(newColor);
	}

	// Constructor
	public MainControl(MyFrame jFrame) {
		this.jFrame = jFrame;
		this.jTextPane = jFrame.getjPanel().getjTextPane();
		this.actions = new ActionsControl(this, jFrame);
		this.images = new ImageControler();
		this.files = new FileControler();
		this.fontCopied = false;
	}

	/*	 No se pueden llevar a cabo estos Setters en el contrucctor por que las
	 referencias a estos Componentes aun son nulas	 */
	public void setComponents(MyFrame jFrame) {
		this.fontCB = jFrame.getjPanel().getjToolBar().getFontsCombo();
		this.fontsizeCB = jFrame.getjPanel().getjToolBar().getSizeCombo();
	}

	// GETTERS AND SETTERS

	public ActionsControl getActions() {
		return actions;
	}

	public boolean isFontCopied() {
		return fontCopied;
	}

	public void setFontCopied(boolean fontCopied) {
		this.fontCopied = fontCopied;
	}

	public void setActions(ActionsControl actions) {
		this.actions = actions;
	}

	public MyJTextPane getjTextPane() {
		return jTextPane;
	}

	public void setjTextPane(MyJTextPane jTextPane) {
		this.jTextPane = jTextPane;
	}

	public static boolean isUIControled() {
		return UIControled;
	}

	public static void setUIControled(boolean uIControled) {
		UIControled = uIControled;
	}
}
