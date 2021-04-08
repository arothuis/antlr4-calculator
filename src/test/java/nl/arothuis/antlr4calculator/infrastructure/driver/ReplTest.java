package nl.arothuis.antlr4calculator.infrastructure.driver;

import nl.arothuis.antlr4calculator.core.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplTest {
    @Test
    @DisplayName("evaluate input, print result, end with exit")
    void readEvaluatePrintExit() throws IOException {
        var input =
                "1 + 2\n" + "exit\n";

        var reader = new StringReader(input);
        var calculator = Mockito.mock(Calculator.class);
        var writer = new StringWriter();

        var repl = new Repl(reader, calculator, writer);
        Mockito.when(calculator.calculate("1 + 2"))
                .thenReturn(3.0);

        repl.start();

        var expectedPrintOutput =
                "Calculate: \t3.0\n" + "Calculate: \tGoodbye\n";

        assertEquals(expectedPrintOutput, writer.toString());
    }

    @Test
    @DisplayName("evaluate input, print result, end with newline")
    void readEvaluatePrintEmpty() throws IOException {
        var input = "1 + 2\n" + "\n";

        var reader = new StringReader(input);
        var calculator = Mockito.mock(Calculator.class);
        var writer = new StringWriter();

        var repl = new Repl(reader, calculator, writer);
        Mockito.when(calculator.calculate("1 + 2"))
                .thenReturn(3.0);

        repl.start();

        var expectedPrintOutput =
                "Calculate: \t3.0\n" + "Calculate: \tGoodbye\n";

        assertEquals(expectedPrintOutput, writer.toString());
    }
}