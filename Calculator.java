import java.util.Scanner;

import static java.lang.String.valueOf;

public class Calculator {
    public static void main(String[] args) throws ScannerException, NullPointerException {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner scanner = new Scanner((System.in));
        System.out.println("Введите выражение с операндами от нуля до десяти: ");
        String expression = scanner.nextLine();
        //Какой знак у выражения?
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (expression.contains(actions[i])) {
                actionIndex = i;
                /*break;*/
            }
        }

            if (actionIndex == -1) {
                throw new ArrayIndexOutOfBoundsException(actionIndex);
            }

        //Делим строку по символу выражения (.split из регулярного выражения)
        String[] data = expression.split(regexActions[actionIndex]);
        if (data.length > 2) {
            throw new ArrayIndexOutOfBoundsException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        //Проверяем условие тождества типа чисел
        boolean isRoman;
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;

            isRoman = converter.isRoman(data[0]);

            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if (a > 10 || b > 10) {
                throw new ScannerException("Введите выражение с операндами от нуля до десяти.");
            }

            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                if(result > 0) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    throw new NullPointerException("В римской системе счисления нет отрицательных чисел");
                }
            } else {
                System.out.println(result);
            }
        } else {
            throw new ScannerException("Тип чисел не совпадает");
        }
    }
}


