package nl.arothuis.calculator;

import nl.arothuis.parser.CalculationListener;
import nl.arothuis.parser.CalculatorLexer;
import nl.arothuis.parser.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ListenerBasedCalculator implements Calculator {
    @Override
    public Double calculate(String input) {
        CharStream chars = CharStreams.fromString(input);

        Lexer lexer = new CalculatorLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();

        CalculationListener calculator = new CalculationListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(calculator, tree);

        return calculator.getResult();
    }
}
