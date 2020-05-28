import java.io.IOException;

class Task {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("Здравствуйте!");
        Thread.sleep(2000);
        String userName = UserInput.getUserName();

        while (true) {
            Operations.cases(userName);
            String message = "Хотите ли вы продолжить операции? \n1 - да \n2 - нет";
            int A = UserInput.getIntFromConsole(message, 1, 2, false, true);
            if (A == 2) {
                return;
            }
        }
    }


    public static String createInputRequest(String userName, String inputName) {
        String messageTemplate = "%s, введите %s число от 0 до 2147483647 и нажмите Enter";
        return String.format(messageTemplate, userName, inputName);
    }
}
// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))