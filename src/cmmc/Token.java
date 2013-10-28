/**
 * 
 */
package cmmc;

/**
 * @author ºÆ
 *
 */
public class Token {

	public enum TokenType { ID, NUM, OPERATOR, RESERVED };
	
	private TokenType type;
	
	private int innerCode;
	
	private Object value;

	/**
	 * @param type
	 * @param value
	 */
	public Token(TokenType type, Object value) {
		this.type = type;
		this.innerCode = 0;
		this.value = value;
	}

	/**
	 * @Title: setInnerCode
	 * @Description: TODO
	 * @param @param i 
	 * @return void 
	 * @throws
	 */
	public void setInnerCode(int innerCode) {
		this.innerCode = innerCode;
	}

}
