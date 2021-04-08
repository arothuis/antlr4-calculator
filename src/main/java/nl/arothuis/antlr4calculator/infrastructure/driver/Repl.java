package nl.arothuis.antlr4calculator.infrastructure.driver;

import nl.arothuis.antlr4calculator.core.calculator.Calculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Repl {
    private final Scanner scanner;
    private final Calculator calculator;
    private final OutputStream output;

    public Repl(InputStream input, Calculator calculator, OutputStream output) {
        this.scanner = new Scanner(input);
        this.calculator = calculator;
        this.output = output;
    }

    public void start() throws IOException {
        while (true) {
            this.write("Calculate: ");

            String line = this.scanner.nextLine();
            if (line.equalsIgnoreCase("exit") || line.isEmpty()) {
                break;
            }

            Double result = this.calculator.calculate(line);

            String response = "\t" + result.toString() + "\n";
            this.write(response);
        }
    }

    private void write(String message) throws IOException {
        this.output.write(message.getBytes(StandardCharsets.UTF_8) );
        this.output.flush();
    }
}
