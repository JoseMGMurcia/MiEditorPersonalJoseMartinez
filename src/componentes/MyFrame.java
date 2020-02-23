package componentes;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import control.MainControl;
import control.resources.Icons;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private MyMenuBar jMenuBar;
	private MyPanel jPanel;
	private MainControl control;
	
	public MyFrame(String theme) {
		
		//Creacion de las instancias de los componentes
		jPanel = new MyPanel(this);
		this.control = new MainControl(this);
		jMenuBar = new MyMenuBar(this);
		control.setComponents(this);
		
		//No Acaba la ejecuci�n de codigo en caso de cierre de la ventana
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		//Creaci�n de un listener para que la gestion del bonton de salida predeterminado
		this.setWindowListener();

		//A�adiendo los componentes
		this.setJMenuBar(jMenuBar);
		this.getContentPane().add(jPanel);
		
		this.setIconImage(Icons.main());
		this.setVisible(true);
		this.setResizable(true);
				
		//Tama�o prefijado para cuando la ventana no est� maximizada
		setPreferredSize(new Dimension(800, 600));
		this.pack();
				
		//Ubica la ventana en el centro de la pantalla
		this.setLocationRelativeTo(null);  
		
		//Maximiza la ventana hasta el tama�o de la pantalla
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Obtenci�n y ajuste del idioma del sistema
		this.getControl().getActions().doChangeLanguaje(Locale.getDefault(), this);
		
		//actualizaci�n del estato del selector de apariencias
		this.getControl().getActions().ajustSkinFont(this, theme);
		
		//
		
	}
	
	
	public void setWindowListener() {
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    MyFrame.this.control.close();
			  }
			});
	}
	
	//GETTERS

	public MainControl getControl() {
		return control;
	}

	public MyMenuBar getjMenuBar() {
		return jMenuBar;
	}


	public MyPanel getjPanel() {
		return jPanel;
	}
}