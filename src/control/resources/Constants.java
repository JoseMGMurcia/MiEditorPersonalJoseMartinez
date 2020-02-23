package control.resources;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;


	/* Esta clase se usa para definir valores fijos para toda la aplicación */
public abstract class Constants {
	
	
	/* Fuente inicial, no dar un valor arbitrariamente, ha de coincidir con el nombre de una de las fuente instaladas en el sistema */
	public static final String INITIAL_FONT = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[3];
	
	/* Tamaños de fuente disponibles   */
	public static final String[] FONT_SIZE_LIST = { "8", "9", "10", "12", "13", "14", "16", "18", "20", "24", "28", "32", "36", "42", "48", "56",
			"64", "72", "80"};
	
	/* Tamaño de letra inicial , ha de ser un valor contemplado en la lista anterior */
	public static final int INITIAL_FONT_SIZE = 16; 
	
	
	/* Tema inicial no dar un valor arbitrariamente, ha de coincidir con el nombre de una de las apariencias instaladas en el sistema   */
	public static final String INITIAL_THEME = "Nimbus";
	
	
	/* Tamaño de los botones de la barra de herramientas preferiblemente lados iguales y potencias en base 2*/
	public static final Dimension BUTTON_SIZE = new Dimension(32,32);

}
