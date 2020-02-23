package control.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import componentes.MyFrame;

public class PasteAction extends AbstractAction{

	private MyFrame jFrame;
	private static final long serialVersionUID = 113L;
	
	public PasteAction( MyFrame jFrame) {
		this.jFrame = jFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jFrame.getControl().paste();
	}
	
}