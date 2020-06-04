import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    public static int convertToInt(String inputValue) {
        int outputValue;
        try {
            outputValue = Integer.parseInt(inputValue);
        } catch (Exception y) {
            System.out.println("Ошибка, введите число от 0 до 2147483647");
            throw new RuntimeException();
        }
        return outputValue;
    }


    public static Map<Integer, Integer> convertToMap(List<Integer> numbersList) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int number : numbersList) {
            int quantityOfCurrentNumber = 0;
            try {
                quantityOfCurrentNumber = numbersMap.get(number);
            } catch (Exception ignored) {
            }
            numbersMap.put(number, quantityOfCurrentNumber + 1);
        }
        return numbersMap;
    }
}
