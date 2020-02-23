package control.resources;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Icons {

	//metodos para la obtención de iconos de forma ágil
	
	public static Icon alignCenterM() {
		return getMenuIcon("./src/resources/icons/flaticons/002-align center.png");
	}

	public static Icon alignCenterT() {
		return getToolIcon("./src/resources/icons/flaticons/002-align center.png");
	}

	public static Icon alignLeftM() {
		return getMenuIcon("./src/resources/icons/flaticons/003-align left.png");
	}

	public static Icon alignLeftT() {
		return getToolIcon("./src/resources/icons/flaticons/003-align left.png");
	}

	public static Icon alignRightM() {
		return getMenuIcon("./src/resources/icons/flaticons/004-align right.png");
	}

	public static Icon alignRightT() {
		return getToolIcon("./src/resources/icons/flaticons/004-align right.png");
	}

	public static Icon justifyM() {
		return getMenuIcon("./src/resources/icons/flaticons/051-Justify.png");
	}

	public static Icon justifyT() {
		return getToolIcon("./src/resources/icons/flaticons/051-Justify.png");
	}

	public static Icon underlineyM() {
		return getMenuIcon("./src/resources/icons/flaticons/049-underline.png");
	}

	public static Icon underlineT() {
		return getToolIcon("./src/resources/icons/flaticons/049-underline.png");
	}

	public static Icon saveM() {
		return getMenuIcon("./src/resources/icons/flaticons/042-diskette.png");
	}

	public static Icon saveT() {
		return getToolIcon("./src/resources/icons/flaticons/042-diskette.png");
	}

	public static Icon openM() {
		return getMenuIcon("./src/resources/icons/flaticons/009-folder.png");
	}

	public static Icon openT() {
		return getToolIcon("./src/resources/icons/flaticons/009-folder.png");
	}

	public static Icon siceM() {
		return getMenuIcon("./src/resources/icons/flaticons/012-font.png");
	}

	public static Icon siceT() {
		return getToolIcon("./src/resources/icons/flaticons/012-font.png");
	}

	public static Icon boldM() {
		return getMenuIcon("./src/resources/icons/flaticons/005-bold.png");
	}

	public static Icon boldT() {
		return getToolIcon("./src/resources/icons/flaticons/005-bold.png");
	}

	public static Icon italicM() {
		return getMenuIcon("./src/resources/icons/flaticons/052-italic.png");
	}

	public static Icon italicT() {
		return getToolIcon("./src/resources/icons/flaticons/052-italic.png");
	}

	public static Icon exitM() {
		return getMenuIcon("./src/resources/icons/flaticons/53- exit.png");
	}

	public static Icon exitT() {
		return getToolIcon("./src/resources/icons/flaticons/53- exit.png");
	}

	public static Icon copyM() {
		return getMenuIcon("./src/resources/icons/flaticons/010-file.png");
	}

	public static Icon copyT() {
		return getToolIcon("./src/resources/icons/flaticons/010-file.png");
	}

	public static Icon cutM() {
		return getMenuIcon("./src/resources/icons/flaticons/011-scissors.png");
	}

	public static Icon cutT() {
		return getToolIcon("./src/resources/icons/flaticons/011-scissors.png");
	}

	public static Icon pasteM() {
		return getMenuIcon("./src/resources/icons/flaticons/037-paste.png");
	}

	public static Icon pasteT() {
		return getToolIcon("./src/resources/icons/flaticons/037-paste.png");
	}

	public static Icon imageM() {
		return getMenuIcon("./src/resources/icons/flaticons/035-paragraph.png");
	}

	public static Icon imageT() {
		return getToolIcon("./src/resources/icons/flaticons/035-paragraph.png");
	}

	public static Icon newM() {
		return getMenuIcon("./src/resources/icons/flaticons/054-new.png");
	}

	public static Icon newT() {
		return getToolIcon("./src/resources/icons/flaticons/054-new.png");
	}

	public static Icon pasteNoTextM() {
		return getMenuIcon("./src/resources/icons/flaticons/055-paste no text.png");
	}

	public static Icon pasteNoTextT() {
		return getToolIcon("./src/resources/icons/flaticons/055-paste no text.png");
	}

	public static Icon pasteNoFormatM() {
		return getMenuIcon("./src/resources/icons/flaticons/056-paste no format.png");
	}

	public static Icon pasteNoFormatT() {
		return getToolIcon("./src/resources/icons/flaticons/056-paste no format.png");
	}

	public static Icon selectAllM() {
		return getMenuIcon("./src/resources/icons/flaticons/022-selectall.png");
	}

	public static Icon selectAllT() {
		return getToolIcon("./src/resources/icons/flaticons/022-selectall.png");
	}

	public static Icon strikedM() {
		return getMenuIcon("./src/resources/icons/flaticons/058-strikethrought.png");
	}

	public static Icon strikedT() {
		return getToolIcon("./src/resources/icons/flaticons/058-strikethrought.png");
	}

	public static Icon fontColorM() {
		return getMenuIcon("./src/resources/icons/flaticons/047-text.png");
	}

	public static Icon fontColorT() {
		return getToolIcon("./src/resources/icons/flaticons/047-text.png");
	}

	public static Icon lowercaseM() {
		return getMenuIcon("./src/resources/icons/flaticons/059-lowercase.png");
	}

	public static Icon lowercaseT() {
		return getToolIcon("./src/resources/icons/flaticons/059-lowercase.png");
	}

	public static Icon upercaseM() {
		return getMenuIcon("./src/resources/icons/flaticons/016-grammar.png");
	}

	public static Icon upercaseT() {
		return getToolIcon("./src/resources/icons/flaticons/016-grammar.png");
	}

	public static Icon fontM() {
		return getMenuIcon("./src/resources/icons/flaticons/060-fonts.png");
	}

	public static Icon fontT() {
		return getToolIcon("./src/resources/icons/flaticons/060-fonts.png");
	}

	public static Icon SpainM() {
		return getMenuIcon("./src/resources/icons/flaticons/128-spain.png");
	}

	public static Icon UnitedKindomM() {
		return getMenuIcon("./src/resources/icons/flaticons/260-united-kingdom.png");
	}

	public static Icon FranceM() {
		return getMenuIcon("./src/resources/icons/flaticons/195-france.png");
	}

	public static Icon GermanyM() {
		return getMenuIcon("./src/resources/icons/flaticons/162-germany.png");
	}

	public static Icon ItalyM() {
		return getMenuIcon("./src/resources/icons/flaticons/013-italy.png");
	}

	public static Image main() {
		return new ImageIcon("./src/resources/icons/flaticons/054-new.png").getImage();
	}

	public static Icon getMenuIcon(String ruta) {
		Icon icon;
		try {
			icon = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
			return icon;
		} catch (Exception e) {
			return null;
		}
	}

	public static Icon getToolIcon(String ruta) {
		Icon icon;
		try {
			icon = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			return icon;
		} catch (Exception e) {
			return null;
		}
	}

}
