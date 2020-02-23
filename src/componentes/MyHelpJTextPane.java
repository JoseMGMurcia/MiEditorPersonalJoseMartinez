package componentes;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import control.resources.Constants;

public class MyHelpJTextPane extends JTextPane{

	private static final long serialVersionUID = 19L;

	//contructor privado para obligar a obtener la instancia encapsulada en un JScrollPane por medio del método getCompleteHelpPanel()
	private MyHelpJTextPane() {
		this.setText(this.getHelpText());
		this.formatTextHelp();
		this.setEditable(false);
		this.setCaretPosition(0);
		this.setBorder(BorderFactory.createCompoundBorder(
		        this.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 15, 5, 15)));
	}
	
	
	//este método devuelve un panel con la ayuda listo para insertar en un Joption Pane
	public static JScrollPane getCompleteHelpPanel() {
		MyHelpJTextPane myHelpJTextPane = new MyHelpJTextPane();
		JScrollPane jScrollPane = new JScrollPane(myHelpJTextPane);
		return jScrollPane;
	}
	
	
	//formateado del texto de ayuda
	private void formatTextHelp() {
		SimpleAttributeSet sa = new SimpleAttributeSet();
		
		//se van añadiendo matices de importancia al texto en orden creciente
		sa.addAttribute(StyleConstants.FontFamily, Constants.INITIAL_FONT);
		sa.addAttribute(StyleConstants.Bold, true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Copy"), 4, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Cut"), 3, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Paste"), 5, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Special Paste"), 13, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Only format"), 11, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Insert image"), 12, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Italic"), 6, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Bold"), 4, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Underlined"), 10, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Size"), 4, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Font"), 4, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Text Color"), 10, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Left"), 4, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Center"), 6, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Right"), 5, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Justify"), 7, sa,true);
		
		sa.addAttribute(StyleConstants.Size, 16);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("CLIPBOARD"), 9, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("TEXT FORMAT"), 11, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("PARRAGRAPH"), 10, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Language"), 8, sa,true);
		this.getStyledDocument().setCharacterAttributes(this.getHelpText().indexOf("Appearance"), 10, sa,true);
		
		sa.addAttribute(StyleConstants.Size, 20);
		this.getStyledDocument().setCharacterAttributes(0, 29, sa,true);
		
		sa.addAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_CENTER);
		this.getStyledDocument().setParagraphAttributes(2, 2, sa, true);
	}
	
	private String getHelpText() {
		String helpText = "Text editor help (English) \n\nThe editor is composed by a menu bar where you can find all actions you can do whitin it, a tool bar where the most useful actión are displayed, and a text field where the user can edit the document or create a new one.";
		helpText = String.format("%s\n%s",helpText, "\nCLIPBOARD");
		helpText = String.format("%s\n%s",helpText, "Copy:\n(Shorted by CONTROL-C) Copy to the clipboard the actual text.");
		helpText = String.format("%s\n%s",helpText, "\nCut:\n(Shorted by CONTROL-X) Copy to the clipboard the actual text and delete it from the text area.");
		helpText = String.format("%s\n%s",helpText, "\nPaste:\n(Shorted by CONTROL-V) Paste in the text area the text copied in the clipboard. If this text has been copied from the text editor it will be pasted with all the styles and colors.");
		helpText = String.format("%s\n%s",helpText, "\nSpecial Paste:");
		helpText = String.format("%s\n%s",helpText, "Only text:\n(Shorted by CONTROL-ALT-SHIFT-V) Like normal paste, except it includes no format or style options.");
		helpText = String.format("%s\n%s",helpText, "\nOnly format:\n(Shorted by CONTROL-ALT-V) Only the Style from the fist character copied is pasted to the entire text selection.");
		helpText = String.format("%s\n%s",helpText, "\nInsert image:\nChoose a file from your system and put it into de text field.");
		helpText = String.format("%s\n%s",helpText, "\nTEXT FORMAT:");
		helpText = String.format("%s\n%s",helpText, "Bold:\n(Shorted by CONTROL-N) Turns the actual text selection to bold font, or to normal font if it is previos a bold font.");
		helpText = String.format("%s\n%s",helpText, "\nItalic:\n(Shorted by CONTROL-I) Turns the actual text selection to italic font, or to normal font if it is previos a italic font.");
		helpText = String.format("%s\n%s",helpText, "\nUnderlined:\n(Shorted by CONTROL-U) Mark underlined the actual text selection, or remove it from it if it is previously underlined.");
		helpText = String.format("%s\n%s",helpText, "\nSize:\nAllows to change the size ot the selected text.");
		helpText = String.format("%s\n%s",helpText, "\nFont:\nAllows to change the font type ot the selected text.");
		helpText = String.format("%s\n%s",helpText, "\nText Color:\nSet the current selected text to a custom choosen color.");
		helpText = String.format("%s\n%s",helpText, "\nPARRAGRAPH:");
		helpText = String.format("%s\n%s",helpText, "Left:\n(Shorted by CONTROL-L) Set the actual parragraph align to left.");
		helpText = String.format("%s\n%s",helpText, "\nCenter:\nSet the actual parragraph align to the center of the text field.");
		helpText = String.format("%s\n%s",helpText, "\nRight\n(Shorted by CONTROL-R) Set the actual parragraph align to right.");
		helpText = String.format("%s\n%s",helpText, "\nJustify:\n(Shorted by CONTROL-J) Set the actual parragraph align to justify.");
		helpText = String.format("%s\n%s",helpText, "\n\nLanguage:\nSet the actual text editor language.");
		helpText = String.format("%s\n%s",helpText, "\n\nAppearance:\nSet the general look of the text editor to one from a list.");
		return helpText;
	}
}
