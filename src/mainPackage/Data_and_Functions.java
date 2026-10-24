package mainPackage;
import java.time.LocalDate;

//-------------------------------------------------------------ABSTRACT CLASS--------------------------------------------------------//
abstract class TransactionCalculator {

    //ABSTRACT METHODS
    public abstract double calculateTotal(int refill, int missing);

    public abstract int calculateMissing(int refill, int returned);

    public abstract double calculateChange(double cash, double total);
}

//-------------------------------------------------------------MAIN CLASS--------------------------------------------------------//
public class Data_and_Functions extends TransactionCalculator {
        
    //ABSTRACT METHOS IMPLEMENTATION    
        @Override
        public double calculateTotal(int refill, int missing) {
            return (refill * Settings.refillPrice) + (missing * Settings.missingFee);
        }

        @Override
        public int calculateMissing(int refill, int returned) {
        int result = refill - returned;

        if (result < 0) {
            result = 0;
        }

        return result;
    }

        @Override
        public double calculateChange(double cash, double total) {
        return cash - total;
    }

    //VARIABLES
        //STATIC DATA
        public static int orderCount = AquagoLoadSave.loadOrderCount();
        static LocalDate date = LocalDate.now();
        
        //DATA HIDING
        private int refillq = 0;
        private int returnq = 0;
        private double total = 0;
        private int missing = refillq - returnq;

    //ENCAPSULATION
        //CONSTRUCTOR OVERLOADING
        public Data_and_Functions() {

    }
        public Data_and_Functions(int refillq, int returnq, double total, int missing) {
        this.refillq = refillq;
        this.returnq = returnq;
        this.total = total;
        this.missing = missing;
    }

        //GETTER SETTER
        
        public LocalDate getDate (){
            return date;
    }
        
        public void setMissing(int missing) {
            this.missing = missing;
    }

        public int getMissing() {
            return missing;
    }

        public int getRefillq() {
            return refillq;
    }

        public void setRefillq(int refillq) {
            this.refillq = refillq;
    }

        public int getReturnq() {
            return returnq;
    }

        public void setReturnq(int returnq) {
            this.returnq = returnq;
    }

        public double getTotal() {
            return total;
    }

        public void setTotal(double total) {
            this.total = total;
        }

    //FUNCTIONS
        
        //Summary update
        public void updateSummary() {

        // COMPARING THE MISSING AND REFILLED CONTAINERS
        int missing = calculateMissing(getRefillq(), getReturnq());
        setMissing(missing);

        // CALCULATIONS
        double total = calculateTotal(getRefillq(), getMissing());
        setTotal(total);

        // DISPLAYING
        menu.tfrefill.setText(String.valueOf(getRefillq()));
        menu.tfreturn.setText(String.valueOf(getReturnq()));
        menu.tfest.setText(String.format("%.2f", getTotal()));
    }
        
        //Clearing
        public void clearValues() {
        setRefillq(0);
        setReturnq(0);
        setMissing(0);
        setTotal(0.0);
        updateSummary();
    }
        
        //ID Generation
        public String generateOrderID() {
            orderCount++;
            AquagoLoadSave.saveOrderCount(orderCount);
            return String.format("AQ-%06d", orderCount);
}
        
        //PRINT RECEIPT
        public void printReceipt(double cash, double balance,String orderID, String name, String contact, String address) {

            System.out.println("==================================");
            System.out.println("             AQUAGO               ");
            System.out.println("          OFFICIAL RECEIPT        ");
            System.out.println("==================================");
            System.out.println("Order ID: " + orderID);
            System.out.println("Date: " + getDate());
            System.out.println("Full Name: " + name);
            System.out.println("Contact No.: " + contact);
            if (address.trim().isEmpty()) {
            System.out.println("Address: Not provided");
            } else {
            System.out.println("Address: " + address);
            }
            System.out.println("----------------------------------");
            System.out.println("Water Refill: " + getRefillq());
            System.out.println("Returned Containers: " + getReturnq());
            System.out.println("Missing Containers: " + getMissing());
            System.out.println("----------------------------------");
            System.out.println(String.format("Refill Price: P%.2f", Settings.refillPrice));
            System.out.println(String.format("Missing Container Fee: P%.2f", Settings.missingFee));
            System.out.println("----------------------------------");
            System.out.println(String.format("Total Amount: P%.2f", getTotal()));
            System.out.println(String.format("Cash Received: P%.2f", cash));
            System.out.println(String.format("Change: P%.2f", balance));

        System.out.println("==================================");
        System.out.println("      THANK YOU FOR ORDERING!    ");
        System.out.println("==================================");
    }
}
