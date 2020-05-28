import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int convertToInt(String inputValue) {
        int outputValue = 0;
        try {
            outputValue = Integer.parseInt(inputValue);
        } catch (Exception y) {
            System.out.println("Ошибка: число должно принадлежать промежутку от 0 до 2147483647, попробуйте ещё раз");
            throw new RuntimeException();
        }
        return outputValue;
    }


    public static String getUserName() throws IOException {
        System.out.println("Введите имя пользователя:");
        return reader.readLine();
    }


    public static int getIntFromConsole(String consoleMessage, boolean isCanBeZero, boolean isCanBeNegative) {
        return getIntFromConsole(consoleMessage, 0, Integer.MAX_VALUE, isCanBeZero, isCanBeNegative);
    }


    public static int getIntFromConsole(String consoleMessage, int minValue, int maxValue, boolean isCanBeZero, boolean isCanBeNegative) {
        int outputValue = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            if (!consoleMessage.equals("")) {
                System.out.println(consoleMessage);
            }
            try {
                outputValue = convertToInt(reader.readLine());
                if ((outputValue < minValue) || (outputValue > maxValue)) {
                    continue;
                }
                if ((!isCanBeZero) && (outputValue == 0) && isCanBeNegative) {
                    continue;
                }
                isInputCorrect = true;
            } catch (Exception ignored) {
            }
        }
        return outputValue;
    }


    public static int getUserChoice(String userName) throws IOException {
        String message = (userName + ", выберите тип операции которую вы хотите соверщить над числами:" +
                "\n1 )Узнать наибольшее из двух чисел" +
                "\n2) Вычислить значение наибольшего числа возведенного в степень наименьшего из 4 введенных чисел(различных, не равных 0)" +
                "\n3) Вычислить НОК и НОД 2 чисел(различных, не равных 0)." +
                "\n4) Вычислить сумму, разность, произведение, частное и остаток от деления 2 чисел" +
                "\n5) Вычислить сумму всех значений из пункта 4" +
                "\n6) Вычислить факториал разности 2 введенных чисел");

        return getIntFromConsole(message, 1, 6, false, true);
    }
}
