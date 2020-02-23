package control;

import javax.swing.JLabel;
import javax.swing.text.AttributeSet;

import componentes.MyFrame;
import componentes.MyJTextPane;
import control.resources.Texts;

public class StatusControler implements Runnable {

	private boolean running;
	private MyJTextPane jTextPane;
	private JLabel statusLabel;
	private String statusText, text ,font;
	private int characters, position, size;
	private AttributeSet sa;
	
	public StatusControler(MyFrame jFrame) {
		this.running = true;
		this.jTextPane = jFrame.getjPanel().getjTextPane();
		this.statusLabel = jFrame.getjPanel().getStatusLabel();
		statusText ="";
	}
	
	@Override
	public void run() {
		while(running) {
			
			//Es necesario un try catch por que al no haber pasas es posible que el texto seleccionado sufra mutaciones en el transcurso de algún bloque
			try {
			text = jTextPane.getText();
			characters = text.length();
			//Cotrucción de la cadena de texto para mostrar en el estatus
			statusText = String.format( " %s:  %s:  %s       %s:  %s   ", 
					Texts.get("document"),
					Texts.get("characters"),
					characters ,
					Texts.get("words"),
					this.getWords(text));
			
			//Si existe texto seleccionado se analiza
			if(jTextPane.getSelectedText() != null) {
				statusText = String.format("%s         %s:", statusText, Texts.get("selected"));
				text= jTextPane.getSelectedText();
				
				//Obtenemos caracteristicas de la fuente del texto seleccionado
				position = jTextPane.getSelectionStart();
				sa = jTextPane.getStyledDocument().getCharacterElement(position).getAttributes();
				font = jTextPane.getStyledDocument().getFont(sa).getFontName();
				size = jTextPane.getStyledDocument().getFont(sa).getSize();
				
				
				if (text != null) {
					characters = text.length();
					statusText = String.format( "%s  %s:  %s       %s:  %s   ",
							statusText,
							Texts.get("characters"),
							characters ,
							Texts.get("words"),
							this.getWords(text));
				}
			}else {
				statusText = String.format("%s         %s.", statusText, Texts.get("no_selected") );
				
				//Obtenemos caracteristicas de la fuente del texto
				position = jTextPane.getCaretPosition();
				
				if (position == jTextPane.getText().length()) {
					sa = jTextPane.getInputAttributes();
				}else {
					sa = jTextPane.getCharacterAttributes();
				}
				font = jTextPane.getStyledDocument().getFont(sa).getFontName();
				size = jTextPane.getStyledDocument().getFont(sa).getSize();
				
			}
			
			//Se añaden caracteristicas de Fuente
			statusText = String.format("%s         %s:   %s,      %s:   %s,",
					statusText,
					Texts.get("label_font"),
					font,
					Texts.get("label_size"),
					size );
			
			//Se establece el texto de la barra
			statusLabel.setText(statusText);
			}catch (Exception e) {
				System.err.println(e.getMessage() + " from StatusControler");
			}
		}
	}
	
	// contador de palabras en un String
	private int getWords(String text) {
		int contador= 0;
		if (text.length() < 1) {
			return 0;
		} else {
			for (int i = 1; i < text.length(); i++) {
				if (text.charAt(i)== ' ' && text.charAt(i -1) != ' ') {
					contador++;
				}
			}
			if(text.charAt(text.length()-1) != ' ') {
				contador++;
			}
		}
		return contador;
	}
	
	// GETTERS & SETTERS


	
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
}
