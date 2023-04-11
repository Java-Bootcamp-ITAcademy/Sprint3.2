/* This class converts prices to euro */

package n3exercici1.currencyConverters;

import n3exercici1.Product;

public class ConvertToEuro implements CurrencyConverter {

    @Override
    public void priceConverter(Product product) {
        /* Converting from dolar to euro */
        if(product.getCurrency().equals(Currency.Dolar)) {
            product.setPrice(product.getPrice()*CurrencyConverter.DOLARVSEURO);
        }
        /* Converting from yen to euro */
        else if(product.getCurrency().equals(Currency.Yen)) {
            product.setPrice(product.getPrice()*1/CurrencyConverter.EUROVSYEN);
        }
        product.setCurrency(Currency.Euro);
    }
}
