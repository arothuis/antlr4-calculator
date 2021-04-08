package nl.arothuis.antlr4calculator.infrastructure.driver;

import nl.arothuis.antlr4calculator.core.calculator.Calculator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * A REPL (read-evaluate-print-loop) is a continuously
 * running program which:
 *
 * 1. reads input
 * 2. evaluates the input
 * 3. prints the result of the evaluation
 */
public class Repl {
    private final Scanner scanner;
    private final Calculator calculator;
    private final Writer output;

    public Repl(Reader input, Calculator calculator, Writer output) {
        this.scanner = new Scanner(input);
        this.calculator = calculator;
        this.output = output;
    }

    public void start() throws IOException {
        while (true) {
            // Read
            this.write("Calculate: ");
            String line = this.scanner.nextLine();

            // Evaluate
            if (line.equalsIgnoreCase("exit") || line.isEmpty()) {
                this.writeLine("\tGoodbye");
                break;
            }
            Double result = this.calculator.calculate(line);

            // Print
            this.writeLine("\t" + result.toString());
        }
    }

    private void write(String message) throws IOException {
        this.output.write(message);
        this.output.flush();
    }

    private void writeLine(String line) throws IOException {
        this.write(line + "\n");
    }
}
