package cmmc;

import java.util.ArrayList;
import java.util.Stack;

public class LexicalDFA {
	
	private State startState;
	
	private State currentState;
	
	private String resultString;
	
	private boolean isDFA;

	public LexicalDFA(State startState) {
		this.startState = startState;
		
		reset();
	}
	
	public LexicalDFA(String regularEntry, String type) {
		try {
			this.startState = generateNFA(regularEntry, type);
		} catch (ExpressionInvalidException e) {
			e.printStackTrace();
		}
		
		reset();
	}

	public void reset() {
		currentState = startState;
		resultString = "";
		isDFA = false;
	}
	
	public String getResultString() {
		return resultString;
	}

	public String getResultType() {
		return currentState.getEndStateType();
	}

	public boolean input(char readChar) throws NotRecognizedException, NotDFAException {
		if (!isDFA) {
			throw new NotDFAException();
		}
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
	
	private class ExtendedEdge {
		ArrayList<Edge> startEdges = new ArrayList<Edge>();
		ArrayList<Edge> endEdges = new ArrayList<Edge>();
		public ExtendedEdge(Edge edge) {
			startEdges.add(edge);
			endEdges.add(edge);
		}
		public void connect(Edge edge) {
			State state = new State();
//			for (int i = 0; i < array.length; i++) {
//				
//			}
		}
		public void selfRepeat() {
			// TODO Auto-generated method stub
			
		}
		public void merge(ExtendedEdge oth) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public State generateNFA(String regularEntry, String type) throws ExpressionInvalidException {
		if (!checkMatch(regularEntry)) {
			throw new ExpressionInvalidException();
		}
		Stack<ExtendedEdge> edgeStack = new Stack<ExtendedEdge>();
		Stack<Character> signStack = new Stack<Character>();
		
		for (int i = 0; i < regularEntry.length(); i++) {
			char c = regularEntry.charAt(i);
			
			if (isNormalChar(c)) {
				Edge edge = new Edge(c, null);
				if (i > 0 && isNormalChar(regularEntry.charAt(i - 1))) {
					ExtendedEdge top = edgeStack.pop();
					top.connect(edge);
					edgeStack.push(top);
				} else {
					ExtendedEdge newTop = new ExtendedEdge(edge);
					edgeStack.push(newTop);
				}
			} else if (isVerticalLine(c)) {
				signStack.push('|');
			} else if (isAsterick(c)) {
				ExtendedEdge top = edgeStack.pop();
				top.selfRepeat();
				edgeStack.push(top);
			} else if (isLeftParenthesis(c)) {
				signStack.push('(');
			} else if (isRightParenthesis(c)) {
				char top = 0;
				while ((top = signStack.pop()) != '(') {
					if (isVerticalLine(top)) {
						ExtendedEdge top1 = edgeStack.pop();
						ExtendedEdge top2 = edgeStack.pop();
						top2.merge(top1);
					}
				}
			}
		}
		
		while (!signStack.isEmpty()) {
			char sign = signStack.pop();
			if (isVerticalLine(sign)) {
				ExtendedEdge top1 = edgeStack.pop();
				ExtendedEdge top2 = edgeStack.pop();
				top2.merge(top1);
			}
		}
		ExtendedEdge edgesAfterStart = edgeStack.pop();
		State start = new State();
		for (int i = 0; i < edgesAfterStart.startEdges.size(); i++) {
			start.addStartEdge(edgesAfterStart.startEdges.get(i));
		}
		State end = new State(true, type);
		for (int i = 0; i < edgesAfterStart.endEdges.size(); i++) {
			edgesAfterStart.endEdges.get(i).setPointedState(end);
		}
		return start;
	}
	
	private boolean checkMatch(String expr) {
		int layer = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (isLeftParenthesis(c)) {
				layer++;
			} else if (isRightParenthesis(c)) {
				layer--;
			}
			if (layer < 0) {
				return false;
			}
		}
		if (layer != 0) {
			return false;
		}
		return true;
	}

	private boolean isNormalChar(char c) {
		return c != '|' && c != '(' && c != ')' && c != '*';
	}
	
	private boolean isLeftParenthesis(char c) {
		return c == '(';
	}
	
	private boolean isRightParenthesis(char c) {
		return c == ')';
	}
	
	private boolean isAsterick(char c) {
		return c == '*';
	}
	
	private boolean isVerticalLine(char c) {
		return c == '|';
	}
	
	public void transform() {
		
	}

}
