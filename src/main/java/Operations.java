import java.io.IOException;

public class Operations {
    // toDo придумать более удачное название для cases
    public static void cases(String userName) throws IOException {
        int userChoice = UserInput.getUserChoice(userName);
        switch (userChoice) {
            case (1) -> case1(userName);
            case (2) -> case2(userName);
            case (3) -> case3(userName);
            case (4) -> case4(userName);
            case (5) -> case5(userName);
            case (6) -> case6(userName);
            default -> {
                String messageTemplate = "Ошибка!\n" +
                        "Введенные пользователем данные не попадают в область допустимых значений.\n" +
                        "Ожидаемое значение: от 1 до 6\n" +
                        "Реальное значение: %s";
                throw new RuntimeException(String.format(messageTemplate, userChoice));
            }
        }
    }

    public static void case1(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false);
        Task.whatIsBigger(valueA, valueB);
    }

    public static void case2(String userName) {

        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false);
        int valueC = UserInput.getIntFromConsole(Task.createInputRequest(userName, "третье число"), false);
        int valueD = UserInput.getIntFromConsole(Task.createInputRequest(userName, "четвёртое число"), false);

    }

    public static void case3(String userName) {

    }

    public static void case4(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false);

        BaseOperationsResult result = Task.calculateBaseOperations(valueA, valueB);
        System.out.println("Произведение=" + result.derivative);
        System.out.println("Частное=" + result.quotient);
        System.out.println("Сумма=" + result.sum);
        System.out.println("Разноцть=" + result.residual);
        System.out.println("Остаток от деления=" + result.ostatok);
    }

    public static void case5(String userName) {

    }

    public static void case6(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false);
        if (valueA > valueB) {
            int AminusB = valueA - valueB;
            int outputAminusB = calculateFactorial(AminusB);
            System.out.println(outputAminusB);
        }
        if (valueB > valueA) {
            int BminusA = valueB - valueA;
            int outputBminusA = calculateFactorial(BminusA);
            System.out.println(outputBminusA);
        }
        if (valueA == valueB) {
            System.out.println("0");
        }
    }

    static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
//switch case - изучить и применить
// тернарный оператор - изучить(типа if else)