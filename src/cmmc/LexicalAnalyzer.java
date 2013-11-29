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
	
//	private TokenTable reservedWordTable;
//	
//	private TokenTable idTable;
//	
//	private TokenTable numTable;
//	
//	private TokenTable operatorTable;
//	
//	public LexicalAnalyzer() {
//		reservedWordTable = new TokenTable();
//		idTable = new TokenTable();
//		numTable = new TokenTable();
//		operatorTable = new TokenTable();
//		
//		readReservedWordListFromFile();
//	}
//	
//	private void readReservedWordListFromFile() {
//		try {
//			File reservedWordsFile = new File("reserved_words.txt");
//			BufferedReader br = new BufferedReader(new FileReader(reservedWordsFile));
//			String word = "";
//			while ((word = br.readLine()) != null) {
//				reservedWordTable.registerToken(new Token(TokenType.RESERVED, word));
//			}
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void analyze() {
//		LexicalDFA lexicalDFA = new LexicalDFAConstructor().constructDefaultDFA();
//		String filePath = "test1.cmm";
//		CmmFileReader cmmFileReader = new CmmFileReader(filePath);
//		
//		ArrayList<Token> outputTokenSeries = new ArrayList<Token>();
//		
//		char readChar = 0;
//		while ((readChar = cmmFileReader.readChar()) != 0) {
//			try {
//				boolean hasNextState = lexicalDFA.input(readChar);
//				if (!hasNextState) {
//					cmmFileReader.pushBack();
//					outputTokenSeries.add(register(lexicalDFA.getResultType(), lexicalDFA.getResultString()));
//					lexicalDFA.reset();
//				}
//			} catch (NotRecognizedException e) {
//				addToUnrecognizedSet(readChar);
//			} catch (NotDFAException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		printResultToFile(outputTokenSeries, filePath);
//	}
//
//	private void addToUnrecognizedSet(char readChar) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private Token register(TokenType resultType, String resultString) {
//		Token token = new Token(resultType, resultString);
//		switch (resultType) {
//		case ID:
//			idTable.registerToken(token);
//			break;
//		case NUM:
//			numTable.registerToken(token);
//			break;
//		case BINARY_ARITHMETIC_OP:
//		case UNARY_ARITHMETIC_OP:
//		case SHIFT_OP:
//		case RELATION_OP:
//		case LOGIC_OP:
//		case ASSIGNMENT_OP:
//			operatorTable.registerToken(token);
//			break;
//		case RESERVED:
//			reservedWordTable.registerToken(token);
//			break;
//		default:
//			break;
//		}
//		
//		return token;
//	}
//	
//	private void printResultToFile(ArrayList<Token> outputTokenSeries, String srcFilePath) {
//		TsFileWriter tsFileWriter = new TsFileWriter(srcFilePath.split("\\.")[0]);
//		for (int i = 0; i < outputTokenSeries.size(); i++) {
//			tsFileWriter.appendLine(outputTokenSeries.get(i).toString());
//		}
//		tsFileWriter.close();
//	}
//	
//	public static void main(String[] args) {
//		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
//		lexicalAnalyzer.analyze();
//	}

}
