import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.CalculationListener;
import parser.CalculatorLexer;
import parser.CalculatorParser;

import java.util.Scanner;

public class ListenerMain {
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

            CalculationListener calculator = new CalculationListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(calculator, tree);

            Double result = calculator.getResult();

            System.out.println(result);
        }
    }
}