package nl.arothuis.antlr4calculator.core.parser;

import java.util.Stack;

public class CalculationListener extends CalculatorBaseListener {
    /**
     * A stack is used to track what numbers
     * we have seen last. This is our only
     * means of communicating values.
     *
     * The right number in
     * an operation is always the last one seen or
     * calculated for that operation. Because a stack
     * works via Last In First Out,
     * the right number should be "popped" off first.
     */
    private final Stack<Double> stack = new Stack<>();

    @Override
    public void exitNumber(CalculatorParser.NumberContext ctx) {
        Double number = Double.parseDouble(ctx.NUMBER().getText());
        this.stack.push(number);
    }

    @Override
    public void exitNegation(CalculatorParser.NegationContext ctx) {
        Double right = this.stack.pop();
        this.stack.push(-1 * right);
    }

    @Override
    public void exitPower(CalculatorParser.PowerContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(Math.pow(left, right));
    }

    @Override
    public void exitMultiplicationOrDivision(CalculatorParser.MultiplicationOrDivisionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        if (ctx.operator.getText().equals("*")) {
            this.stack.push(left * right);
        } else {
            this.stack.push(left / right);
        }
    }

    @Override
    public void exitAdditionOrSubtraction(CalculatorParser.AdditionOrSubtractionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        if (ctx.operator.getText().equals("+")) {
            this.stack.push(left + right);
        } else {
            this.stack.push(left - right);
        }
    }

    /**
     * The last value on the stack is the result of all
     * applied calculations.
     *
     * @return Double
     */
    public Double getResult() {
        return this.stack.pop();
    }
}
