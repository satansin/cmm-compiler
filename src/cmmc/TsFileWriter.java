package cmmc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TsFileWriter {
	
	private FileWriter fileWriter;
	
	public TsFileWriter(String filename) {
		try {
			File file = new File(filename + ".ts");
			if (!file.exists()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void appendLine(String line) {
		try {
			fileWriter.append(line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
