package componentes;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import control.MainControl;
import control.resources.Constants;
import control.resources.Icons;
import control.resources.Texts;
import listeners.ItemMenuListener;

public class MyToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JButton saveButton;
	private JButton loadButton;
	private JButton exitButton;
	private JLabel fontLabel;
	private JComboBox<String> fontsCombo;
	private JLabel sizeLabel;
	private JComboBox<String> sizeCombo;
	private JToggleButton boldButton;
	private JToggleButton italicButton;
	private JToggleButton underlineButton;
	private JToggleButton rightAlignButton;
	private JToggleButton centerAlignButton;
	private JToggleButton leftAlignButton;
	private JToggleButton justifyAlignButton;
	private JButton fontColorButton;
	private MyLanguagePopUp languagePopUp;
	private JButton languageButton;

	public MyToolBar(MyFrame jFrame) {

		this.setFocusable(false);
		
		//instanciación del listener
		ItemMenuListener itemMenuListener = new ItemMenuListener(jFrame);
		
		//creación de los elementos
		saveButton = new JButton(Icons.saveT());
		loadButton = new JButton(Icons.openT());
		exitButton = new JButton(Icons.exitT());
		
		//asignación de tamaño
		saveButton.setPreferredSize(Constants.BUTTON_SIZE);
		loadButton.setPreferredSize(Constants.BUTTON_SIZE);
		exitButton.setPreferredSize(Constants.BUTTON_SIZE);
		
		//Focus = false para que no se pierda el curor del texto
		saveButton.setFocusable(false);
		loadButton.setFocusable(false);
		exitButton.setFocusable(false);

		//asignación de acciones
		loadButton.setActionCommand("Open");
		saveButton.setActionCommand("Save");
		exitButton.setActionCommand("Close");

		//asignación de listeners
		loadButton.addActionListener(itemMenuListener);
		saveButton.addActionListener(itemMenuListener);
		exitButton.addActionListener(itemMenuListener);

		// Mensajes emergentes
		saveButton.setToolTipText(Texts.get("menu_file_open"));
		loadButton.setToolTipText(Texts.get("menu_file_save"));
		exitButton.setToolTipText(Texts.get("menu_file_exit"));

		//texto de apoyo al JConbobox
		fontLabel = new JLabel();
		fontLabel.setFocusable(false);
		
		
		//construccion del combobox
		fontsCombo = new JComboBox<String>(this.getFontList());
		
		//seleccion de la fuente predeterminada
		fontsCombo.setSelectedIndex(MainControl.getIndexIn(this.getFontList(),Constants.INITIAL_FONT));
		fontsCombo.setFocusable(true);
		fontsCombo.setActionCommand("ChangeFont");
		fontsCombo.addActionListener(itemMenuListener);
		//tamaño máximo para que no se expanda por toda la barra 
		fontsCombo.setMaximumSize(new Dimension(180, 100));

		sizeLabel = new JLabel();
		sizeLabel.setFocusable(false);

		sizeCombo = new JComboBox<String>(Constants.FONT_SIZE_LIST);
		sizeCombo.setSelectedIndex(MainControl.getIndexIn(Constants.FONT_SIZE_LIST,Constants.INITIAL_FONT_SIZE+""));
		sizeCombo.setFocusable(true);
		sizeCombo.setActionCommand("ChangeSize");
		sizeCombo.addActionListener(itemMenuListener);
		sizeCombo.setMaximumSize(new Dimension(55, 35));

		leftAlignButton = new JToggleButton(Icons.alignLeftT());
		centerAlignButton = new JToggleButton(Icons.alignCenterT());
		rightAlignButton = new JToggleButton(Icons.alignRightT());
		justifyAlignButton = new JToggleButton(Icons.justifyT());
		rightAlignButton.setPreferredSize(Constants.BUTTON_SIZE);
		centerAlignButton.setPreferredSize(Constants.BUTTON_SIZE);
		leftAlignButton.setPreferredSize(Constants.BUTTON_SIZE);
		justifyAlignButton.setPreferredSize(Constants.BUTTON_SIZE);
		
		leftAlignButton.setFocusable(false);
		centerAlignButton.setFocusable(false);
		rightAlignButton.setFocusable(false);
		justifyAlignButton.setFocusable(false);

		boldButton = new JToggleButton(Icons.boldT());
		italicButton = new JToggleButton(Icons.italicT());
		underlineButton = new JToggleButton(Icons.underlineT());
		boldButton.setPreferredSize(Constants.BUTTON_SIZE);
		italicButton.setPreferredSize(Constants.BUTTON_SIZE);
		underlineButton.setPreferredSize(Constants.BUTTON_SIZE);

		// mensaje emergentes
		italicButton.setToolTipText(Texts.get("menu_format_text_italic"));
		boldButton.setToolTipText(Texts.get("menu_format_text_bold"));
		underlineButton.setToolTipText(Texts.get("menu_format_text_underline"));
		leftAlignButton.setToolTipText(Texts.get("menu_format_align_left"));
		centerAlignButton.setToolTipText(Texts.get("menu_format_align_center"));
		rightAlignButton.setToolTipText(Texts.get("menu_format_align_right"));
		justifyAlignButton.setToolTipText(Texts.get("menu_format_align_justify"));

		boldButton.addActionListener(new StyledEditorKit.BoldAction());
		italicButton.addActionListener(new StyledEditorKit.ItalicAction());
		underlineButton.addActionListener(new StyledEditorKit.UnderlineAction());
		leftAlignButton.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT));
		centerAlignButton.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_CENTER));
		rightAlignButton.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_RIGHT));
		justifyAlignButton.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_JUSTIFIED));
		
		boldButton.setFocusable(false);
		italicButton.setFocusable(false);
		underlineButton.setFocusable(false);

		fontColorButton = new JButton(Icons.fontColorT());
		fontColorButton.setPreferredSize(Constants.BUTTON_SIZE);
		fontColorButton.setToolTipText(Texts.get("menu_format_color"));

		fontColorButton.addActionListener(itemMenuListener);
		fontColorButton.setActionCommand("ValidateColor");
		fontColorButton.setFocusable(false);

		languageButton = new JButton(MainControl.getLanguageIcon());
		languageButton.setPreferredSize(Constants.BUTTON_SIZE);
		languageButton.setFocusable(false);
		languageButton.setToolTipText(Texts.get("menu_options_language"));

		languagePopUp = new MyLanguagePopUp(jFrame);
		languageButton.setActionCommand("ChangeLanguage");
		languageButton.addActionListener(itemMenuListener);

		
		//e añaden los componentes
		this.add(saveButton);
		this.add(loadButton);
		this.add(exitButton);
		this.addSeparator();
		this.add(fontLabel);
		this.add(fontsCombo);
		this.addSeparator();
		this.add(sizeLabel);
		this.add(sizeCombo);
		this.addSeparator();
		this.add(boldButton);
		this.add(italicButton);
		this.add(underlineButton);
		this.addSeparator();
		this.add(leftAlignButton);
		this.add(centerAlignButton);
		this.add(rightAlignButton);
		this.add(justifyAlignButton);
		this.addSeparator();
		this.add(fontColorButton);
		this.addSeparator();
		this.add(languageButton);

		// La barra no se puede coger y arrastrar a otra posición ni extraer de la ventana
		this.setFloatable(false);

	}

	//Obtención de la fuentes instaladas en el sistema
	private String[] getFontList() {
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		return fonts;
	}


	// GETTERS

	public MyLanguagePopUp getLanguagePopUp() {
		return languagePopUp;
	}

	public JComboBox<String> getFontsCombo() {
		return fontsCombo;
	}

	public JComboBox<String> getSizeCombo() {
		return sizeCombo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public JLabel getFontLabel() {
		return fontLabel;
	}

	public JLabel getSizeLabel() {
		return sizeLabel;
	}

	public JToggleButton getBoldButton() {
		return boldButton;
	}

	public JToggleButton getItalicButton() {
		return italicButton;
	}

	public JToggleButton getUnderlineButton() {
		return underlineButton;
	}

	public JToggleButton getRightAlignButton() {
		return rightAlignButton;
	}

	public JToggleButton getCenterAlignButton() {
		return centerAlignButton;
	}

	public JToggleButton getLeftAlignButton() {
		return leftAlignButton;
	}

	public JToggleButton getJustifyAlignButton() {
		return justifyAlignButton;
	}

	public JButton getFontColorButton() {
		return fontColorButton;
	}

	public JButton getLanguageButton() {
		return languageButton;
	}

}
