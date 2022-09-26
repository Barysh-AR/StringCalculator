

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = 0;

        Scanner scan = new Scanner(System.in);
        String  str = scan.nextLine();

        while(true){

            StringCalculator calc = new StringCalculator();
            int sum = calc.add(str);

            if (sum == -1) {System.out.println("Неправильно введено рядок");}
            else {System.out.println("Відповідь: " + sum);}


            System.out.println("Введіть 'e' щоб завершити");
            System.out.println();
            str = scan.nextLine();
            if (str.equals("e")){break;}
        }
    }
}