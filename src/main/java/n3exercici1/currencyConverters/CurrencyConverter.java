package n3exercici1.currencyConverters;

import n3exercici1.Product;

public interface CurrencyConverter {
    double DOLARVSEURO=0.9164;
    double DOLARVSYEN=132.1156;
    double EUROVSYEN=144.1811;

    void priceConverter(Product product);
}
