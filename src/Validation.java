import Exceptions.FirstOperandHaveMinus;
import Exceptions.NotSupportedSymbolsException;
import Exceptions.TooManyOperatorsBeside;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validation {
    void VerifyNotSupportedSymbols(String input) throws NotSupportedSymbolsException, TooManyOperatorsBeside, FirstOperandHaveMinus {
        Pattern pattern = Pattern.compile("[^*+/0-9\\-.]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new NotSupportedSymbolsException("В выражении обнаружены неподдерживаемые символы.");
        }
        Pattern pattern1 = Pattern.compile("[*+/\\-][*+/\\-]+");
        Matcher matcher1 = pattern1.matcher(input);
        if (matcher1.find()) {
            throw new TooManyOperatorsBeside("В выражении обнаружены несколько операторов сподряд.");
        }
        Pattern pattern2 = Pattern.compile("^-");
        Matcher matcher2 = pattern2.matcher(input);
        if (matcher2.find()) {
            throw new FirstOperandHaveMinus("Первый операнд отрицательное число.");
        }
    }
}
