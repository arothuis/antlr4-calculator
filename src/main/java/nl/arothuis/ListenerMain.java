package nl.arothuis;

import nl.arothuis.core.calculator.ListenerBasedCalculator;
import nl.arothuis.infrastructure.driver.Repl;

public class ListenerMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(System.in, new ListenerBasedCalculator());
        repl.start();
    }
}