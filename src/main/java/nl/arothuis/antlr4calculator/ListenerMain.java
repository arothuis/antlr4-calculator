package nl.arothuis.antlr4calculator;

import nl.arothuis.antlr4calculator.core.calculator.ListenerBasedCalculator;
import nl.arothuis.antlr4calculator.infrastructure.driver.Repl;

public class ListenerMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(System.in, new ListenerBasedCalculator());
        repl.start();
    }
}