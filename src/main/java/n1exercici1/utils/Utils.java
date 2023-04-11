package n1exercici1.utils;

import n1exercici1.marketAnalytics.MarketFluctuation;
import n1exercici1.marketObservers.DowJonesMarketObserver;
import n1exercici1.marketObservers.MarketObserver;
import n1exercici1.marketObservers.NASDAQMarketObserver;
import n1exercici1.marketObservers.NikkeiMarketObserver;
import n1exercici1.stockManagement.StockFluctuation;
import n1exercici1.stockManagement.StockPurchase;

import java.util.Iterator;
import java.util.Scanner;

public class Utils {
    public static Scanner sc=new Scanner(System.in);
    public static MarketObserver marketObserver;
    public static MarketFluctuation marketFluctuation;
    public static void menu() {
        boolean keepExecution=true;
        String option="";
        marketFluctuation=new MarketFluctuation();
        while(keepExecution) {
            System.out.println("Choose an option: ");
            System.out.println("1: New market");
            System.out.println("2: Purchase Stocks");
            System.out.println("3: List Stocks for a given market");
            System.out.println("4: Update Stocks value");
            System.out.println("0: Terminate program");
            option=sc.nextLine();
            switch (option) {
                case "1": {
                    createMarket();
                    break;
                }
                case "2": {
                    stockPurchasing();
                    break;
                }
                case "3": {
                    marketStocksListing();
                    break;
                }
                case "4": {
                    stockUpdating();
                    break;
                }
                case "0": {
                    sc.close();
                    keepExecution=false;
                }
            }
        }
    }
    /* Generates a new market */
    public static void createMarket() {
        System.out.println("Where market is located? Type 'Dow Jones', 'NASDAQ' or 'Nikkei'");
        String market=sc.nextLine();
        System.out.println("Introduce market name");
        String name=sc.nextLine();
        if(market.equals("Dow Jones")) {
            marketObserver=new DowJonesMarketObserver(marketFluctuation,name);
        }
        else if(market.equals("NASDAQ")) {
            marketObserver=new NASDAQMarketObserver(marketFluctuation,name);
        }
        else if(market.equals("Nikkei")) {
            marketObserver=new NikkeiMarketObserver(marketFluctuation,name);
        }
        else {
            System.out.println("This market doesn't exist");
        }
    }
    /* Generates a new stock purchase */
    public static void stockPurchasing() {
        System.out.println("Who is purchasing Stocks? Select the position on the list");
        marketFluctuation.printingObservers();
        int position=Integer.parseInt(sc.nextLine());
        marketObserver = marketFluctuation.getObservers().get(position-1);
        System.out.println("Which Stocks is it buying?");
        String name=sc.nextLine();
        System.out.println("Which is the value of the Stocks?");
        double value=Double.parseDouble(sc.nextLine());
        System.out.println("How many Stocks is it buying?");
        int quantity=Integer.parseInt(sc.nextLine());
        StockPurchase stockPurchase= new StockPurchase(name,value,quantity);
        boolean marketNotFound=true;
        Iterator<MarketObserver> it=marketFluctuation.getObservers().iterator();
        while(marketNotFound  && it.hasNext()) {
            MarketObserver auxMarketObserver=it.next();
            if(auxMarketObserver.equals(marketObserver)) {
                auxMarketObserver.getStocksPurchases().add(stockPurchase);
                auxMarketObserver.calculatePortFolioValue();
                marketNotFound=false;
            }
        }
    }

    /* Lists stocks given a market */
    public static void marketStocksListing() {
        System.out.println("Which market do you want to list?");
        marketFluctuation.printingObservers();
        int position=Integer.parseInt(sc.nextLine());
        marketObserver = marketFluctuation.getObservers().get(position-1);
        marketObserver.printingStocksListAndPortfolio();
    }

    /* Updates stocks value */
    public static void stockUpdating() {
        System.out.println("Which Stocks are being updated?");
        String stocksName=sc.nextLine();
        System.out.println("Which is the new value?");
        Double stocksValue=Double.parseDouble(sc.nextLine());
        StockFluctuation stockFluctuation=new StockFluctuation(stocksName,stocksValue);
        marketFluctuation.setStockFluctuation(stockFluctuation);
        marketFluctuation.setStockValue(stockFluctuation);
    }
}
