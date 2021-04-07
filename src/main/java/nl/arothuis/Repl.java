package nl.arothuis;

import nl.arothuis.calculator.Calculator;

import java.util.Scanner;

public class Repl {
    private final Calculator calculator;

    public Repl(Calculator calculator) {
        this.calculator = calculator;
    }

    void start() {
        Scanner in = new Scanner(System.in);

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
