

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String  str = scan.nextLine();

        StringCalculator calc = new StringCalculator();
        int sum = calc.add(str);

        if (sum == -1) {System.out.println("Неправильно введено рядок");}
        else {System.out.println("Відповідь: " + sum);}
    }
}