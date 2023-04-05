grammar Calculator;

/*
 * Tokens (terminal)
 *
 * Terminals are basic symbols that cannot
 * be broken down into smaller parts.
 * They're stated in generic terms as
 * their meaning can depend on the context
 * in which they're used, for example:
 * MINUS is used for subtraction, but also for negation.
 */
POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

/*
 * Production Rules (non-terminal)
 *
 * Production rules define how the various components
 * of a language's grammar can be combined to form
 * valid expressions or statements.
 * Non-terminals are used in the production rules
 * to indicate the structure of the language's expressions or statements,
 * and to specify how the tokens and other symbols can be combined.
 */
start : expression;

/*
 * The order in which expressions are evaluated
 * is determined by the order in which possible
 * matching rules are defined.
 * Here, numbers are dealt with first, then parentheses
 * and so on.
 *
 * Multiplication and division are on the
 * same precedence level, so they are grouped.
 * The same goes for addition and subtraction.
 *
 * Labels (e.g. "# Parentheses") are added to each rule
 * to provide context to which rule is being parsed.
 * This can be used in a Listener or Visitor
 * to allow for separate control over Listener or Visitor actions.
 *
 * Likewise, inner labels (e.g. "left=expression")
 * can be added to child nodes of the rule.
 * This makes them identifiable in a
 * Listener's or Visitor's parsing of the rule,
 * allowing for even more fine-grained control.
 */
expression
   : NUMBER                                               # Number
   | '-' right=expression                                 # Negation
   | '(' inner=expression ')'                             # Parentheses
   | left=expression operator=POW right=expression        # Power
   | left=expression operator=(MUL|DIV) right=expression  # MultiplicationOrDivision
   | left=expression operator=(ADD|SUB) right=expression  # AdditionOrSubtraction
   ;
