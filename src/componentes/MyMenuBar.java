package componentes;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import control.resources.Icons;
import listeners.ItemMenuListener;

public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = 13L;

	private JMenu menuFile;
		
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem newDocumentItem;
	private JMenuItem exitItem;
	
	private JMenu editMenu;
	
	private JMenuItem copyItem;
	private JMenuItem cutItem;
	private JMenuItem pasteItem;
	private JMenu specialEditMenu;
	private JMenuItem noFormatItem;
	private JMenuItem onlyFormatItem;
	private JMenuItem selectAllItem;
	
	private JMenu insertMenu;
	
	private JMenuItem imageItem;
	
	private JMenu formatMenu;
	
	private JMenu textMenu;
	private JMenuItem boldItem;
	private JMenuItem italicItem;
	private JMenuItem underlinedItem;
	private JMenuItem sizeItem;
	private JMenuItem fontItem;
	private JMenu paragraphMenu;
	private JMenu alignMenu;
	private JMenuItem rightItem;
	private JMenuItem centerItem;
	private JMenuItem leftItem;
	private JMenuItem justifyItem;
	private JMenuItem colorItem;
	
	private JMenu optionsMenu;
	
	private JMenu languageItem;
	private JMenuItem spanishItem;
	private JMenuItem englishItem;
	private JMenuItem italianItem;
	private JMenuItem germanItem;
	private JMenuItem frenchItem;
	private JMenu menuSkin;
	
	private JMenu helpMenu;
	
	private JMenuItem helpItem;
	private JMenuItem aboutItem;
	
	
	public MyMenuBar(MyFrame jFrame) {
		
		//Creación del listener que se implementará a casi todos los MenuItems
		ItemMenuListener listener = new ItemMenuListener(jFrame);
		
		//Construcción del menú (Herencia entre menús e items e iconos)
		// estructurado por grupos para que sea mas visible 
		menuFile = new JMenu();
			openItem = new JMenuItem(Icons.openM());
			saveItem = new JMenuItem(Icons.saveM());
			newDocumentItem = new JMenuItem(Icons.newM());
			exitItem = new JMenuItem(Icons.exitM());
			
			//nombre de las acciones para que diferencie el listener
			openItem.setActionCommand("Open");
			saveItem.setActionCommand("Save");
			newDocumentItem.setActionCommand("NewDoc");
			exitItem.setActionCommand("Close");
			
			//asignación del listener
			openItem.addActionListener(listener);
			saveItem.addActionListener(listener);
			newDocumentItem.addActionListener(listener);
			exitItem.addActionListener(listener);
			
			
		//Accesos rápidos de teclado
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));	
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
			
		this.add(menuFile);
		menuFile.add(openItem);
		menuFile.add(saveItem);
		menuFile.add(newDocumentItem);
		menuFile.addSeparator();
		menuFile.add(exitItem);
		
		//estructuras tabuladas según herencia para facilitar la vista
		editMenu = new JMenu();
			copyItem = new JMenuItem(Icons.copyM());
			cutItem = new JMenuItem(Icons.cutM());
			pasteItem = new JMenuItem(Icons.pasteM());
			specialEditMenu = new JMenu();
				noFormatItem = new JMenuItem(Icons.pasteNoFormatM());
				onlyFormatItem = new JMenuItem(Icons.pasteNoTextM());
			selectAllItem = new JMenuItem(Icons.selectAllM());
			
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));	
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));	
		noFormatItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));	
		onlyFormatItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		
		copyItem.setActionCommand("Copy");
		copyItem.addActionListener(listener);
		cutItem.setActionCommand("Cut");
		cutItem.addActionListener(listener);
		pasteItem.setActionCommand("Paste");
		pasteItem.addActionListener(listener);
		selectAllItem.setActionCommand("SelectAll");
		selectAllItem.addActionListener(listener);
		
		noFormatItem.setActionCommand("OnlyText");
		noFormatItem.addActionListener(listener);
		onlyFormatItem.setActionCommand("OnlyFormat");
		onlyFormatItem.addActionListener(listener);
		
		
		
		
		this.add(editMenu);
		editMenu.add(copyItem);
		editMenu.add(cutItem);
		editMenu.add(pasteItem);
		editMenu.add(specialEditMenu);
		specialEditMenu.add(noFormatItem);
		specialEditMenu.add(onlyFormatItem);
		editMenu.add(selectAllItem);

		insertMenu = new JMenu();
			imageItem = new JMenuItem(Icons.imageM());
		
		this.add(insertMenu);
		insertMenu.add(imageItem);
		
		imageItem.setActionCommand("insertImage");
		imageItem.addActionListener(listener);
		
		formatMenu = new JMenu();
			textMenu = new JMenu();
				boldItem = new JMenuItem(Icons.boldM());
				italicItem = new JMenuItem(Icons.italicM());
				underlinedItem = new JMenuItem(Icons.underlineyM());
				sizeItem = new JMenuItem(Icons.siceM());
				fontItem = new JMenuItem(Icons.fontM());
			paragraphMenu = new JMenu();
				alignMenu = new JMenu();
					rightItem = new JMenuItem(Icons.alignRightM());
					leftItem = new JMenuItem(Icons.alignLeftM());
					centerItem = new JMenuItem(Icons.alignCenterM());
					justifyItem = new JMenuItem(Icons.justifyM());
			colorItem = new JMenuItem(Icons.fontColorM());
		
		boldItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		italicItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		underlinedItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		rightItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		leftItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		justifyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
			
		boldItem.addActionListener(new StyledEditorKit.BoldAction());
		italicItem.addActionListener(new StyledEditorKit.ItalicAction());
		underlinedItem.addActionListener(new StyledEditorKit.UnderlineAction());
		sizeItem.setActionCommand("ChangeSizeFromMenu");
		sizeItem.addActionListener(listener);
		fontItem.setActionCommand("ChangeFontFromMenu");
		fontItem.addActionListener(listener);
		leftItem.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT));
		centerItem.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_CENTER));
		rightItem.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_RIGHT));
		justifyItem.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_JUSTIFIED));
		
		colorItem.setActionCommand("ValidateColor");
		colorItem.addActionListener(listener);
		
		
		this.add(formatMenu);
		formatMenu.add(textMenu);
		textMenu.add(boldItem);
		textMenu.add(italicItem);
		textMenu.add(underlinedItem);
		textMenu.addSeparator();
		textMenu.add(sizeItem);
		textMenu.add(fontItem);
		formatMenu.add(paragraphMenu);
		paragraphMenu.add(alignMenu);
		alignMenu.add(leftItem);
		alignMenu.add(centerItem);
		alignMenu.add(rightItem);
		alignMenu.add(justifyItem);
		formatMenu.add(colorItem);		
		
		optionsMenu = new JMenu();
			languageItem = new JMenu();
				spanishItem = new JMenuItem(Icons.SpainM());
				englishItem = new JMenuItem(Icons.UnitedKindomM());
				italianItem = new JMenuItem(Icons.ItalyM());
				germanItem = new JMenuItem(Icons.GermanyM());
				frenchItem = new JMenuItem(Icons.FranceM());
			menuSkin = new MySkniJMenu(jFrame);
							
		this.add(optionsMenu);
		optionsMenu.add(languageItem);
		languageItem.add(spanishItem);
		languageItem.add(englishItem);
		languageItem.add(italianItem);
		languageItem.add(germanItem);
		languageItem.add(frenchItem);
		optionsMenu.add(menuSkin);
				
		spanishItem.addActionListener(listener);
		spanishItem.setActionCommand("Spanish");
		englishItem.addActionListener(listener);
		englishItem.setActionCommand("English");
		italianItem.addActionListener(listener);
		italianItem.setActionCommand("Italian");
		germanItem.addActionListener(listener);
		germanItem.setActionCommand("German");
		frenchItem.addActionListener(listener);
		frenchItem.setActionCommand("French");
		
		menuSkin.setActionCommand("Skin");
		menuSkin.addActionListener(listener);

		helpMenu = new JMenu();
			helpItem = new JMenuItem();
			aboutItem = new JMenuItem();
		
		helpItem.setActionCommand("Help");
		aboutItem.setActionCommand("About");
		helpItem.addActionListener(listener);
		aboutItem.addActionListener(listener);
		
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.CTRL_DOWN_MASK));
		
		
		this.add(helpMenu);
		helpMenu.add(helpItem);
		helpMenu.add(aboutItem);
		
	}
	// GETTERS    , SETTERS No son necesarios 
	
	public JMenu getMenuFile() {
		return menuFile;
	}
	public JMenuItem getHelpItem() {
		return helpItem;
	}
	public JMenuItem getAbout() {
		return aboutItem;
	}
	public JMenuItem getOpen() {
		return openItem;
	}
	public JMenuItem getSave() {
		return saveItem;
	}
	public JMenuItem getNewDoc() {
		return newDocumentItem;
	}
	public JMenuItem getExit() {
		return exitItem;
	}
	public JMenu getMenuEdit() {
		return editMenu;
	}
	public JMenuItem getCopy() {
		return copyItem;
	}
	public JMenuItem getCut() {
		return cutItem;
	}
	public JMenuItem getPaste() {
		return pasteItem;
	}
	public JMenu getMenuEditSpecial() {
		return specialEditMenu;
	}
	public JMenuItem getNoFormat() {
		return noFormatItem;
	}
	public JMenuItem getOnlyFormat() {
		return onlyFormatItem;
	}
	public JMenuItem getSelectAll() {
		return selectAllItem;
	}
	public JMenu getMenuInsert() {
		return insertMenu;
	}
	public JMenuItem getImage() {
		return imageItem;
	}
	public JMenu getMenuFormat() {
		return formatMenu;
	}
	public JMenu getMenuText() {
		return textMenu;
	}
	public JMenuItem getBold() {
		return boldItem;
	}
	public JMenuItem getItalic() {
		return italicItem;
	}
	public JMenuItem getUnderlined() {
		return underlinedItem;
	}
	public JMenuItem getSizeItem() {
		return sizeItem;
	}
	public JMenuItem getFontItem() {
		return fontItem;
	}
	public JMenu getMenuParraf() {
		return paragraphMenu;
	}
	public JMenu getMenuAlign() {
		return alignMenu;
	}
	public JMenuItem getRight() {
		return rightItem;
	}
	public JMenuItem getCenter() {
		return centerItem;
	}
	public JMenuItem getLeft() {
		return leftItem;
	}
	public JMenuItem getJustify() {
		return justifyItem;
	}
	public JMenuItem getColor() {
		return colorItem;
	}
	public JMenu getMenuOptions() {
		return optionsMenu;
	}
	public JMenu getLanguage() {
		return languageItem;
	}
	public JMenuItem getSpanish() {
		return spanishItem;
	}
	public JMenuItem getEnglish() {
		return englishItem;
	}
	public JMenuItem getItalian() {
		return italianItem;
	}
	public JMenuItem getGerman() {
		return germanItem;
	}
	public JMenuItem getFrench() {
		return frenchItem;
	}
	public JMenu getSkin() {
		return menuSkin;
	}
	public JMenu getMenuHelp() {
		return helpMenu;
	}
}