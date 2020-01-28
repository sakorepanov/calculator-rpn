import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    static List<String> output = new ArrayList<>();
    static Deque<String> stackForOperators = new ArrayDeque<>();

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        final int precedence;
        Operator(int p) {
            precedence = p;
        }
    }

    private Map<String, Operator> operatorMap = new HashMap<String, Operator>() {
        {
            put("+", Operator.ADD);
            put("-", Operator.SUBTRACT);
            put("*", Operator.MULTIPLY);
            put("/", Operator.DIVIDE);
        }
    };

    List<String> parse(String input) {
        List<String> output = new ArrayList<>();
        Pattern operand = Pattern.compile("\\d+\\.*\\d*\\s*");
        Matcher operandMatcher = operand.matcher(input);
        Pattern operator = Pattern.compile("[-+/*]");
        Matcher operatorMatcher = operator.matcher(input);
        while (operandMatcher.find()) {
            output.add(operandMatcher.group());
            if (operatorMatcher.find(operandMatcher.end())) {
                output.add(operatorMatcher.group());
            }
        }
        return output;
    }

    private boolean isHigherPrecedence (String operator, String sub) {
        return (operatorMap.containsKey(sub) && operatorMap.get(sub).precedence >= operatorMap.get(operator).precedence);
    }

    public List<String> convertToReversePolishNote(List<String> output){
        ArrayList<String> list = new ArrayList<>();
        for (String token : output) {
            if (operatorMap.containsKey(token)) {
                while (!stackForOperators.isEmpty() && isHigherPrecedence(token,stackForOperators.peek())){
                    list.add(stackForOperators.pop());
                }
                stackForOperators.push(token);
            } else {
                list.add(token);

            }
        }
        while (!stackForOperators.isEmpty()){

            list.add(stackForOperators.pop());
        }

        return list;
    }
}
