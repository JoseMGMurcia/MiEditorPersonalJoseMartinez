package control;

import javax.swing.ImageIcon;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import componentes.MyJTextPane;

public class ImageControler {
	
	//pega una imagen en el documento
	public void InsertIcon(MyJTextPane jTextPane, ImageIcon imageIcon) {
		
		StyledDocument doc = (StyledDocument) jTextPane.getDocument();
		Style style = doc.addStyle("StyleName", null);
		StyleConstants.setIcon(style, imageIcon);
		try {
			doc.insertString(doc.getLength(), "invisible text", style);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		

}