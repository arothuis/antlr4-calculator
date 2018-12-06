import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.CalculatorLexer;
import parser.CalculatorParser;
import parser.CalculationVisitor;

import java.util.Scanner;

public class VisitorMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Calculate: ");
            String line = in.nextLine();
            if (line.toLowerCase().equals("exit") || line.isEmpty()) {
                break;
            }
            CharStream lineStream = CharStreams.fromString(line);

            Lexer lexer = new CalculatorLexer(lineStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokens);
            ParseTree tree = parser.start();

            CalculationVisitor calculator = new CalculationVisitor();
            Double result = calculator.visit(tree);

            System.out.println(result);
        }
    }
}
