package componentes;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private MyToolBar jToolBar;
	private JScrollPane jScrollPane;
	private MyJTextPane jTextPane;
	private JLabel statusLabel;
	
	public MyPanel(MyFrame jFrame) {
		//se implemente el Border Layout
		super(new BorderLayout());
		 
		
		//Se inicializan los componentes
		jTextPane = new MyJTextPane(jFrame);
		jScrollPane = new JScrollPane(jTextPane);
		jToolBar = new MyToolBar(jFrame);
		statusLabel = new JLabel("status");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Se añaden márgenes al texto
		statusLabel.setBorder(BorderFactory.createCompoundBorder(
				        this.getBorder(), 
				        BorderFactory.createEmptyBorder(0, 15, 0, 0)));
		
		
		//se disponen los componentes en el border layout
		this.add(jToolBar, BorderLayout.PAGE_START);
		this.add(jScrollPane);
		this.add(statusLabel, BorderLayout.PAGE_END );
		
	}
	//GETTES
	public MyToolBar getjToolBar() {
		return jToolBar;
	}
	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}
	public MyJTextPane getjTextPane() {
		return jTextPane;
	}
	public JLabel getStatusLabel() {
		return statusLabel;
	}
}