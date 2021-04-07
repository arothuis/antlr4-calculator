package nl.arothuis;

import nl.arothuis.calculator.VisitorBasedCalculator;

public class VisitorMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(new VisitorBasedCalculator());
        repl.start();
    }
}
