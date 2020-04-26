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


        String userInputA;
        String userInputB;
        int changedValueA = 0;
        int changedValueB = 0;
        boolean isInputCorrect;

        System.out.println(userName + ", введите первое число от -2147483648 до 2147483647 и нажмите Enter");


        do {
            try {
                userInputA = reader.readLine();
                changedValueA = Integer.parseInt(userInputA);
                isInputCorrect = true;
            } catch (Exception E) {
                System.out.println("Ошибка: число должно принадлежать промежутку от -2147483648 до 2147483647, попробуйте ещё раз");
                Thread.sleep(2000);
                System.out.println("Введите первое число повторно и нажмите Enter");
                isInputCorrect = false;
            }
        } while (!isInputCorrect);



        System.out.println("Введите второе число в промежутке от -2147483648 до 2147483647 и нажмите Enter");


        isInputCorrect = false;
        while (!isInputCorrect) {
            try {
                userInputB = reader.readLine();
                changedValueB = Integer.parseInt(userInputB);
                isInputCorrect = true;
            }
            catch (Exception Y) {
                System.out.println("Ошибка: число должно принадлежать промежутку от -2147483648 до 2147483647, попробуйте ещё раз");
                Thread.sleep(2000);
                System.out.println("Введите второе число повторно и нажмите Enter");
                isInputCorrect = false;
            }
        }
        boolean isZero = changedValueB == 0;
// объеденить все в один цикл, сделать дополнительную проверку в одном цикле(try+catch/if)
// меняй isInputCorrect
// в нужный момент использовать break/continue
// использовать дебагер(следуй шаг за шагом отследивая значения переменных(состояние программы))

        long derivative = (long) changedValueA * changedValueB;
        System.out.println("Произведение=" + derivative);
        double quotient = (double) changedValueA / changedValueB;
        System.out.println("Частное=" + quotient);
        long sum = (long) changedValueA + changedValueB;
        System.out.println("Сумма=" + sum);
        long residual = changedValueA - changedValueB;
        System.out.println("Разноцть=" + residual);


        System.out.println("Сумма всех чисел выше=" + (derivative + quotient + sum + residual));
    }
}
//    boolean isZero = changedValueB == 0;
//                if (isZero) {
//                        do {
//                        System.out.println("Ошибка, второе число не может равняться нулю");
//                        System.out.println("Введите второе число повторно и нажмите Enter");
//                        userInputB = reader.readLine();
//                        changedValueB = Integer.parseInt(userInputB);
//                        isZero = changedValueB == 0;
//                        }
//                        while (isZero ==false);
//                        break;}