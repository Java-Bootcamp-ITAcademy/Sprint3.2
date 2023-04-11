package n2exercici1;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc=new Scanner(System.in);
        boolean keepExecution=true;
        String option="";
        while(keepExecution) {
            System.out.println("Choose an option: ");
            System.out.println("1: Paying by credit card");
            System.out.println("2: Paying by Pay pal");
            System.out.println("3: Paying by bank transfer");
            System.out.println("0: Terminate program");
            option=sc.nextLine();
            switch (option) {
                /* Paying by credit card */
                case "1": {
                    Sale sale=new Sale();
                    Payment payment = sale.new CreditCardPayment();
                    sale.salePaymentGate(payment);
                    break;
                }
                /* Paying by PayPal */
                case "2": {
                    Sale sale=new Sale();
                    Payment payment = sale.new PayPalPayment();
                    sale.salePaymentGate(payment);
                    break;
                }
                /* Paying by bank transfer */
                case "3": {
                    Sale sale=new Sale();
                    Payment payment = sale.new BankTransferPayment();
                    sale.salePaymentGate(payment);
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
