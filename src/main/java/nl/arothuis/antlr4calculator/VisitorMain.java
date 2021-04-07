package nl.arothuis.antlr4calculator;

import nl.arothuis.antlr4calculator.core.calculator.VisitorBasedCalculator;
import nl.arothuis.antlr4calculator.infrastructure.driver.Repl;

public class VisitorMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(System.in, new VisitorBasedCalculator());
        repl.start();
    }
}
