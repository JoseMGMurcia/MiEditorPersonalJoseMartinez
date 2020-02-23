package componentes;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import listeners.ItemMenuListener;

public class MySkniJMenu extends JMenu{
	
private static final long serialVersionUID = 56L;
	
	public MySkniJMenu(MyFrame jFrame) {
		//se obtienen las apariencias del sistema
		String[] skinNames = new String[UIManager.getInstalledLookAndFeels().length];
		
		//se instancia el listener
		ItemMenuListener itemMenuListener = new ItemMenuListener(jFrame);
		
		//construccion de cada elemento
		for (int i = 0; i < skinNames.length; i++) {
			skinNames[i] = UIManager.getInstalledLookAndFeels()[i].getName();
			JMenuItem jMenuItem = new JMenuItem();
			jMenuItem.setText(skinNames[i]);
			jMenuItem.setName(skinNames[i]);
			
			//se asigna la misma accion a cada elemto y luego se distinguirá por el monbre en el listener
			jMenuItem.setActionCommand("ChangeSkin");
			jMenuItem.addActionListener(itemMenuListener);
			this.add(jMenuItem);
			
		}
		this.setFocusable(false);
	}
}
