import java.io.IOException;

class Task {
    public static void main(String[] args) throws InterruptedException, IOException {


        System.out.println("Здравствуйте!");
        Thread.sleep(2000);
        String userName = UserInput.getUserName();

        while (true) {
            Operations.possibleOperations(userName);
            String message = "\nХотите ли вы продолжить операции? \n1 - да \n2 - нет";
            int A = UserInput.getIntFromConsole(message, 1, 2, false);
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