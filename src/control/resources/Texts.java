package control.resources;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import componentes.MyFrame;

public abstract class Texts {
	public static Locale locale;
	
	//Obtención del texto abstrayendoe del locale por parte del componente que lo solicita
	public static String get(String item){
		try {
			return ResourceBundle.getBundle("resources.languages.etiquetas",locale).getString(item);
		} catch (Exception e) {
			return "";
		}
	}
	
	//cambio total de textos
	public static void setTexts(MyFrame jFrame) {
		JOptionPane.setDefaultLocale(locale);
		ResourceBundle.clearCache();
		jFrame.setTitle(Texts.get("title_window"));
		jFrame.getjMenuBar().getMenuFile().setText(Texts.get("menu_file"));
		jFrame.getjMenuBar().getOpen().setText(Texts.get("menu_file_open"));
		jFrame.getjMenuBar().getSave().setText(Texts.get("menu_file_save"));
		jFrame.getjMenuBar().getNewDoc().setText(Texts.get("menu_file_new"));
		jFrame.getjMenuBar().getExit().setText(Texts.get("menu_file_exit"));
		jFrame.getjMenuBar().getMenuEdit().setText(Texts.get("menu_edit"));
		jFrame.getjMenuBar().getCopy().setText(Texts.get("menu_edit_copy"));
		jFrame.getjMenuBar().getCut().setText(Texts.get("menu_edit_cut"));
		jFrame.getjMenuBar().getPaste().setText(Texts.get("menu_edit_paste"));
		jFrame.getjMenuBar().getMenuEditSpecial().setText(Texts.get("menu_edit_special_paste"));
		jFrame.getjMenuBar().getNoFormat().setText(Texts.get("menu_edit_special_paste_no_format"));
		jFrame.getjMenuBar().getOnlyFormat().setText(Texts.get("menu_edit_special_paste_no_text"));
		jFrame.getjMenuBar().getSelectAll().setText(Texts.get("menu_edit_select_all"));
		jFrame.getjMenuBar().getMenuInsert().setText(Texts.get("menu_insert"));
		jFrame.getjMenuBar().getImage().setText(Texts.get("menu_insert_image"));
		jFrame.getjMenuBar().getMenuFormat().setText(Texts.get("menu_format"));
		jFrame.getjMenuBar().getMenuText().setText(Texts.get("menu_format_text"));
		jFrame.getjMenuBar().getBold().setText(Texts.get("menu_format_text_bold"));
		jFrame.getjMenuBar().getItalic().setText(Texts.get("menu_format_text_italic"));
		jFrame.getjMenuBar().getUnderlined().setText(Texts.get("menu_format_text_underline"));
		jFrame.getjMenuBar().getSizeItem().setText(Texts.get("menu_format_text_size"));
		jFrame.getjMenuBar().getFontItem().setText(Texts.get("menu_format_text_font"));
		jFrame.getjMenuBar().getMenuParraf().setText(Texts.get("menu_format_parragraf"));
		jFrame.getjMenuBar().getMenuAlign().setText(Texts.get("menu_format_align"));
		jFrame.getjMenuBar().getRight().setText(Texts.get("menu_format_align_right"));
		jFrame.getjMenuBar().getCenter().setText(Texts.get("menu_format_align_center"));
		jFrame.getjMenuBar().getLeft().setText(Texts.get("menu_format_align_left"));
		jFrame.getjMenuBar().getJustify().setText(Texts.get("menu_format_align_justify"));
		jFrame.getjMenuBar().getColor().setText(Texts.get("menu_format_color"));
		jFrame.getjMenuBar().getMenuOptions().setText(Texts.get("menu_option"));
		jFrame.getjMenuBar().getLanguage().setText(Texts.get("menu_options_language"));
		jFrame.getjMenuBar().getSpanish().setText(Texts.get("menu_options_language_spanish"));
		jFrame.getjMenuBar().getEnglish().setText(Texts.get("menu_options_language_english"));
		jFrame.getjMenuBar().getItalian().setText(Texts.get("menu_options_language_italian"));
		jFrame.getjMenuBar().getGerman().setText(Texts.get("menu_options_language_german"));
		jFrame.getjMenuBar().getFrench().setText(Texts.get("menu_options_language_french"));
		jFrame.getjMenuBar().getSkin().setText(Texts.get("menu_options_skin"));
		jFrame.getjMenuBar().getMenuHelp().setText(Texts.get("menu_help"));
		jFrame.getjMenuBar().getHelpItem().setText(Texts.get("menu_help"));
		jFrame.getjMenuBar().getAbout().setText(Texts.get("menu_help_about"));
		jFrame.getjPanel().getjToolBar().getSaveButton().setToolTipText(Texts.get("menu_file_save"));
		jFrame.getjPanel().getjToolBar().getLoadButton().setToolTipText(Texts.get("menu_file_open"));
		jFrame.getjPanel().getjToolBar().getExitButton().setToolTipText(Texts.get("menu_file_exit"));
		jFrame.getjPanel().getjToolBar().getFontLabel().setText(Texts.get("menu_format_text_font"));
		jFrame.getjPanel().getjToolBar().getSizeLabel().setText(Texts.get("menu_format_text_size"));
		jFrame.getjPanel().getjToolBar().getBoldButton().setToolTipText(Texts.get("menu_format_text_bold"));
		jFrame.getjPanel().getjToolBar().getItalicButton().setToolTipText(Texts.get("menu_format_text_italic"));
		jFrame.getjPanel().getjToolBar().getUnderlineButton().setToolTipText(Texts.get("menu_format_text_underline"));
		jFrame.getjPanel().getjToolBar().getLeftAlignButton().setToolTipText(Texts.get("menu_format_align_left"));
		jFrame.getjPanel().getjToolBar().getRightAlignButton().setToolTipText(Texts.get("menu_format_align_right"));
		jFrame.getjPanel().getjToolBar().getCenterAlignButton().setToolTipText(Texts.get("menu_format_align_center"));
		jFrame.getjPanel().getjToolBar().getJustifyAlignButton().setToolTipText(Texts.get("menu_format_align_justify"));
		jFrame.getjPanel().getjToolBar().getFontColorButton().setToolTipText(Texts.get("menu_format_color"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemBold().setText(Texts.get("menu_format_text_bold"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemItalic().setText(Texts.get("menu_format_text_italic"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemUnderlined().setText(Texts.get("menu_format_text_underline"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemCopy().setText(Texts.get("menu_edit_copy"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemCut().setText(Texts.get("menu_edit_cut"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuItemPaste().setText(Texts.get("menu_edit_paste"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getMenuEditSpecial().setText(Texts.get("menu_edit_special_paste"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getNoFormat().setText(Texts.get("menu_edit_special_paste_no_format"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getOnlyFormat().setText(Texts.get("menu_edit_special_paste_no_text"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getSelectAll().setText(Texts.get("menu_edit_select_all"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getRight().setText(Texts.get("menu_format_align_right"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getCenter().setText(Texts.get("menu_format_align_center"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getLeft().setText(Texts.get("menu_format_align_left"));
		jFrame.getjPanel().getjTextPane().getjPopUpMenu().getJustify().setText(Texts.get("menu_format_align_justify"));
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().getSpanish().setText(Texts.get("menu_options_language_spanish"));
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().getEnglish().setText(Texts.get("menu_options_language_english"));
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().getItalian().setText(Texts.get("menu_options_language_italian"));
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().getGerman().setText(Texts.get("menu_options_language_german"));
		jFrame.getjPanel().getjToolBar().getLanguagePopUp().getFrench().setText(Texts.get("menu_options_language_french"));
		UIManager.put("FileChooser.acceptAllFileFilterText",  Texts.get("all_files"));
	}
	
	//Getters & setters
	public static Locale getLocale() {
		return locale;
	}
	public static void setLocale(Locale locale) {
		Texts.locale = locale;
	}
}
