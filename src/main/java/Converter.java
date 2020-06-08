import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    public static int convertToInt(String inputValue) {
        int outputValue;
        if (inputValue.matches("[\\w*]")) {
            System.out.println("Ошибка. Пожалуйста введите натуральное число.\n");
        }
        try {
            outputValue = Integer.parseInt(inputValue);
        } catch (Exception y) {
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
