import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор арабских и римских чисел");
        System.out.println("Введите ваш запрос: ");
        String Input = scanner.nextLine();
        System.out.println(Calc(Input));
    }

    public static String Calc(String Input) throws Exception {
        int num1;
        int num2;
        String InputOperation;
        String result;
        boolean isRomanian;
        String[] operand = Input.split("[+\\-*/]");
        if (operand.length != 2) throw new Exception("Формат математической операции не удовлетворяет калькулятору - два операнда и один оператор (+, -, /, *)");
        InputOperation = searchOperation(Input);
        if (InputOperation == null) throw new Exception("Калькулятор не поддерживает данную математическую операцию");
        if (isRoman(operand[0]) && isRoman(operand[1])) {
            num1 = convertToArabian(operand[0]);
            num2 = convertToArabian(operand[1]);
            isRomanian = true;
        }
        else if (!isRoman(operand[0]) && !isRoman(operand[1])) {
            num1 = Integer.parseInt(operand[0]);
            num2 = Integer.parseInt(operand[1]);
            isRomanian = false;
        }
        else {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calculate(num1, num2, InputOperation);
        if (isRomanian) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String searchOperation(String valueOper) {
        if (valueOper.contains("+")) return "+";
        else if (valueOper.contains("-")) return "-";
        else if (valueOper.contains("*")) return "*";
        else if (valueOper.contains("/")) return "/";
        else return null;
    }

    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }
    static int calculate(int a, int b, String operation) {

        if (operation.equals("+")) return a + b;
        else if (operation.equals("-")) return a - b;
        else if (operation.equals("*")) return a * b;
        else return a / b;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}