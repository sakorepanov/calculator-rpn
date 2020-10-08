package main.java.rd.izhevsk.calculator;

import java.util.Scanner;

public class MessageManager {
    String enterExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        return scanner.nextLine();
    }

    String output(double calculation){
        return "Результат :" + calculation;
    }


}
