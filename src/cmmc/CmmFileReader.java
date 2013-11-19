package cmmc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CmmFileReader {
	
	private int cursor;
	
	private String fileContent;

	public CmmFileReader(String filePath) {
		cursor = 0;
		fileContent = "";
		try {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				fileContent += line + " ";
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public char readChar() {
		if (cursor >= fileContent.length()) {
			return 0;
		}
		cursor++;
		return fileContent.charAt(cursor - 1);
	}

	public void pushBack() {
		cursor--;
		if (cursor < 0) {
			cursor = 0;
		}
	}

}
