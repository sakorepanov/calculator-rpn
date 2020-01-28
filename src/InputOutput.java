import java.util.Scanner;

public class InputOutput {
    String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        return input;
    }

    String output(double calculation){
        return "Результат :" + calculation;
    }


}
