package nl.arothuis.antlr4calculator.infrastructure.driver;

import nl.arothuis.antlr4calculator.core.calculator.Calculator;

import java.io.InputStream;
import java.util.Scanner;

public class Repl {
    private final InputStream input;
    private final Calculator calculator;

    public Repl(InputStream input, Calculator calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    public void start() {
        Scanner in = new Scanner(input);

        while (true) {
            System.out.print("Calculate: ");

            String line = in.nextLine();
            if (line.equalsIgnoreCase("exit") || line.isEmpty()) {
                break;
            }
            Double result = calculator.calculate(line);

            System.out.println(result);
        }
    }
}
