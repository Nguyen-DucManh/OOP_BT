package Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeSort(int[] arrays){
        strategy.sorting(arrays);
    }
}