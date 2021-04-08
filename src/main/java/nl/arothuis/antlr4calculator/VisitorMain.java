package nl.arothuis.antlr4calculator;

import nl.arothuis.antlr4calculator.core.calculator.VisitorBasedCalculator;
import nl.arothuis.antlr4calculator.infrastructure.driver.Repl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class VisitorMain {
    public static void main(String[] args) throws IOException {
        Repl repl = new Repl(
                new InputStreamReader(System.in),
                new VisitorBasedCalculator(),
                new PrintWriter(System.out)
        );

        repl.start();
    }
}
