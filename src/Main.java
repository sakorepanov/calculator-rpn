import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = new InputOutput().input();
        System.out.println(input);
        List<String> inputInList = new StringParser().parse(input);
        System.out.println(inputInList);
        List<String> convertedToRpn = new StringParser().convertToReversePolishNote(inputInList);
        System.out.println(convertedToRpn);
        double calculation = new Calculation().calculate(convertedToRpn);
        System.out.println(calculation);
        System.out.println(new InputOutput().output(calculation));

    }
}
