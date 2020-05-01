import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task {
    public static void main(String[] args) throws InterruptedException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userName;
        System.out.println("Здравствуйте!");
        Thread.sleep(3000);
        System.out.println("Введите имя пользователя:");
        userName = reader.readLine();

        int userChoice = getUserChoice();

        int valueA = getIntFromConsole(userName, "первое число", true);

        int valueB = getIntFromConsole(userName, "второе число", false);

        if (userChoice == 1) {
            whatIsBigger(valueA, valueB);
        }

        if (userChoice == 4) {
            BaseOperationsResult result = calculateBaseOperations(valueA, valueB);
            System.out.println("Произведение=" + result.derivative);
            System.out.println("Частное=" + result.quotient);
            System.out.println("Сумма=" + result.sum);
            System.out.println("Разноцть=" + result.residual);
            System.out.println("Остаток от деления=" + result.ostatok);

        }
        if (userChoice == 5) {

        } else return;// временно

    }

    static int getUserChoice() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Выберите тип операции которую вы хотите соверщить над числами:");
        System.out.println("1)Узнать наибольшее из двух чисел");
        System.out.println("2)Вычислить значение наибольшего числа возведенного в степень наименьшего из 4 введенных чисел(различных, не равных 0)");
        System.out.println("3)Вычислить НОК и НОД 2 чисел(различных, не равных 0).");
        System.out.println("4)Вычислить сумму, разность, произведение, частное и остаток от деления 2 чисел");
        System.out.println("5) Вычислить сумму всех значений из пункта 4");
        System.out.println("6) Вычислить факториал разности 2 введенных чисел");

        String userChoice;
        userChoice = reader.readLine();
        return Integer.parseInt(userChoice);

    }

    static int getIntFromConsole(String userName, String inputName, boolean isCanBeZero) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int outputValue = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            inputRequest(userName, inputName);
            try {
                outputValue = convertToInt(reader.readLine());
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

    static int convertToInt(String inputValue) {
        int outputValue = 0;
        try {
            outputValue = Integer.parseInt(inputValue);
        } catch (Exception y) {
            System.out.println("Ошибка: число должно принадлежать промежутку от -2147483648 до 2147483647, попробуйте ещё раз");
            throw new RuntimeException();
        }
        return outputValue;
    }

    static void inputRequest(String userName, String inputName) {
        String messageTemplate = "%s, введите %s от -2147483648 до 2147483647 и нажмите Enter";
        System.out.println(String.format(messageTemplate, userName, inputName));
    }

    static void whatIsBigger(int valueA, int valueB) {
        if (valueA > valueB) {
            System.out.println(valueA + " - наибольшее число");
        }
        if (valueA < valueB) {
            System.out.println(valueB + " - наибольшее число");
        } else {
            System.out.println("Оба числа равны");
        }

    }

    static BaseOperationsResult calculateBaseOperations(int valueA, int valueB) {
        BaseOperationsResult result;
        result = new BaseOperationsResult();

        result.derivative = (long) valueA * valueB;

        result.quotient = (double) valueA / valueB;

        result.sum = (long) valueA + valueB;

        result.residual = valueA - valueB;

        result.ostatok = valueA % valueB;

        return result;
    }
}
// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))
//ку