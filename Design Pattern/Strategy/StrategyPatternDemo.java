package Strategy;

import Strategy.Context;
import java.util.Arrays;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        int[] arrays = {1, 6, 7, 2, 5, 3, 4, 0, 9, 8, 12};

        Context context = new Context(new BubbleSortStrategy());
        context.executeSort(arrays);
        System.out.println("Bubble Sort: " + Arrays.toString(arrays));

        context = new Context(new SelectionSortStrategy());
        context.executeSort(arrays);
        System.out.println("Selection Sort: " + Arrays.toString(arrays));

    }
}
