package control.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import componentes.MyFrame;

public class CopyAction extends AbstractAction{

	private MyFrame jFrame;
	private static final long serialVersionUID = 112L;
	
	public CopyAction( MyFrame jFrame) {
		this.jFrame = jFrame;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jFrame.getControl().copy();
		
	}

}
