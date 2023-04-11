package n2exercici1;

import java.time.Instant;
import java.util.Date;

public class Sale {
    public static final int MAXCHARRANGE=122;
    /* Max sale amount */
    public static final int MAXAMOUNT=120;
    /* Min sale amount */
    public static final int MINAMOUNT=10;
    /* Sale amount */
    private double amount;
    private Date date;
    /* Payment gate */
    /* Callback to methods implemented in inner classes */
    public void salePaymentGate(Payment payment) {
        payment.paying();
    }
    /* Implementing Payment interface through inner classes */
    /* CreditCardPayment inner */
    public class CreditCardPayment implements Payment {
        String paymentReference="";
        public CreditCardPayment() {
            paymentReference = randomReferenceGenerator();
            paymentReference="CCP-"+paymentReference;
        }
        @Override
        public void paying() {
            try {
                amount=Math.random()*MAXAMOUNT+MINAMOUNT;
                date = Date.from(Instant.now());
                System.out.printf("Total amount: %.2f\n",amount);
                System.out.printf("Transactoin date: "+date+"\n");
                System.out.println("Paying by credit card. Transaction reference: "+paymentReference);
                Thread.sleep(2000);
                System.out.println("Waiting for response");
                Thread.sleep(4000);
                System.out.println("Transaction accepted");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /* PayPalPayment inner */
    public class PayPalPayment implements Payment {
        String paymentReference="";
        public PayPalPayment() {
            paymentReference = randomReferenceGenerator();
            paymentReference="PPP-"+paymentReference;
        }
        @Override
        public void paying() {
            try {
                amount=Math.random()*MAXAMOUNT+MINAMOUNT;
                date = Date.from(Instant.now());
                System.out.printf("Total amount: %.2f\n",amount);
                System.out.printf("Transactoin date: "+date+"\n");
                System.out.println("Paying by Pay Pal. Transaction reference: "+paymentReference);
                Thread.sleep(2000);
                System.out.println("Connecting to main server");
                Thread.sleep(4000);
                System.out.println("Transaction accepted");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /* BankTransferPayment inner */
    public class BankTransferPayment implements Payment {
        String paymentReference="";
        public BankTransferPayment() {
            paymentReference = randomReferenceGenerator();
            paymentReference="BTP-"+paymentReference;
        }
        @Override
        public void paying() {
            try {
                amount=Math.random()*MAXAMOUNT+MINAMOUNT;
                date = Date.from(Instant.now());
                System.out.printf("Total amount: %.2f\n",amount);
                System.out.printf("Transaction date: "+date+"\n");
                System.out.println("Paying by bank transfer. Transaction reference: "+paymentReference);
                Thread.sleep(2000);
                System.out.println("Connecting to bank");
                Thread.sleep(4000);
                System.out.println("Transaction accepted");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /* Generating random alphanumeric reference */
    public static String randomReferenceGenerator() {
        int i=0;
        String s="";
        String toBeReturned="";
        while(i<8) {
            s=String.valueOf((char)((int)(Math.random()*MAXCHARRANGE)));
            if (s.matches("[A-Za-z0-9]+")) {
                toBeReturned+=s;
                i++;
            }
        }
        return toBeReturned;
    }
}
