package main.java.rd.izhevsk.calculator;

import main.java.rd.izhevsk.exceptions.DivisionByZero;
import main.java.rd.izhevsk.exceptions.FirstOperandHaveMinus;
import main.java.rd.izhevsk.exceptions.NotSupportedSymbolsException;
import main.java.rd.izhevsk.exceptions.TooManyOperatorsBeside;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



class CalculationTest {

    Calculation calculation = new Calculation();
    StringParser stringParser = new StringParser();
    ExpressionValidator expressionValidator = new ExpressionValidator();
    @Test
    void calculate() throws DivisionByZero {
        assertThat(5.0, equalTo(calculation.calculate(stringParser.convertToReversePolishNote(List.of("2", "+", "3")))));
        Assertions.assertEquals(10, calculation.calculate(stringParser.convertToReversePolishNote(List.of("15", "-", "5"))));
        Assertions.assertEquals(15, calculation.calculate(stringParser.convertToReversePolishNote(List.of("150", "/", "10"))));
        Assertions.assertEquals(20, calculation.calculate(stringParser.convertToReversePolishNote(List.of("10", "*", "2"))));
        Assertions.assertThrows(DivisionByZero.class,() -> calculation.calculate(stringParser.convertToReversePolishNote(List.of("2", "/", "0"))));
        Assertions.assertThrows(TooManyOperatorsBeside.class, () -> expressionValidator.verifyNotSupportedSymbols("2++6"));
        Assertions.assertThrows(NotSupportedSymbolsException.class, () -> expressionValidator.verifyNotSupportedSymbols("!+6"));
        Assertions.assertThrows(FirstOperandHaveMinus.class, () -> expressionValidator.verifyNotSupportedSymbols("-5+6"));
    }
}