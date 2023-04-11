package n1exercici1.stockManagement;

public class StockFluctuation {
    private String name;
    private double value;

    /* This class registers any market fluctuation */
    public StockFluctuation(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
