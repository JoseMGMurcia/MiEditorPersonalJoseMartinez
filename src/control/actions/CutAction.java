package control.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import componentes.MyFrame;

public class CutAction extends AbstractAction{

	private MyFrame jFrame;
	private static final long serialVersionUID = 114L;
	
	public CutAction( MyFrame jFrame) {
		this.jFrame = jFrame;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jFrame.getControl().cut();
		
	}

}