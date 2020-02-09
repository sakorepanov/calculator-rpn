import Exceptions.DivisionByZero;
import Exceptions.FirstOperandHaveMinus;
import Exceptions.NotSupportedSymbolsException;
import Exceptions.TooManyOperatorsBeside;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NotSupportedSymbolsException, TooManyOperatorsBeside, FirstOperandHaveMinus, DivisionByZero {
        InputOutput inputOutput = new InputOutput();
        Calculation calculation = new Calculation();
        Validation validation = new Validation();

        String input = inputOutput.input();
        validation.VerifyNotSupportedSymbols(input);

        List<String> inputInList = new StringParser().parse(input);
        List<String> convertedToRpn = new StringParser().convertToReversePolishNote(inputInList);
        System.out.println("Преобразование выражения в обратную польскую запись:  " + convertedToRpn);
        double result = calculation.calculate(convertedToRpn);
        System.out.println(new InputOutput().output(result));

    }
}
