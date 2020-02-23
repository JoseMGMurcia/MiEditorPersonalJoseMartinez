package principal;

import java.util.Locale;
import componentes.MyFrame;
import control.ActionsControl;
import control.StatusControler;
import control.StyleControler;
import control.resources.Constants;
import control.resources.Texts;

public class Principal {
	
	/* Este método Principal.main(String[] args) pone en marcha toda la aplicación   */
	public static void main(String[] args) {
		
		// Gestión del tema general del aspecto
		String theme = Constants.INITIAL_THEME;
		ActionsControl.doSkinChange(theme);
		
		//Se detecta y establece el idioma del sitema
		Texts.setLocale(Locale.getDefault());
		
		// Puesta en Marcha de la interfaz
		MyFrame miFrame = new MyFrame(theme);
		
		//lanza un nuevo hilo para el control de la barra de estado
		new Thread( new StatusControler(miFrame) ).start();
		
		//lanza un nuevo hilo para el control de coherencia
		new Thread( new StyleControler(miFrame)  ).start();
		
		//Ajuste iniciales del documento		
		miFrame.getjPanel().getjTextPane().newDocument();
	}
}