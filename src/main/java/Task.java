import java.io.IOException;
import java.util.ArrayList;

import static java.lang.StrictMath.sqrt;

class Task {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("Здравствуйте!");
        Thread.sleep(2000);
        String userName = UserInput.getUserName();

        while (true) {
            Operations.cases(userName);
            String message = "Хотите ли вы продолжить операции? \n1 - да \n2 - нет";
            int A = UserInput.getIntFromConsole(message, 1, 2, false);
            if (A == 2) {
                return;
            }
        }
    }

    public static int convertToInt(String inputValue) {
        int outputValue = 0;
        try {
            outputValue = Integer.parseInt(inputValue);
        } catch (Exception y) {
            System.out.println("Ошибка: число должно принадлежать промежутку от -2147483648 до 2147483647, попробуйте ещё раз");
            throw new RuntimeException();
        }
        return outputValue;
    }

    public static String createInputRequest(String userName, String inputName) {
        String messageTemplate = "%s, введите %s от -2147483648 до 2147483647 и нажмите Enter";
        return String.format(messageTemplate, userName, inputName);
    }

    public static BaseOperationsResult calculateBaseOperations(int valueA, int valueB) {
        BaseOperationsResult result;
        result = new BaseOperationsResult();

        result.derivative = (long) valueA * valueB;

        result.quotient = (double) valueA / valueB;

        result.sum = (long) valueA + valueB;

        result.residual = valueA - valueB;

        result.ostatok = valueA % valueB;

        return result;
    }

    public static int findSimpleMultipliers(int potentialPrimeNumber, int currentValue, int multiplier) {
        ArrayList<Integer> primeNumbersArr = new ArrayList<>();

        for (potentialPrimeNumber = 2; potentialPrimeNumber < 100; potentialPrimeNumber++) {
            boolean isPrime = true;
            for (int i = 2; i <= sqrt(potentialPrimeNumber); i++) {
                int mod = potentialPrimeNumber % i;
                if (mod == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(potentialPrimeNumber);
                primeNumbersArr.add(potentialPrimeNumber);
            }
        }

        int inputNumber = 97;

        for (int i = 0; i < primeNumbersArr.size(); i++) {

            int mod = inputNumber % primeNumbersArr.get(i);
            if (mod == 0) {
                System.out.println(primeNumbersArr.get(i));
                inputNumber = inputNumber / primeNumbersArr.get(i);
                i--;
            }
        }
        return inputNumber;
    }
}
// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))