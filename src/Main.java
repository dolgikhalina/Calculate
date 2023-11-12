import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scn.nextLine();
        String calc = calc(input);
        System.out.println(calc);
    }

    public static String calc(String input) throws Exception {
        String[] data = input.split(" ");
        checkLenght(data);
        String action = data[1];
        checkAction(action);
        int number1 = getNumber(data[0]);
        int number2 = getNumber(data[2]);
        int result = getResult(number1, number2, action);
        return String.valueOf(result);
    }

    public static void checkLenght(String[] data) throws IOException {
        if (data.length > 3) {
            throw new IOException("Введите выражение с двумя операндами");
        }
    }

    public static void checkAction(String action) throws Exception {
        if (!(action.equals("+") | action.equals("-") | action.equals("*") | action.equals("/"))) {
            throw new Exception("Проверьте знак арифметического действия");
        }
    }

    public static int getNumber(String number) throws Exception {
        int a;
        try {
            a = Integer.parseInt(number);
            if (a < 0 || a > 10) {
                throw new IOException("Введите число от 0 до 10");
            }
        } catch (Exception e) {
            throw new Exception("Введите целое число");
        }
        return a;
    }

    public static int getResult(int number1, int number2, String action) {
        int result = 0;
        if (action.equals("+")) {
            result = number1 + number2;
        }
        if (action.equals("-")) {
            result = number1 - number2;
        }
        if (action.equals("*")) {
            result = number1 * number2;
        }
        if (action.equals("/")) {
            result = number1 / number2;
        }
        return result;
    }
}
