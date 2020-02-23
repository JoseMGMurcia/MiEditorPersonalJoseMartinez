package control;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class FileControler {
	
	//carga un fichero
	public void doOpenFile(String filePath, StyledDocument document) {
		RTFEditorKit rtfEditorKit = new RTFEditorKit();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			rtfEditorKit.read(fileInputStream, document, 0);
			fileInputStream.close();
		} catch (Exception e) {
		}
	}

	//guarda el contenido de texto en un archivo
	public void doSaveFile(String filePath, StyledDocument document) {
		RTFEditorKit rtfEditorKit = new RTFEditorKit();
		BufferedOutputStream bufferedOutputStream;
		try {
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
			rtfEditorKit.write(bufferedOutputStream, document, document.getStartPosition().getOffset(),
					document.getLength());
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		} catch (Exception e) {
		}
	}
}
