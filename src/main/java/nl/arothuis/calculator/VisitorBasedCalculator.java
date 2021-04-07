package nl.arothuis.calculator;

import nl.arothuis.parser.CalculationVisitor;
import nl.arothuis.parser.CalculatorLexer;
import nl.arothuis.parser.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

public class VisitorBasedCalculator implements Calculator {
    @Override
    public Double calculate(String input) {
        CharStream chars = CharStreams.fromString(input);

        Lexer lexer = new CalculatorLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();

        CalculationVisitor calculator = new CalculationVisitor();
        return calculator.visit(tree);
    }
}
