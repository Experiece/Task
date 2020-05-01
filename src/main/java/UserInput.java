import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getUserName() throws IOException {
        System.out.println("Введите имя пользователя:");
        return reader.readLine();
    }

    public static int getIntFromConsole(String userName, String inputName, boolean isCanBeZero) {

        int outputValue = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            Task.inputRequest(userName, inputName);
            try {
                outputValue = Task.convertToInt(reader.readLine());
                if ((!isCanBeZero) && (outputValue == 0)) {
                    continue;
                }
                isInputCorrect = true;
            } catch (Exception y) {
                isInputCorrect = false;
            }
        }
        return outputValue;
    }

    public static int getUserChoice() throws IOException {
        System.out.println("выберите тип операции которую вы хотите соверщить над числами:");
        System.out.println("1)Узнать наибольшее из двух чисел");
        System.out.println("2)Вычислить значение наибольшего числа возведенного в степень наименьшего из 4 введенных " +
                "чисел(различных, не равных 0)");
        System.out.println("3)Вычислить НОК и НОД 2 чисел(различных, не равных 0).");
        System.out.println("4)Вычислить сумму, разность, произведение, частное и остаток от деления 2 чисел");
        System.out.println("5) Вычислить сумму всех значений из пункта 4");
        System.out.println("6) Вычислить факториал разности 2 введенных чисел");

        String userChoice;
        userChoice = reader.readLine();
        return Integer.parseInt(userChoice);

    }
}
