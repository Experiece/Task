import java.io.IOException;

class Task {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Здравствуйте!");
        Thread.sleep(2000);
        String userName = UserInput.getUserName();

        while (true) {
            Operations.cases(userName);
            System.out.println("Хотите ли вы продолжить операции? \n1 - да \n2 - нет");
            int A = UserInput.getIntFromConsole(userName, "число", false);
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

    public static void inputRequest(String userName, String inputName) {
        String messageTemplate = "%s, введите %s от -2147483648 до 2147483647 и нажмите Enter";
        System.out.println(String.format(messageTemplate, userName, inputName));
    }

    public static void whatIsBigger(int valueA, int valueB) {
        if (valueA > valueB) {
            System.out.println(valueA + " - наибольшее число");
        }
        if (valueA < valueB) {
            System.out.println(valueB + " - наибольшее число");
        }
        if (valueA == valueB) {
            System.out.println("\nЧисла равны\n");
        }

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
}
// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))
//ку