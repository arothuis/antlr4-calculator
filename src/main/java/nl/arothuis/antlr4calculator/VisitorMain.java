package nl.arothuis.antlr4calculator;

import nl.arothuis.antlr4calculator.core.calculator.ListenerBasedCalculator;
import nl.arothuis.antlr4calculator.core.calculator.VisitorBasedCalculator;
import nl.arothuis.antlr4calculator.infrastructure.driver.Repl;

import java.io.IOException;

public class VisitorMain {
    public static void main(String[] args) throws IOException {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(
                System.in,
                new VisitorBasedCalculator(),
                System.out
        );

        repl.start();
    }
}
