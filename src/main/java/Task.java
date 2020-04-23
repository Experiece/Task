import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String BadA;


        System.out.println("Введите первое число от -2147483648 до 2147483647 и нажмите Enter");
        BadA = reader.readLine();


        int A;
        try {
            A = Integer.parseInt(BadA);
        } catch (Exception E) {
            System.out.println("Ошибка: А не удовлеторяет условиям, попробуйте ещё раз");
            System.out.println("Введите первое число повторно от -2147483648 до 2147483647 и нажмите Enter");
            BadA = reader.readLine();
            try {
                A = Integer.parseInt(BadA);
            } catch (Exception W) {
                System.out.println("Ошибка: А не удовлеторяет условиям, попробуйте ещё раз");
                System.out.println("Введите первое число повторно от -2147483648 до 2147483647 и нажмите Enter");
                BadA = reader.readLine();
                try {
                    A = Integer.parseInt(BadA);
                } catch (Exception Q) {
                    System.out.println("Программа завершает работу");
                    System.out.println("Ты слишком тупой, сорри");
                    return;
                }

            }

        }


        String BadB;


        System.out.println("Введите второе число от -2147483648 до 2147483647 и нажмите Enter");
        BadB = reader.readLine();


        int B;
        try {
            B = Integer.parseInt(BadB);
        } catch (Exception R) {
            System.out.println("Ошибка: B не удовлеторяет условиям, попробуйте ещё раз");
            System.out.println("Введите второе число повторно от -2147483648 до 2147483647 и нажмите Enter");
            BadB = reader.readLine();
            try {
                B = Integer.parseInt(BadB);
            } catch (Exception T) {
                System.out.println("Ошибка: B не удовлеторяет условиям, попробуйте ещё раз");
                System.out.println("Введите второе число повторно от -2147483648 до 2147483647 и нажмите Enter");
                BadB = reader.readLine();
                try {
                    B = Integer.parseInt(BadB);
                } catch (Exception Y) {
                    System.out.println("программа завершает работу");
                    System.out.println("Ты слишком тупой, сорри");
                    return;
                }

                boolean isZero = B == 0;

                if (isZero) {
                    System.out.println("Ошибка, второе число не может равняться нулю");
                    return;
                }
            }
        }
        long derivative = (long) A * B;
        System.out.println("Производное=" + derivative);
        double quotient = (double) A / B;
        System.out.println("Частное=" + quotient);
        long sum = (long) A + B;
        System.out.println("Сумма=" + sum);
        long residual = A - B;
        System.out.println("Разноцть=" + residual);



        System.out.println("Сумма всех чисел выше=" + (derivative + quotient + sum + residual));  }
}