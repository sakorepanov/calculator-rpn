package main.java.rd.izhevsk.calculator;

import main.java.rd.izhevsk.exceptions.DivisionByZero;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculation {
    double calculate(List<String> list) throws DivisionByZero {
        Deque<Double> stack = new ArrayDeque<>();
        String operators = "+-*/";
            for (String token : list) {
                if (!operators.contains(token)) {
                    stack.push(Double.valueOf(token));
                } else {
                    double a = stack.pop();
                    double b = stack.pop();
                    int index = operators.indexOf(token);
                    switch (index){
                        case 0:
                            stack.push(a+b);
                            break;
                        case 1:
                            stack.push(b-a);
                            break;
                        case 2:
                            stack.push(a*b);
                            break;
                        case 3:
                            stack.push(b/a);
                            if (0 == a) {
                                throw new DivisionByZero("Обнаружено деление на ноль.");
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + index);
                    }
                }
            }
        return stack.pop();
    }

}
