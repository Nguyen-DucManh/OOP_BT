package Strategy;

public class BubbleSortStrategy implements Strategy {
    @Override
    public void sorting(int[] arrays) {
        int n = arrays.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arrays[j] > arrays[j+1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
    }
}