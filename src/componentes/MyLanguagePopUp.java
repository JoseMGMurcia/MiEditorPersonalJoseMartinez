package componentes;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import control.resources.Icons;
import listeners.ItemMenuListener;

public class MyLanguagePopUp extends JPopupMenu{

	private static final long serialVersionUID = 1L;
	private JMenuItem spanish;
	private JMenuItem english;
	private JMenuItem italian;
	private JMenuItem german;
	private JMenuItem french;
	
	
	//esta clase dispone un menú dede el que elegir coodamente el idioma desde la barra de herramienta
	public MyLanguagePopUp(MyFrame jFrame) {
		
		ItemMenuListener listener = new ItemMenuListener(jFrame);
		
		//Instanciación y asignación de iconos
		spanish = new JMenuItem(Icons.SpainM());
		english = new JMenuItem(Icons.UnitedKindomM());
		italian = new JMenuItem(Icons.ItalyM());
		german = new JMenuItem(Icons.GermanyM());
		french = new JMenuItem(Icons.FranceM());
		
		//se añaden los elementos a la barra
		this.add(spanish);
		this.add(english);
		this.add(italian);
		this.add(german);
		this.add(french);
		
		//asignación de acciones e incorporación del listaner
		spanish.addActionListener(listener);
		spanish.setActionCommand("Spanish");
		english.addActionListener(listener);
		english.setActionCommand("English");
		italian.addActionListener(listener);
		italian.setActionCommand("Italian");
		german.addActionListener(listener);
		german.setActionCommand("German");
		french.addActionListener(listener);
		french.setActionCommand("French");
	}

	
	//Getters      --Necesarios para el cambio de icono y letra
	public JMenuItem getSpanish() {
		return spanish;
	}

	public JMenuItem getEnglish() {
		return english;
	}

	public JMenuItem getItalian() {
		return italian;
	}

	public JMenuItem getGerman() {
		return german;
	}

	public JMenuItem getFrench() {
		return french;
	}
	
	
	
}
