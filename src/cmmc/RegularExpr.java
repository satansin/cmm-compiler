package cmmc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class RegularExpr {
	
	private HashMap<String, String> singleExprs = new HashMap<String, String>();
	
	public RegularExpr(String filepath) {
		try {
			File file = new File(filepath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.trim();
				String[] split = line.split("->");
				
				if (split.length <= 1) {
					continue;
				}
				
				String head = split[0];
				String content = line.substring(head.length() + 2);
				head = head.trim();
				content = content.trim();
				
				if (head.length() == 0 || content.length() == 0) {
					continue;
				}
				
				singleExprs.put(head, content);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<String> getWordTypeNamesItr() {
		return singleExprs.keySet().iterator();
	}
	
	public String getRegularEntry(String typeName) {
		return singleExprs.get(typeName);
	}
	
	public String toString() {
		return singleExprs.toString();
	}

}
