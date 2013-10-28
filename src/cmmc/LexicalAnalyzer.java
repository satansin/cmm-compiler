package cmmc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ºÆ
 *
 */
public class LexicalAnalyzer {
	
	private TokenTable reservedWordTable;
	
	private TokenTable idTable;
	
	private TokenTable numTable;
	
	private TokenTable operatorTable;
	
	private ArrayList<Token> outputTokenSeries;
	
	public LexicalAnalyzer() {
		reservedWordTable = new TokenTable();
		idTable = new TokenTable();
		numTable = new TokenTable();
		operatorTable = new TokenTable();
		
		outputTokenSeries = new ArrayList<Token>();
		
		readReservedWordListFromFile();
	}
	
	private void readReservedWordListFromFile() {
		try {
			File reservedWordsFile = new File("reserved_words.txt");
			BufferedReader br = new BufferedReader(new FileReader(reservedWordsFile));
			String word = "";
			while ((word = br.readLine()) != null) {
				reservedWordTable.addToken(new Token(Token.TokenType.RESERVED, word));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
