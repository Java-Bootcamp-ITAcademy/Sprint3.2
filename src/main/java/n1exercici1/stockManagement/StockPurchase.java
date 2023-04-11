package n1exercici1.stockManagement;

import java.util.Objects;

/* This class registers any stock purchase by any gicen market */
public class StockPurchase {
    private String name;
    private double value;
    private int numOfStocks;

    public StockPurchase(String name, double value, int num) {
        this.name = name;
        this.value = value;
        this.numOfStocks=num;
    }
    public StockPurchase(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getNumOfStocks() {
        return numOfStocks;
    }

    public void setNumOfStocks(int numOfStocks) {
        this.numOfStocks = numOfStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPurchase stockPurchase = (StockPurchase) o;
        return name.equals(stockPurchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Stock: "+this.getName()+", Value: "+this.value+", Stocks number: "+this.getNumOfStocks();
    }
}
