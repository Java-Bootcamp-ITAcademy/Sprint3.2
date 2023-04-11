/* This class converts prices to yen */

package n3exercici1.currencyConverters;

import n3exercici1.Product;

public class ConvertToYen implements CurrencyConverter {
    @Override
    public void priceConverter(Product product) {
        /* Converting from dolar to yen */
        if(product.getCurrency().equals(Currency.Dolar)) {
            product.setPrice(product.getPrice()*CurrencyConverter.DOLARVSYEN);
        }
        /* Converting from euro to yen */
        else if(product.getCurrency().equals(Currency.Euro)) {
            product.setPrice(product.getPrice()*CurrencyConverter.EUROVSYEN);
        }
        product.setCurrency(Currency.Yen);
    }
}
