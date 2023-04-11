package n1exercici1.marketObservers;

import n1exercici1.marketAnalytics.MarketFluctuation;

public class NASDAQMarketObserver extends MarketObserver {
    public NASDAQMarketObserver(MarketFluctuation marketFluctuation, String name) {
        super(marketFluctuation, name);
    }
}
