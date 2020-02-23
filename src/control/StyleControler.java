package control;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import componentes.MyFrame;
import componentes.MyJTextPane;
import componentes.MyMenuBar;
import componentes.MyPopUpMenu;
import componentes.MyToolBar;
import control.resources.Constants;

public class StyleControler implements Runnable {

	private boolean running;
	private MyJTextPane jTextPane;
	private MyToolBar jtToolBar;
	private MyMenuBar jMenuBar;
	private MyPopUpMenu jPopUpMenu;
	private final Font boldFont;
	private final Font plainFont;
	private String font, size;
	private AttributeSet sa;
	private int position;
	private JComboBox<String> fontsCB, sizesCB;
	private String systemFonts[];

	public StyleControler(MyFrame jFrame) {
		this.running = true;
		this.jTextPane = jFrame.getjPanel().getjTextPane();
		this.jtToolBar = jFrame.getjPanel().getjToolBar();
		this.jMenuBar = jFrame.getjMenuBar();
		this.jPopUpMenu = jFrame.getjPanel().getjTextPane().getjPopUpMenu();
		this.fontsCB = jFrame.getjPanel().getjToolBar().getFontsCombo();
		this.sizesCB = jFrame.getjPanel().getjToolBar().getSizeCombo();
		this.systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		Font menufont = jMenuBar.getFont();
		boldFont = new Font(menufont.getFontName(), Font.BOLD, menufont.getSize() + 2);
		plainFont = new Font(menufont.getFontName(), Font.PLAIN, menufont.getSize());

	}

