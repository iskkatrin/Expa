import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Исходные данные о морковке на полянках
        List<Integer> carrots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 10; j++) {
                carrots.add(i);
            }
        }

        // Сортировка морковки по убыванию веса
        Collections.sort(carrots, Collections.reverseOrder());

        int totalCarrotsCarried = 0;
        int moves = 10;
        int maxWeightPerMove = 5;

        while (moves > 0 && !carrots.isEmpty()) {
            int currentWeight = 0;
            List<Integer> selectedCarrots = new ArrayList<>();

            for (int i = 0; i < carrots.size(); i++) {
                if (currentWeight + carrots.get(i) <= maxWeightPerMove) {
                    currentWeight += carrots.get(i);
                    selectedCarrots.add(carrots.get(i));
                }
            }

            // Удаляем выбранную морковку из списка
            for (Integer carrot : selectedCarrots) {
                carrots.remove(carrot);
            }

            totalCarrotsCarried += currentWeight;
            moves--;
        }

        System.out.println("Total weight of carrots carried: " + totalCarrotsCarried + " kg");
    }
}