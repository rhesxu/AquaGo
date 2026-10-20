package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Data_and_Functions {

    //OBJECTS
    //VARIABLES
    //NUMBERS
    public Data_and_Functions() {

    }
    private int refillq = 0;
    private int returnq = 0;
    private double total = 0;
    private int missing = refillq - returnq;

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

    public void updateSummary() {

        // COMPARING THE MISSING AND REFILLED CONTAINERS
        int missing = Math.max(0, getRefillq() - getReturnq());
        setMissing(missing);
        
        // CALCULATIONS
        double total = (getRefillq() * 25.00) + (getMissing() * 100.00);
        setTotal(total);

        // DISPLAYING
        menu.tfrefill.setText(String.valueOf(getRefillq()));
        menu.tfreturn.setText(String.valueOf(getReturnq()));
        menu.tfest.setText(String.format("%.2f", getTotal()));
    }
    
    public void clearValues() {
        setRefillq(0);
        setReturnq(0);
        setMissing(0);
        setTotal(0.0);
        updateSummary();
}
}
