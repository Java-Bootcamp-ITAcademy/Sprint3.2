package n1exercici1.marketAnalytics;

import n1exercici1.marketObservers.MarketObserver;
import n1exercici1.stockManagement.StockFluctuation;

import java.util.ArrayList;
import java.util.List;

/* This class manages market fluctuations */
public class MarketFluctuation {
    private List<MarketObserver> observers;
    private StockFluctuation stockFluctuation;

    public MarketFluctuation() {
        this.observers = new ArrayList<>();
    }

    public List<MarketObserver> getObservers() {
        return observers;
    }

    public StockFluctuation getStockFluctuation() {
        return stockFluctuation;
    }

    public void setStockFluctuation(StockFluctuation stockFluctuation) {
        this.stockFluctuation = stockFluctuation;
    }

    /* Calls all the markets in order to update its stocks */
    public void setStockValue(StockFluctuation stockFluctuation) {
        this.stockFluctuation=stockFluctuation;
       for(MarketObserver marketObserver:observers) {
           marketObserver.updateStocksValue();
       }
   }

   /* Prints all the market observers */
   public void printingObservers() {
        int position=1;
        for(MarketObserver marketObserver:this.observers) {
            System.out.println(position+": "+marketObserver.toString());
            position++;
        }
   }


}
