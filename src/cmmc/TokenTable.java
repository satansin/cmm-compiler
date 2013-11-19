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
	public void registerToken(Token token) {
		int code = findTokenCode(token);
		if (code < 0) {
			token.setInnerCode(getLastTokenCode() + 1);
			tokenList.add(token);
		} else {
			token.setInnerCode(code);
		}
	}
	
	public int getLastTokenCode() {
		return tokenList.size();
	}
	
	private int findTokenCode(Token token) {
		for (int i = 0; i < tokenList.size(); i++) {
			if (token.getValue().equals(tokenList.get(i).getValue())) {
				return tokenList.get(i).getInnerCode();
			}
		}
		return -1;
	}

}
