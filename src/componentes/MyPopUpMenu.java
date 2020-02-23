package componentes;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import control.resources.Icons;
import listeners.ItemMenuListener;

public class MyPopUpMenu extends JPopupMenu{
	
	private static final long serialVersionUID = 11L;
	private JMenuItem menuItemCopy;
	private JMenuItem menuItemCut;
	private JMenuItem menuItemPaste;
	private JMenu menuEditSpecial;
	private JMenuItem menuItemNoFormat;
	private JMenuItem menuItemOnlyFormat;
	private JMenuItem menuItemSelectAll;
	private JMenuItem menuItemBold;
	private JMenuItem menuItemItalic;
	private JMenuItem menuItemUnderlined;
	private JMenuItem menuItemRight;
	private JMenuItem menuItemCenter;
	private JMenuItem menuItemLeft;
	private JMenuItem menuItemJustify;
	
	public MyPopUpMenu(MyFrame jFrame) {
		ItemMenuListener listener = new ItemMenuListener(jFrame);

		//instanciación de los componentes
		menuItemBold = new JMenuItem(Icons.boldM());
		menuItemItalic = new JMenuItem(Icons.italicM());
		menuItemUnderlined = new JMenuItem(Icons.underlineyM());
		menuItemCopy = new JMenuItem(Icons.copyM());
		menuItemCut = new JMenuItem(Icons.cutM());
		menuItemPaste = new JMenuItem(Icons.pasteM());
		menuEditSpecial = new JMenu();
		menuItemNoFormat = new JMenuItem(Icons.pasteNoFormatM());
		menuItemOnlyFormat = new JMenuItem(Icons.pasteNoTextM());
		menuItemSelectAll = new JMenuItem(Icons.selectAllM());
      
		//asignación de teclas rápidas (coincidiendo con las de la barra de menú)
		menuItemBold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menuItemItalic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		menuItemUnderlined.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		menuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));	
		menuItemNoFormat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));	
		menuItemOnlyFormat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		
		
		//asígación del listener o de los listener genéricos
		menuItemBold.addActionListener(new StyledEditorKit.BoldAction());
		menuItemItalic.addActionListener(new StyledEditorKit.ItalicAction());
		menuItemUnderlined.addActionListener(new StyledEditorKit.UnderlineAction());
		
		menuItemCopy.setActionCommand("Copy");
		menuItemCopy.addActionListener(listener);
		menuItemCut.setActionCommand("Cut");
		menuItemCut.addActionListener(listener);
		menuItemPaste.setActionCommand("Paste");
		menuItemPaste.addActionListener(listener);
		menuItemNoFormat.setActionCommand("OnlyText");
		menuItemNoFormat.addActionListener(listener);
		menuItemOnlyFormat.setActionCommand("OnlyFormat");
		menuItemOnlyFormat.addActionListener(listener);
		menuItemSelectAll.setActionCommand("SelectAll");
		menuItemSelectAll.addActionListener(listener);
		
		menuItemRight = new JMenuItem(Icons.alignRightM());
		menuItemLeft = new JMenuItem(Icons.alignLeftM());
		menuItemCenter = new JMenuItem(Icons.alignCenterM());
		menuItemJustify = new JMenuItem(Icons.justifyM());
		
		menuItemRight.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		menuItemLeft.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		menuItemJustify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
		
		menuItemLeft.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT));
		menuItemCenter.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_CENTER));
		menuItemRight.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_RIGHT));
		menuItemJustify.addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_JUSTIFIED));
		
		
		//se añaden los componentes
		this.add(menuItemBold);
	    this.add(menuItemItalic);
	    this.add(menuItemUnderlined);
	    this.addSeparator();
        this.add(menuItemCopy);
        this.add(menuItemCut);
        this.add(menuItemPaste);
        this.addSeparator();
        this.add(menuEditSpecial);
        menuEditSpecial.add(menuItemNoFormat);
        menuEditSpecial.add(menuItemOnlyFormat);
        this.addSeparator();
        this.add(menuItemLeft);
        this.add(menuItemCenter);
        this.add(menuItemRight);
        this.add(menuItemJustify);
        this.addSeparator();
        this.add(menuItemSelectAll);
        
	}
	
	
	//Getters            - necesarios para la coherencia
	public JMenuItem getRight() {
		return menuItemRight;
	}

	public JMenuItem getCenter() {
		return menuItemCenter;
	}

	public JMenuItem getLeft() {
		return menuItemLeft;
	}

	public JMenuItem getJustify() {
		return menuItemJustify;
	}

	public JMenuItem getMenuItemCopy() {
		return menuItemCopy;
	}
	public JMenuItem getMenuItemCut() {
		return menuItemCut;
	}
	public JMenuItem getMenuItemPaste() {
		return menuItemPaste;
	}
	public JMenu getMenuEditSpecial() {
		return menuEditSpecial;
	}
	public JMenuItem getNoFormat() {
		return menuItemNoFormat;
	}
	public JMenuItem getOnlyFormat() {
		return menuItemOnlyFormat;
	}
	public JMenuItem getSelectAll() {
		return menuItemSelectAll;
	}
	public JMenuItem getMenuItemBold() {
		return menuItemBold;
	}
	public JMenuItem getMenuItemItalic() {
		return menuItemItalic;
	}
	public JMenuItem getMenuItemUnderlined() {
		return menuItemUnderlined;
	}
}
