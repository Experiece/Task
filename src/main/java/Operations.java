import java.io.IOException;
import java.util.*;


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

        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), true);
        if (valueA == valueB) {
            System.out.println("\nЧисла равны");
            return;
        }
        System.out.println("\nНаибольшее число: " + Math.max(valueA, valueB));
    }


    public static void case2(String userName) {

        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), false);
        int valueC = UserInput.getIntFromConsole(Task.createInputRequest(userName, "третье"), false);
        int valueD = UserInput.getIntFromConsole(Task.createInputRequest(userName, "четвёртое"), false);

        int absoluteMax = Math.max(Math.max(valueA, valueB), Math.max(valueC, valueD));
        int absoluteMin = Math.min(Math.min(valueA, valueB), Math.min(valueC, valueD));

        System.out.println("Наибольшее число: " + absoluteMax +
                " возводим в степень равную наименьшему числу: " + absoluteMin);
        System.out.print(Math.pow(absoluteMax, absoluteMin));
    }


    public static void case3(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), false);


        int NOD = MathOperations.findNOD(valueA, valueB);
        int NOK = valueA * valueB / NOD;
        System.out.println("NOD=" + NOD);
        System.out.println("NOK=" + NOK);
    }


    public static void case4(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), false);

        BaseOperationsResult result = BaseOperationsResult.calculateBaseOperations(valueA, valueB);
        System.out.println("Произведение=" + result.derivative);
        System.out.println("Частное=" + result.quotient);
        System.out.println("Сумма=" + result.sum);
        System.out.println("Разноcть=" + result.residual);
        System.out.println("Остаток от деления=" + result.mod);
    }


    public static void case5(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), false);

        BaseOperationsResult result = BaseOperationsResult.calculateBaseOperations(valueA, valueB);
        System.out.println(result.derivative + result.quotient + result.sum + result.residual + result.mod);
    }


    public static void case6(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"),
                true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"),
                false);

        if (valueA == valueB) {
            System.out.println("0");
            return;
        }
        int factorial = MathOperations.calculateFactorial(Math.max(valueA, valueB) - Math.min(valueA, valueB));
        System.out.println(factorial);
    }


    public static Map<Integer, Integer> findRepetitiveNumbers(Map<Integer, Integer> mapA, Map<Integer, Integer> mapB) {
        Map<Integer, Integer> repetitiveNumbers = new HashMap<>();
        Set<Integer> uniquePrimeNumbers = mapA.keySet();
        for (int primeNumber : uniquePrimeNumbers) {
            int quantityOfValuesA = 0;
            int quantityOfValuesB = 0;
            try {
                quantityOfValuesA = mapA.get(primeNumber);
                quantityOfValuesB = mapB.get(primeNumber);
            } catch (Exception ignored) {
            }
            if (quantityOfValuesA == 0 || quantityOfValuesB == 0) {
                continue;
            }
            repetitiveNumbers.put(primeNumber, Math.min(quantityOfValuesA, quantityOfValuesB));
        }
        return repetitiveNumbers;
    }
}
//switch case - изучить и применить
// тернарный оператор - изучить(типа if else)