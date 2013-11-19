package cmmc;

public class Edge {
	
	private char terminalChar;
	
	private State pointedState;

	public Edge(char terminalChar, State pointedState) {
		this.terminalChar = terminalChar;
		this.pointedState = pointedState;
	}

	public char getTerminalChar() {
		return terminalChar;
	}

	public State getPointedState() {
		return pointedState;
	}

}
