package nl.arothuis.antlr4calculator.core.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListenerBasedCalculatorTest {
    @DisplayName("evaluate simple mathematical expressions")
    @ParameterizedTest
    @MethodSource("nl.arothuis.antlr4calculator.core.calculator.MathExamples#mathExamples")
    void evaluateMathExpressions(String expression, Double expectedResult) {
        Calculator calculator = new ListenerBasedCalculator();
        Double result = calculator.calculate(expression);
        assertEquals(expectedResult, result);
    }
}