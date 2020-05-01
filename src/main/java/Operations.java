import java.io.IOException;

public class Operations {
    // toDo придумать более удачное название для cases
    public static void cases(String userName) throws IOException {
        int userChoice = UserInput.getUserChoice();

        if (userChoice == 1) {
            case1(userName);
        }
        if (userChoice == 2) {
            case2(userName);
        }
        if (userChoice == 3) {
            case3(userName);
        }
        if (userChoice == 4) {
            case4(userName);
        }
        if (userChoice == 5) {
            case5(userName);
        }
        if (userChoice == 6) {
            case6(userName);
        } else return; //временно
    }

    public static void case1(String userName) {
        int valueA = UserInput.getIntFromConsole(userName, "первое число", true);
        int valueB = UserInput.getIntFromConsole(userName, "второе число", false);
        Task.whatIsBigger(valueA, valueB);

    }

    public static void case2(String userName) {

        int valueA = UserInput.getIntFromConsole(userName, "первое число", false);
        int valueB = UserInput.getIntFromConsole(userName, "второе число", false);
        int valueC = UserInput.getIntFromConsole(userName, "третье число", false);
        int valueD = UserInput.getIntFromConsole(userName, "четвёртое число", false);

    }

    public static void case3(String userName) {

    }

    public static void case4(String userName) {
        int valueA = UserInput.getIntFromConsole(userName, "первое число", true);
        int valueB = UserInput.getIntFromConsole(userName, "второе число", false);

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

    }
}
