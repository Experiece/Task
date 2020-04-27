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

        int valueA = getIntFromConsole(userName, "первое число", true);

        int valueB = getIntFromConsole(userName, "второе число", false);


// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))

        long derivative = (long) valueA * valueB;
        System.out.println("Произведение=" + derivative);
        double quotient = (double) valueA / valueB;
        System.out.println("Частное=" + quotient);
        long sum = (long) valueA + valueB;
        System.out.println("Сумма=" + sum);
        long residual = valueA - valueB;
        System.out.println("Разноцть=" + residual);


        System.out.println("Сумма всех чисел выше=" + (derivative + quotient + sum + residual));
    }


    static int getIntFromConsole(String userName, String inputName, boolean isCanBeZero) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int outputValue = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            inputRequest(userName, inputName);
            try {
                outputValue = convertToInt(reader.readLine());
                if ( (!isCanBeZero) && (outputValue==0) ){
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
}