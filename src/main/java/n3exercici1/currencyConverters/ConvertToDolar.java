/* This class converts prices to dolar */
package n3exercici1.currencyConverters;

import n3exercici1.Product;

public class ConvertToDolar implements CurrencyConverter {

    @Override
    public void priceConverter(Product product) {
        /* Converting from euro to dolar */
        if(product.getCurrency().equals(Currency.Euro)) {
            product.setPrice(product.getPrice()*1/CurrencyConverter.DOLARVSEURO);
        }
        /* Converting from yen to dolar */
        else if(product.getCurrency().equals(Currency.Yen)) {
            product.setPrice(product.getPrice()*1/CurrencyConverter.DOLARVSYEN);
        }
        product.setCurrency(Currency.Dolar);
    }
}
