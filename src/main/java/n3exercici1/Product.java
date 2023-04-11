/* Products to be inserted to the list */
package n3exercici1;

import n3exercici1.currencyConverters.Currency;

import java.text.DecimalFormat;

public class Product {
    private String name;
    private double price;
    private final String reference;
    private Currency currency;
    public static final int MAXCHARRANGE=122;

    public Product(String name, double price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.reference = referenceGenerator();
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /* Generating random reference code */
    private String referenceGenerator() {
        String reference="";
        int i=0;
        while(i<8) {
            String s;
            s=String.valueOf((char)((int)(Math.random()*MAXCHARRANGE)));
            if (s.matches("[A-Za-z0-9]+")) {
                reference+=s;
                i++;
            }
        }
        return "P-"+reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return reference.equals(product.reference);
    }

    @Override
    public int hashCode() {
        return this.reference.hashCode();
    }

    @Override
    public String toString() {
        String s="";
        DecimalFormat f = new DecimalFormat("##.00");
        s+="Name: "+this.name+" | Price: "+f.format(this.price);
        if(this.getCurrency().equals(Currency.Euro)) {
            s+="€";
        }
        else if(this.getCurrency().equals(Currency.Dolar)) {
            s+="$";
        }
        else if(this.getCurrency().equals(Currency.Yen)) {
            s+="y";
        }
        s+=" | Reference: "+this.reference;
        return s;
    }
}
