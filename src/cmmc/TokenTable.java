package cmmc;

import java.util.ArrayList;

/**
 * @author ºÆ
 *
 */
public class TokenTable {
	
	private ArrayList<Token> tokenList;
	
	public TokenTable() {
		tokenList = new ArrayList<Token>();
	}

	/**
	 * @Title: addToken
	 * @Description: TODO
	 * @param @param token 
	 * @return void 
	 * @throws
	 */
	public void addToken(Token token) {
		token.setInnerCode(getLastTokenCode() + 1);
	}
	
	public int getLastTokenCode() {
		return tokenList.size();
	}

}
