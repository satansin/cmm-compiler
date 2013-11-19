/**
 * 
 */
package cmmc;

/**
 * @author ºÆ
 *
 */
public class Token {

	//public enum TokenType { ID, NUM, OPERATOR, RESERVED };
	
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

	public void setInnerCode(int innerCode) {
		this.innerCode = innerCode;
	}

	public TokenType getType() {
		return type;
	}

	public int getInnerCode() {
		return innerCode;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", innerCode=" + innerCode + ", value="
				+ value + "]";
	}

}
