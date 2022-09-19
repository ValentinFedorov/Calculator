import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String expressions;
    static String result;

    static int arabianResult;
    static int romanResult;



    public static void main(String[] args) {
        System.out.println("Введите математическое выражение, используя только римские или только арабские числа от 1 до 10");
        Scanner term = new Scanner(System.in);
        String input = term.nextLine();
        expressions = input;



        calc(input);
        System.out.println(result);

    }


    public static String calc(String input) {

        String[] arabianNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] expression;
        expression = input.split("[-*/+]");
        String num_1 = expression[0];
        String num_2 = expression[1];
        Converter converter = new Converter();

        if (expression.length > 2) {
            System.out.println("Ошибка, может быть только два операнда и один оператор!");
            System.exit(0);
        }





        if (Arrays.asList(arabianNum).contains(num_1) && Arrays.asList(arabianNum).contains(num_2)) {
            int x = Integer.parseInt(num_1);
            int y = Integer.parseInt(num_2);
            arabianCalculate(x,y);
        } else if (Arrays.asList(romanNum).contains(num_1) && Arrays.asList(romanNum).contains(num_2)) {
            int convertedX;
            int convertedY;
            convertedX = converter.romanToInt (num_1);
            convertedY = converter.romanToInt (num_2);
            romanCalculate(convertedX, convertedY);
        } else {
            System.out.println("Неправильное значение, попробуй 1-10 только римскими или только арабскими числами");
            System.exit(0);
        }
        if (Arrays.asList(romanNum).contains(num_1) && Arrays.asList(romanNum).contains(num_2)) {
            result = converter.intToRoman(romanResult);
        } else if (Arrays.asList(arabianNum).contains(num_1) && Arrays.asList(arabianNum).contains(num_2)) {
            result = String.valueOf(arabianResult);
        } else {
            System.out.println("ERROR");
        }
        return result;
    }


    static Integer arabianCalculate(int x, int y) {
        if (expressions.contains("+")) {
            arabianResult = x + y;

        } else if (expressions.contains("-")) {
            arabianResult = x - y;
            //return arabianResult;
        } else if (expressions.contains("*")) {
            arabianResult = x * y;
            //return arabianResult;
        } else if (expressions.contains("/")) {
            arabianResult = x / y;
            //return arabianResult;
        } else {
            System.out.println("ERROR");
            System.exit(0);
        }
        return arabianResult;
    }
    static int romanCalculate (int convertedX, int convertedY) {
        if (expressions.contains("+")) {
            romanResult = convertedX + convertedY;

        } else if (expressions.contains("-")) {
            romanResult = convertedX - convertedY;
            //return arabianResult;
        } else if (expressions.contains("*")) {
            romanResult = convertedX * convertedY;
            //return arabianResult;
        } else if (expressions.contains("/")) {
            romanResult = convertedX / convertedY;
            //return arabianResult;
        } else {
            System.out.println("ERROR");
            System.exit(0);
        }
        return romanResult;
    }

    }
