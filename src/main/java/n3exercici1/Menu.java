package n3exercici1;

import n3exercici1.currencyConverters.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static void menu() {
        Set<Product> products = new HashSet<>();
        Scanner sc=new Scanner(System.in);
        boolean keepExecution=true;
        String option="";
        while(keepExecution) {
            System.out.println("Choose an option: ");
            System.out.println("1: Generating product");
            System.out.println("2: Printing product list");
            System.out.println("3: Changing items currency");
            System.out.println("0: Terminate program");
            option=sc.nextLine();
            switch (option) {
                /* Generating product and adding it to the list */
                case "1": {
                    System.out.println("Which is the product name?");
                    String name = sc.nextLine();
                    System.out.println("Which is the product price?");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.println("Type the currency: euro, dolar, yen");
                    String inputCurrency;
                    inputCurrency=sc.nextLine();
                    Currency currency=null;
                    if(inputCurrency.equals("dolar")) {
                        currency=Currency.Dolar;
                    }
                    else if(inputCurrency.equals("euro")) {
                        currency=Currency.Euro;
                    }
                    else if(inputCurrency.equals("yen")) {
                        currency=Currency.Yen;
                    }
                    products.add(new Product(name,price,currency));
                    break;
                }
                /* Listing products */
                case "2": {
                    for(Product product:products) {
                        System.out.println(product.toString());
                    }
                    break;
                }
                /* Changing products currency */
                case "3": {
                    System.out.println("Type the new currency: euro, dolar, yen");
                    String inputCurrency;
                    CurrencyConverter currencyConverter=null;
                    inputCurrency=sc.nextLine();
                    if(inputCurrency.equals("dolar")) {
                        currencyConverter=new ConvertToDolar();
                    }
                    else if(inputCurrency.equals("euro")) {
                        currencyConverter=new ConvertToEuro();
                    }
                    else if(inputCurrency.equals("yen")) {
                        currencyConverter=new ConvertToYen();
                    }
                    ShoppingListingCurrencyConverter shoppingListingCurrencyConverter = new ShoppingListingCurrencyConverter(products,currencyConverter);
                    shoppingListingCurrencyConverter.convertingCurrency();
                    break;
                }
                /* Terminating program */
                case "0": {
                    sc.close();
                    keepExecution=false;
                }
            }
        }
    }
}