	@Override
	public void run() {

		while (running) {
			try {
				// una pequeña pausa para no sobrecargar el sistema
				Thread.sleep(100);
				/*
				 * Si hay texto seleccionado obtiene los atributos del estilo del primer
				 * character
				 */
				if (jTextPane.getSelectedText() != null) {
					position = jTextPane.getSelectionStart();
					sa = jTextPane.getStyledDocument().getCharacterElement(position).getAttributes();

					// si no hay texto seleccionado obtiene los atributos del estilo de la poición
					// del cursor
				} else {
					position = jTextPane.getCaretPosition();
					sa = jTextPane.getCharacterAttributes();

					// Si se encuentra al final del texto obtiene los atributos de estilo de entrada
					if (position == jTextPane.getText().length()) {
						sa = jTextPane.getInputAttributes();
					}
				}
				// control de los atributos de estilo
				if (sa.containsAttribute(StyleConstants.Bold, true)) {
					this.setBold(true);
				} else {
					this.setBold(false);
				}
				if (sa.containsAttribute(StyleConstants.Italic, true)) {
					this.setItalic(true);
				} else {
					this.setItalic(false);
				}
				if (sa.containsAttribute(StyleConstants.Underline, true)) {
					this.setUnderlined(true);
				} else {
					this.setUnderlined(false);
				}
				// Se obtiene el nombre de la fuente

				font = jTextPane.getStyledDocument().getFont(sa).getFontName();
				size = String.format("%s", jTextPane.getStyledDocument().getFont(sa).getSize());

				// Se eliminan los sufijos de estilo si los hay
				if (font.lastIndexOf(' ') > 0) {
					if (font.substring(font.lastIndexOf(' ')).equals(" Italic")) {
						font = font.substring(0, font.lastIndexOf(' '));
					}
				}
				if (font.lastIndexOf(' ') > 0) {
					if (font.substring(font.lastIndexOf(' ')).equals(" Bold")) {
						font = font.substring(0, font.lastIndexOf(' '));
					}
				}

				// se establecen en los JConboBo los valores apropiados

				if (jTextPane.isFocusOwner()) {
					// si no se establece este if no deja al usuario cambiar de fuente

					MainControl.setUIControled(true);
					fontsCB.setSelectedIndex(MainControl.getIndexIn(systemFonts, font));
					MainControl.setUIControled(false);
				}
				if (jTextPane.isFocusOwner()) {
					MainControl.setUIControled(true);
					sizesCB.setSelectedIndex(MainControl.getIndexIn(Constants.FONT_SIZE_LIST, size));
					MainControl.setUIControled(false);
				}

				// Se obtienen los atributos del parrafo donde se encuentre el cursor.
				sa = jTextPane.getParagraphAttributes();

				// control de los atributos de alineado
				if (sa.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_RIGHT)) {
					this.setRighAlignedComponents();
				} else if (sa.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_CENTER)) {
					this.setCenterAlignedComponents();
				} else if (sa.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED)) {
					this.setJustifiedAlignedComponents();
				} else {
					this.setLeftAlignedComponents();
				}

			} catch (Exception e) {
				System.out.println(e.getMessage() + "from StyleControler");
				e.printStackTrace();
			}
		}

	}

	// Métodos en la propia clase para evitar colapsos
	public void setLeftAlignedComponents() {
		jtToolBar.getLeftAlignButton().setSelected(true);
		jtToolBar.getRightAlignButton().setSelected(false);
		jtToolBar.getCenterAlignButton().setSelected(false);
		jtToolBar.getJustifyAlignButton().setSelected(false);
		jMenuBar.getLeft().setFont(boldFont);
		jMenuBar.getRight().setFont(plainFont);
		jMenuBar.getCenter().setFont(plainFont);
		jMenuBar.getJustify().setFont(plainFont);
		jPopUpMenu.getLeft().setFont(boldFont);
		jPopUpMenu.getRight().setFont(plainFont);
		jPopUpMenu.getCenter().setFont(plainFont);
		jPopUpMenu.getJustify().setFont(plainFont);

	}

	public void setRighAlignedComponents() {
		jtToolBar.getLeftAlignButton().setSelected(false);
		jtToolBar.getRightAlignButton().setSelected(true);
		jtToolBar.getCenterAlignButton().setSelected(false);
		jtToolBar.getJustifyAlignButton().setSelected(false);
		jMenuBar.getLeft().setFont(plainFont);
		jMenuBar.getRight().setFont(boldFont);
		jMenuBar.getCenter().setFont(plainFont);
		jMenuBar.getJustify().setFont(plainFont);
		jPopUpMenu.getLeft().setFont(plainFont);
		jPopUpMenu.getRight().setFont(boldFont);
		jPopUpMenu.getCenter().setFont(plainFont);
		jPopUpMenu.getJustify().setFont(plainFont);
	}

	public void setCenterAlignedComponents() {
		jtToolBar.getLeftAlignButton().setSelected(false);
		jtToolBar.getRightAlignButton().setSelected(false);
		jtToolBar.getCenterAlignButton().setSelected(true);
		jtToolBar.getJustifyAlignButton().setSelected(false);
		jMenuBar.getLeft().setFont(plainFont);
		jMenuBar.getRight().setFont(plainFont);
		jMenuBar.getCenter().setFont(boldFont);
		jMenuBar.getJustify().setFont(plainFont);
		jPopUpMenu.getLeft().setFont(plainFont);
		jPopUpMenu.getRight().setFont(plainFont);
		jPopUpMenu.getCenter().setFont(boldFont);
		jPopUpMenu.getJustify().setFont(plainFont);
	}

	public void setJustifiedAlignedComponents() {
		jtToolBar.getLeftAlignButton().setSelected(false);
		jtToolBar.getRightAlignButton().setSelected(false);
		jtToolBar.getCenterAlignButton().setSelected(false);
		jtToolBar.getJustifyAlignButton().setSelected(true);
		jMenuBar.getLeft().setFont(plainFont);
		jMenuBar.getRight().setFont(plainFont);
		jMenuBar.getCenter().setFont(plainFont);
		jMenuBar.getJustify().setFont(boldFont);
		jPopUpMenu.getLeft().setFont(plainFont);
		jPopUpMenu.getRight().setFont(plainFont);
		jPopUpMenu.getCenter().setFont(plainFont);
		jPopUpMenu.getJustify().setFont(boldFont);
	}

	public void setBold(boolean isBold) {
		jtToolBar.getBoldButton().setSelected(isBold);
		Font font = jMenuBar.getBold().getFont();
		if (isBold) {
			font = boldFont;
		} else {
			font = plainFont;
		}
		jMenuBar.getBold().setFont(font);
		jPopUpMenu.getMenuItemBold().setFont(font);
	}

	public void setItalic(boolean isItalic) {
		jtToolBar.getItalicButton().setSelected(isItalic);
		Font font = jMenuBar.getItalic().getFont();
		if (isItalic) {
			font = boldFont;
		} else {
			font = plainFont;
		}
		jMenuBar.getItalic().setFont(font);
		jPopUpMenu.getMenuItemItalic().setFont(font);
	}

	public void setUnderlined(boolean isUnderlined) {
		jtToolBar.getUnderlineButton().setSelected(isUnderlined);
		Font font = jMenuBar.getUnderlined().getFont();
		if (isUnderlined) {
			font = boldFont;
		} else {
			font = plainFont;
		}
		jMenuBar.getUnderlined().setFont(font);
		jPopUpMenu.getMenuItemUnderlined().setFont(font);
	}

}
