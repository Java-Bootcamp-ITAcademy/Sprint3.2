/* This class converts prices given a currency converter */
package n3exercici1.currencyConverters;

import n3exercici1.Product;
import java.util.Set;

public class ShoppingListingCurrencyConverter {
    private Set<Product> productList;
    private CurrencyConverter currencyConverter;

    public ShoppingListingCurrencyConverter(Set<Product> productList, CurrencyConverter currencyConverter) {
        this.productList = productList;
        /* Injecting dependence: CurrencyConverter object is injected into this class through constructor */
        this.currencyConverter = currencyConverter;
    }

    public void convertingCurrency() {
        for(Product product:productList) {
            this.currencyConverter.priceConverter(product);
        }
    }
}
