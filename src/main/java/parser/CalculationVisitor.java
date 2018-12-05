package parser;

public class CalculationVisitor extends CalculatorBaseVisitor<Double> {
    /**
     * Numbers are non-terminal.
     * Although less precise, a double makes it
     * easier to deal with division in this toy application.
     *
     * @return Double
     */
    @Override
    public Double visitNumber(CalculatorParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }

    /**
     * Parentheses are used to give precedence to
     * the expression around which they are wrapped.
     *
     * This precedence is caused elsewhere,
     * in the grammar, via the order in which
     * the rules are defined (ANTLR4).
     *
     * @return Double
     */
    @Override
    public Double visitParentheses(CalculatorParser.ParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }

    /**
     * @return Double
     */
    @Override
    public Double visitPower(CalculatorParser.PowerContext ctx) {
        return Math.pow(this.visit(ctx.left), this.visit(ctx.right));
    }

    /**
     * @return Double
     */
    @Override
    public Double visitMultiplication(CalculatorParser.MultiplicationContext ctx) {
        return this.visit(ctx.left) * this.visit(ctx.right);
    }

    /**
     * @return Double
     */
    @Override
    public Double visitDivision(CalculatorParser.DivisionContext ctx) {
        return this.visit(ctx.left) / this.visit(ctx.right);
    }

    /**
     * @return Double
     */
    @Override
    public Double visitAddition(CalculatorParser.AdditionContext ctx) {
        return this.visit(ctx.left) + this.visit(ctx.right);
    }

    /**
     * @return Double
     */
    @Override
    public Double visitSubtraction(CalculatorParser.SubtractionContext ctx) {
        return this.visit(ctx.left) - this.visit(ctx.right);
    }
}
