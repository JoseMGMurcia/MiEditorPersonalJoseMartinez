package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import componentes.MyFrame;

public class ItemMenuListener implements ActionListener {

	private MyFrame jFrame;

	public ItemMenuListener(MyFrame jFrame) {
		this.jFrame = jFrame;
	}
	
	//gestión e la accion solicitada
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String action = actionEvent.getActionCommand();
		switch (action) {
		
		case "About":
			jFrame.getControl().showInfo();
			break;	
		case "ChangeFont":
			jFrame.getControl().changeFont();
			break;
		case "ChangeFontFromMenu":
			jFrame.getControl().changeFontFromMenu();
			break;
		case "ChangeLanguage":
			jFrame.getControl().openLagChooser();
			break;
		case "ChangeSize":
			jFrame.getControl().changeFontSize();
			break;
		case "ChangeSizeFromMenu":
			jFrame.getControl().changeFontSizeFromMenu();
			break;
		case "ChangeSkin":
			JMenuItem jMenuItem = (JMenuItem)actionEvent.getSource();
			jFrame.getControl().skinChange( jMenuItem.getText() );
			break;
		case "Close":
			jFrame.getControl().close();
			break;
		case "Copy":
			jFrame.getControl().copy();
			break;
		case "Cut":
			jFrame.getControl().cut();
			break;
		case "English":
			jFrame.getControl().chLanguageEnglish();
			break;
		case "French":
			jFrame.getControl().chLanguageFrench();
			break;
		case "German":
			jFrame.getControl().chLanguageGerman();
			break;
		case "Help":
			jFrame.getControl().openHelp();
			break;
		case "insertImage":
			jFrame.getControl().insertImage();
			break;
		case "Italian":
			jFrame.getControl().chLanguageItalian();
			break;	
		case "NewDoc":
			jFrame.getControl().newDocument();
			break;
		case "OnlyFormat":
			jFrame.getControl().pasteOnlyFormat();
			break;		
		case "OnlyText":
			jFrame.getControl().pasteOnlyText();
			break;	
		case "Open":
			jFrame.getControl().openFile();
			break;
		case "Paste":
			jFrame.getControl().paste();
			break;
		case "Save":
			jFrame.getControl().saveFile();;
			break;
		case "SelectAll":
			jFrame.getControl().selectAll();
			break;
		case "Spanish":
			jFrame.getControl().chLanguageSpanish();
			break;	
		case "ValidateColor":
			jFrame.getControl().changeColor();
			break;
		default:
			break;
		}
	}
}
