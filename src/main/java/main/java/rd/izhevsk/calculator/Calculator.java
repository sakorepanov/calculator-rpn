package main.java.rd.izhevsk.calculator;

import main.java.rd.izhevsk.exceptions.DivisionByZero;
import main.java.rd.izhevsk.exceptions.FirstOperandHaveMinus;
import main.java.rd.izhevsk.exceptions.NotSupportedSymbolsException;
import main.java.rd.izhevsk.exceptions.TooManyOperatorsBeside;

import java.util.List;

public class Calculator {

    public void start() {
        MessageManager messageManager = new MessageManager();
        Calculation calculation = new Calculation();
        ExpressionValidator expressionValidator = new ExpressionValidator();
        StringParser stringParser = new StringParser();

        String input = messageManager.enterExpression();
        try {
            expressionValidator.verifyNotSupportedSymbols(input);
        } catch (NotSupportedSymbolsException | TooManyOperatorsBeside | FirstOperandHaveMinus e) {
            e.printStackTrace();
        }


        List<String> inputInList = stringParser.parse(input);
        List<String> convertedToRpn = stringParser.convertToReversePolishNote(inputInList);
        System.out.println("Преобразование выражения в обратную польскую запись: " + convertedToRpn);
        double result = 0;
        try {
            result = calculation.calculate(convertedToRpn);
        } catch (DivisionByZero divisionByZero) {
            divisionByZero.printStackTrace();
        }
        System.out.println(new MessageManager().output(result));
    }

}
