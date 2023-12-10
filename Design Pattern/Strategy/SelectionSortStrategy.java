package Strategy;

public class SelectionSortStrategy implements Strategy {
    @Override
    public void sorting(int[] arrays) {
        int n = arrays.length;

        for (int i = 0; i < n-1; i++) {
            int i_min = i;
            for (int j = i+1; j < n; j++)
                if (arrays[j] < arrays[i_min])
                    i_min = j;

            int temp = arrays[i_min];
            arrays[i_min] = arrays[i];
            arrays[i] = temp;
        }
    }
}