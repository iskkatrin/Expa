import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Исходные данные о морковке на полянках
        Map<Integer, List<Integer>> carrotsByField = new HashMap<>();
        carrotsByField.put(1, Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        carrotsByField.put(2, Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2));
        carrotsByField.put(3, Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        carrotsByField.put(4, Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4));
        carrotsByField.put(5, Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5));

        // Объединяем все морковки в один список
        List<Integer> carrots = new ArrayList<>();
        for (List<Integer> fieldCarrots : carrotsByField.values()) {
            carrots.addAll(fieldCarrots);
        }

        // Сортировка морковки по убыванию веса
        Collections.sort(carrots, Collections.reverseOrder());

        int totalCarrotsCarried = 0;
        int moves = 10;
        int maxWeightPerMove = 5;

        while (moves > 0 && !carrots.isEmpty()) {
            int currentWeight = 0;
            List<Integer> selectedCarrots = new ArrayList<>();

            Iterator<Integer> iterator = carrots.iterator();
            while (iterator.hasNext()) {
                int carrot = iterator.next();
                if (currentWeight + carrot <= maxWeightPerMove) {
                    currentWeight += carrot;
                    selectedCarrots.add(carrot);
                    iterator.remove();  // Удаляем морковку сразу после выбора
                }
            }

            totalCarrotsCarried += currentWeight;
            moves--;
        }

        System.out.println("Total weight of carrots carried: " + totalCarrotsCarried + " kg");
    }

}