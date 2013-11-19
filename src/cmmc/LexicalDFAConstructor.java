package cmmc;

public class LexicalDFAConstructor {
	
	static final String ID_INITIAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZaghjkmnopqtuxyz";
	static final String ID_BODY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	static final String NUM = "012345689";
	
	public LexicalDFA constructDefaultDFA() {
		State startState = new State();

		// End state for ID
		State idEndState = new State(true, TokenType.ID);
		for (int i = 0; i < ID_INITIAL.length(); i++) {
			startState.addStartEdge(new Edge(ID_INITIAL.charAt(i), idEndState));
		}
		for (int i = 0; i < ID_BODY.length(); i++) {
			idEndState.addStartEdge(new Edge(ID_BODY.charAt(i), idEndState));
		}
		
		// End state for number
		State intEndState = new State(true, TokenType.NUM);
		for (int i = 0; i < NUM.length(); i++) {
			startState.addStartEdge(new Edge(NUM.charAt(i), intEndState));
		}
		for (int i = 0; i < NUM.length(); i++) {
			intEndState.addStartEdge(new Edge(NUM.charAt(i), intEndState));
		}
		
		State floatState = new State();
		intEndState.addStartEdge(new Edge('.', floatState));
		
		State floatEndState = new State(true, TokenType.NUM);
		for (int i = 0; i < NUM.length(); i++) {
			floatState.addStartEdge(new Edge(NUM.charAt(i), floatEndState));
		}
		for (int i = 0; i < NUM.length(); i++) {
			floatEndState.addStartEdge(new Edge(NUM.charAt(i), floatEndState));
		}
		
		// End state for +
		State plusEndState = new State(true, TokenType.BINARY_ARITHMETIC_OP);
		startState.addStartEdge(new Edge('+', plusEndState));
		
		// End state for ++
		State incrementEndState = new State(true, TokenType.UNARY_ARITHMETIC_OP);
		plusEndState.addStartEdge(new Edge('+', incrementEndState));
		
		// End state for +=
		State plusAssigEndState = new State(true, TokenType.ASSIGNMENT_OP);
		plusEndState.addStartEdge(new Edge('=', plusAssigEndState));
		
		// End state for -
		State minusEndState = new State(true, TokenType.BINARY_ARITHMETIC_OP);
		startState.addStartEdge(new Edge('-', minusEndState));
		
		// End state for --
		State decrementEndState = new State(true, TokenType.UNARY_ARITHMETIC_OP);
		minusEndState.addStartEdge(new Edge('-', decrementEndState));
		
		// End state for -=
		State minusAssigEndState = new State(true, TokenType.ASSIGNMENT_OP);
		minusEndState.addStartEdge(new Edge('=', minusAssigEndState));
		
		// End state for * / %
		State otherArithEndState = new State(true, TokenType.BINARY_ARITHMETIC_OP);
		startState.addStartEdge(new Edge('*', otherArithEndState));
		startState.addStartEdge(new Edge('/', otherArithEndState));
		startState.addStartEdge(new Edge('%', otherArithEndState));
		
		// End state for *= /= %=
		State otherAssigEndState = new State(true, TokenType.ASSIGNMENT_OP);
		otherArithEndState.addStartEdge(new Edge('=', otherAssigEndState));
		
		// End state for =
		State assigEndState = new State(true, TokenType.ASSIGNMENT_OP);
		startState.addStartEdge(new Edge('=', assigEndState));
		
		// End state for ==
		State equalEndState = new State(true, TokenType.RELATION_OP);
		assigEndState.addStartEdge(new Edge('=', equalEndState));
		
		// End state for <
		State lessEndState = new State(true, TokenType.RELATION_OP);
		startState.addStartEdge(new Edge('<', lessEndState));
		
		// End state for <<
		State leftShiftEndState = new State(true, TokenType.SHIFT_OP);
		lessEndState.addStartEdge(new Edge('<', leftShiftEndState));
		
		// End state for <=
		State notMoreEndState = new State(true, TokenType.RELATION_OP);
		lessEndState.addStartEdge(new Edge('=', notMoreEndState));
		
		// End state for >
		State moreEndState = new State(true, TokenType.RELATION_OP);
		startState.addStartEdge(new Edge('>', moreEndState));
		
		// End state for >>
		State rightShiftEndState = new State(true, TokenType.SHIFT_OP);
		moreEndState.addStartEdge(new Edge('>', rightShiftEndState));
		
		// End state for >=
		State notLessEndState = new State(true, TokenType.RELATION_OP);
		moreEndState.addStartEdge(new Edge('=', notLessEndState));
		
		// End state for !=
		State exclamationState = new State();
		startState.addStartEdge(new Edge('!', exclamationState));
		
		State notEqualEndState = new State(true, TokenType.RELATION_OP);
		exclamationState.addStartEdge(new Edge('=', notEqualEndState));
		
		// Construct the DFA
		LexicalDFA defaultDFA = new LexicalDFA(startState);
		return defaultDFA;
	}
	
	

}
