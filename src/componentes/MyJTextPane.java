package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import control.actions.CopyAction;
import control.actions.CutAction;
import control.actions.PasteAction;
import control.resources.Constants;

public class MyJTextPane extends JTextPane {

	private static final long serialVersionUID = 112L;
	private MyPopUpMenu jPopUpMenu;
	private MyFrame jFrame;

	public MyJTextPane(MyFrame jFrame) {
		
		//instanciación de los componentes y asignación de referencias
		jPopUpMenu = new MyPopUpMenu(jFrame);
		this.setComponentPopupMenu(jPopUpMenu);
		this.jFrame = jFrame;
		
		//Se añaden márgenes al texto
		this.setBorder(BorderFactory.createCompoundBorder(
		        this.getBorder(), 
		        BorderFactory.createEmptyBorder(3, 45, 3, 45)));
		
		// Se sobreecriben las combinaciones de teclas predeterminadas por otras
		this.getInputMap().put(KeyStroke.getKeyStroke("control C"), "MyCopyKeyStroke");
		this.getInputMap().put(KeyStroke.getKeyStroke("control X"), "MyCutKeyStroke");
		this.getInputMap().put(KeyStroke.getKeyStroke("control V"), "MyPasteKeyStroke");
		
		// de añaden las acciones modificadas con las claves apropiadas
		this.getActionMap().put("MyCopyKeyStroke", new CopyAction(jFrame));
		this.getActionMap().put("MyCutKeyStroke", new CutAction(jFrame));
		this.getActionMap().put("MyPasteKeyStroke", new PasteAction(jFrame));
		
	}

	public void newDocument() {
		this.setText("");
		/* Estilos del documento inicial */
		new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT).actionPerformed(null);
		new StyledEditorKit.ForegroundAction(null, Color.BLACK).actionPerformed(null);
		new StyledEditorKit.FontFamilyAction(null, Constants.INITIAL_FONT).actionPerformed(null);
		new StyledEditorKit.FontSizeAction(null, Constants.INITIAL_FONT_SIZE).actionPerformed(null);

		//se desacen los posibles efectos de etilo.
		MyToolBar jToolBar= jFrame.getjPanel().getjToolBar();
		if ( jToolBar.getBoldButton().isSelected() ) {
			new StyledEditorKit.BoldAction().actionPerformed(null);
		}
		if ( jToolBar.getItalicButton().isSelected() ) {
			new StyledEditorKit.ItalicAction().actionPerformed(null);
		}
		if ( jToolBar.getUnderlineButton().isSelected() ) {
			new StyledEditorKit.UnderlineAction().actionPerformed(null);
		}

		/*  Esta linea es necesaria para la privera vez que se carga el programa por que
		  	StyledEditorkit detecta que no se ha hecho nada y no realiza algunos cambios		 */
		this.setFont(new Font(Constants.INITIAL_FONT, Font.PLAIN, Constants.INITIAL_FONT_SIZE));
		
		
	}

	// GETTER
	public MyPopUpMenu getjPopUpMenu() {
		return jPopUpMenu;
	}
}