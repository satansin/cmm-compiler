package cmmc;

import java.util.ArrayList;

public class State {
	
	private ArrayList<Edge> startEdges;
	
	private boolean isEndState;
	
//	private TokenType endStateType;
	
	private String endStateType;
	
	public State() {
		this(false, null);
	}

//	public State(boolean isEndState, TokenType endStateType) {
//		this.startEdges = new ArrayList<Edge>();
//		this.isEndState = isEndState;
//		this.endStateType = endStateType;
//	}
	
	public State(boolean isEndState, String endStateType) {
		this.startEdges = new ArrayList<Edge>();
		this.isEndState = isEndState;
		this.endStateType = endStateType;
	}
	
	public void addStartEdge(Edge startEdge) {
		startEdges.add(startEdge);
	}
	
	public boolean isEndState() {
		return isEndState;
	}
	
//	public TokenType getEndStateType() {
//		return endStateType;
//	}
	
	public String getEndStateType() {
		return endStateType;
	}

	public State nextState(char terminal) {
		for (int i = 0; i < startEdges.size(); i++) {
			if (terminal == startEdges.get(i).getTerminalChar()) {
				return startEdges.get(i).getPointedState();
			}
		}
		return null;
	}

}
