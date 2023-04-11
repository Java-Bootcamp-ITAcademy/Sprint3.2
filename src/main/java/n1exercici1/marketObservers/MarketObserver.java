package n1exercici1.marketObservers;

import n1exercici1.marketAnalytics.MarketFluctuation;
import n1exercici1.stockManagement.StockPurchase;

import java.util.*;
/* Market observers class */
public abstract class MarketObserver {
    protected String marketName;
    protected MarketFluctuation marketFluctuation;
    protected List<StockPurchase> stockPurchases;
    protected double portFolioValue;

    public MarketObserver(MarketFluctuation marketFluctuation, String name) {
        this.marketName=name;
        this.marketFluctuation=marketFluctuation;
        marketFluctuation.getObservers().add(this);
        this.stockPurchases =new ArrayList<>();
    }

    public String getMarketName() {
        return marketName;
    }

    public MarketFluctuation getMarketFluctuation() {
        return marketFluctuation;
    }

    public List<StockPurchase> getStocksPurchases() {
        return stockPurchases;
    }

    public void setStocks(List<StockPurchase> stockPurchases) {
        this.stockPurchases = stockPurchases;
    }

    public double getPortFolioValue() {
        return portFolioValue;
    }


    public void stocksPurchasing(StockPurchase stockPurchase) {
        this.getStocksPurchases().add(stockPurchase);
    }

    /* Calculates total portfolio value for a given observer */
    public void calculatePortFolioValue() {
        this.portFolioValue=0;
        for(StockPurchase stockPurchase :this.getStocksPurchases()) {
           this.portFolioValue+= stockPurchase.getValue()*stockPurchase.getNumOfStocks();
        }
    }

    /* Updates stocks value given a market fluctuation */
    public void updateStocksValue() {
        boolean stockNotFound=true;
        Iterator<StockPurchase> it=this.getStocksPurchases().iterator();
        while(it.hasNext()&&stockNotFound) {
          StockPurchase stockPurchase=it.next();
          if(this.getMarketFluctuation().getStockFluctuation().getName().equals(stockPurchase.getName())) {
              stockPurchase.setValue(this.getMarketFluctuation().getStockFluctuation().getValue());
          }
        }
        this.calculatePortFolioValue();
    }

    /* Prints stocks portfolio and its value for a given observer */
    public void printingStocksListAndPortfolio() {
        for(StockPurchase stockPurchase:this.getStocksPurchases()) {
            System.out.println(stockPurchase.toString());
        }
        System.out.println("Total portfolio value is: "+this.getPortFolioValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketObserver that = (MarketObserver) o;
        return marketName.equals(that.marketName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketName);
    }

    @Override
    public String toString() {
        String observer="";
        if(this instanceof DowJonesMarketObserver) {
            observer=this.getMarketName()+" - Dow Jones";
        }
        else if(this instanceof NikkeiMarketObserver) {
            observer=this.getMarketName()+" - Nikkei";
        }
        else if(this instanceof NASDAQMarketObserver) {
            observer=this.getMarketName()+" - NASDAQ";
        }
        return observer;
    }
}
