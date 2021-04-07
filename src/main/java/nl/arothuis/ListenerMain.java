package nl.arothuis;

import nl.arothuis.calculator.ListenerBasedCalculator;

public class ListenerMain {
    public static void main(String[] args) {
        // Start read-evaluate-print-loop (REPL)
        Repl repl = new Repl(new ListenerBasedCalculator());
        repl.start();
    }
}