package net.sahet.utils;

/**
 * enum-constant, used to represent keyboard symbols.
 * 
 * 
 * @author Azat
 */
public enum KeyboardSymbol {
	EXCLAMATION("!"), //
	AT("@"), //
	HASH("#"), //
	DOLLAR("$"), //
	PERCENT("%"), //
	CARET("^"), //
	AMPERSANT("&"), //
	ASTERISK("*"), //
	OPEN_PARANTHESIS("("), //
	CLOSE_PARANTHESIS(")"), //
	UNDERSCORE("_"), //
	PLUS("+"), //
	HYPHEN("-"), //
	TRIPLE_DASH("---"), //
	EQUALS("="), //
	OPEN_CURLY_BRACE("{"), //
	CLOSE_CURLY_BRACE("}"), //
	PIPE("|"), //

	OPEN_SQUARE_BRACKET("["), //
	CLOSE_SQUARE_BRACKET("]"), //

	FORWARD_SLASH("/"), //
	BACK_SLASH("\\"), //
	DOT("."), //
	COMMA(","), //

	SINGLE_QUOTE("'"), //
	QUOTE("\""), //
	COLON(":"), //
	SEMICOLON(";"), //

	QUESTION_MARK("?"), //
	LESS_THAN("<"), //
	GREATER_THAN(">"), //

	EMPTY_SPACE(""), //
	SPACE(" "), //

	/*
	 * java Escape Sequences: easy-to-remember:
	 * "big farm needs red tractors - \b\f\n\r\t"
	 */
	BACK_SPACE("\b"), //
	FEED("\f"), //
	NEW_LINE("\n"), //
	CR("\r"), //
	TAB("\t");

	private final String value;

	private KeyboardSymbol(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public String getName() {
		return this.name();
	}
}
