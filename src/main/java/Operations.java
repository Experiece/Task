import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


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

        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), true, true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), true, true);
        if (valueA == valueB) {
            System.out.println("\nЧисла равны");
            return;
        }
        System.out.println("\nНаибольшее число: " + Math.max(valueA, valueB));
    }


    public static void case2(String userName) {

        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое"), false, false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе"), false, false);
        int valueC = UserInput.getIntFromConsole(Task.createInputRequest(userName, "третье"), false, false);
        int valueD = UserInput.getIntFromConsole(Task.createInputRequest(userName, "четвёртое"), false, false);

        int maxAB = Math.max(valueA, valueB);
        int maxCD = Math.max(valueC, valueD);
        int absoluteMax = Math.max(maxAB, maxCD);

        int minAB = Math.min(valueA, valueB);
        int minCD = Math.min(valueC, valueD);
        int absoluteMin = Math.min(minAB, minCD);

        System.out.println("Наибольшее число: " + absoluteMax +
                " возводим в степень равную наименьшему числу: " + absoluteMin);
        System.out.println(Math.pow(absoluteMax, absoluteMin));
    }


    public static void case3(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), false, false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false, false);
        ArrayList<Integer> arrayA = MathOperations.primeFactorization(valueA);
        ArrayList<Integer> arrayB = MathOperations.primeFactorization(valueB);

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        for (int key : arrayA) {
            int oldValue = 0;
            try {
                oldValue = mapA.get(key);
            } catch (Exception ignored) {
            }
            int newValue = oldValue + 1;
            mapA.put(key, newValue);
        }
        for (int key : arrayB) {
            int value = 0;
            try {
                value = mapB.get(key);
            } catch (Exception ignored) {
            }
            mapB.put(key, value + 1);
        }
        Set<Integer> keySet = mapA.keySet();
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int key : keySet) {
            int aValues = 0;
            int bValues = 0;
            try {
                aValues = mapA.get(key);
                bValues = mapB.get(key);
            } catch (Exception ignored) {
            }
            if (aValues == 0 || bValues == 0) {
                continue;
            }
            resultMap.put(key, Math.min(aValues, bValues));
        }
        Set<Integer> keySet2 = resultMap.keySet();
        int NOD = 1;
        for (int key : keySet2) {
            NOD *= Math.pow(key, resultMap.get(key));
        }
        System.out.println("NOD=" + NOD);
        int NOK = valueA * valueB / NOD;
        System.out.println("NOK=" + NOK);
    }


    public static void case4(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true, true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false, true);

        BaseOperationsResult result = calculateBaseOperations(valueA, valueB);
        System.out.println("Произведение=" + result.derivative);
        System.out.println("Частное=" + result.quotient);
        System.out.println("Сумма=" + result.sum);
        System.out.println("Разноцть=" + result.residual);
        System.out.println("Остаток от деления=" + result.mod);
    }


    public static void case5(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true, true);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false, true);

        BaseOperationsResult result = calculateBaseOperations(valueA, valueB);
        System.out.println(result.derivative + result.quotient + result.sum + result.residual + result.mod);
    }


    public static void case6(String userName) {
        int valueA = UserInput.getIntFromConsole(Task.createInputRequest(userName, "первое число"), true, false);
        int valueB = UserInput.getIntFromConsole(Task.createInputRequest(userName, "второе число"), false, false);
        if (valueA > valueB) {
            int AminusB = valueA - valueB;
            int outputAminusB = MathOperations.calculateFactorial(AminusB);
            System.out.println(outputAminusB);
        }
        if (valueB > valueA) {
            int BminusA = valueB - valueA;
            int outputBminusA = MathOperations.calculateFactorial(BminusA);
            System.out.println(outputBminusA);
        }
        if (valueA == valueB) {
            System.out.println("0");
        }
    }

    public static BaseOperationsResult calculateBaseOperations(int valueA, int valueB) {
        BaseOperationsResult result;
        result = new BaseOperationsResult();

        result.derivative = (long) valueA * valueB;
        result.quotient = (double) valueA / valueB;
        result.sum = (long) valueA + valueB;
        result.residual = valueA - valueB;
        result.mod = valueA % valueB;
        return result;
    }
}
//switch case - изучить и применить
// тернарный оператор - изучить(типа if else)