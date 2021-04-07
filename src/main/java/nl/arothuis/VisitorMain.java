package nl.arothuis;

import nl.arothuis.core.calculator.VisitorBasedCalculator;
import nl.arothuis.infrastructure.driver.Repl;

public class VisitorMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(System.in, new VisitorBasedCalculator());
        repl.start();
    }
}
