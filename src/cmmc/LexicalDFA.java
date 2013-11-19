package cmmc;

public class LexicalDFA {
	
	private State startState;
	
	private State currentState;
	
	private String resultString;

	public LexicalDFA(State startState) {
		this.startState = startState;
		
		reset();
	}
	
	public void reset() {
		currentState = startState;
		resultString = "";
	}
	
	public String getResultString() {
		return resultString;
	}

	public TokenType getResultType() {
		return currentState.getEndStateType();
	}

	public boolean input(char readChar) throws NotRecognizedException {
		State nextState = currentState.nextState(readChar);
		if (nextState != null) {
			currentState = nextState;
			resultString += readChar;
			return true;
		}
		if (!currentState.isEndState()) {
			throw new NotRecognizedException();
		}
		return false;
	}

}
