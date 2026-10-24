
package mainPackage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AquagoLoadSave {

    //FILE NAME
    private static final String SAVE_FILE = "aquagoData.txt";

    //SAVE TRANSACTION
    public static void saveTransaction(String orderID, String customerName, String contact, String address, int refilled, int returned, double total) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(SAVE_FILE, true));

            writer.write("TRANSACTION\t"
                    + LocalDate.now() + "\t"
                    + clean(customerName) + "\t"
                    + clean(contact) + "\t"
                    + clean(address) + "\t"
                    + refilled + "\t"
                    + returned + "\t"
                    + String.format("%.2f", total) + "\t"
                    + clean(orderID));

            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving transaction: "
                    + e.getMessage());
        }
    }

    //REMOVE TABS AND NEW LINES
    private static String clean(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\t", " ")
                .replace("\n", " ")
                .replace("\r", " ");
    }

    //LOAD SAVED TRANSACTIONS
    public static ArrayList<Object[]> loadTransactions() {

        ArrayList<Object[]> records = new ArrayList<>();
        File file = new File(SAVE_FILE);

        if (!file.exists()) {
            return records;
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\t", -1);

                if ((data.length == 8 || data.length == 9)&& data[0].equals("TRANSACTION")) {
                    //ADDRESS
                    String address = data[4];

                    if (address.trim().isEmpty()) {
                    address = "N/A";
                    }

                    //ORDER ID
                    String id = "N/A";
                    if (data.length == 9) {
                    id = data[8];
                    }
                    try {
                        Object[] record = {
                            data[1], //DATE
                            data[2], //NAME
                            data[3], //CONTACT
                            address, //ADDRESS
                            Integer.parseInt(data[5]), //REFILLED
                            Integer.parseInt(data[6]), //RETURNED
                            String.format("₱%.2f",
                            Double.parseDouble(data[7])), //PRICE
                            id //ORDER ID
                        };

                        records.add(record);

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid transaction: " + line);
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading transactions: "
                    + e.getMessage());
        }

        return records;
    }
    
    
    //LOAD THE LAST ORDER NUMBER
    public static int loadOrderCount() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("orderCount.txt"));

            int count = Integer.parseInt(reader.readLine());
            reader.close();
            return count;

        } catch (IOException | NumberFormatException e) {
            return 100000;
        }
    }

    //SAVE THE LATEST ORDER NUMBER
    public static void saveOrderCount(int count) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("orderCount.txt"));

            writer.write(String.valueOf(count));
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving Order ID: " + e.getMessage());
        }
    }
    
    
    //SAVE PRICES TO FILE
    public static void savePrices(double refill, double missing) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("prices.txt"));

            writer.write(String.valueOf(refill));
            writer.newLine();
            writer.write(String.valueOf(missing));

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving prices: " + e.getMessage());
        }
    }

    //LOAD SAVED PRICES
    public static double[] loadPrices() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("prices.txt"));

            double refill = Double.parseDouble(reader.readLine());
            double missing = Double.parseDouble(reader.readLine());

            reader.close();

            if (Double.isFinite(refill) && Double.isFinite(missing)
                    && refill >= 0 && missing >= 0) {
                return new double[]{refill, missing};
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Using default prices.");
        }

        return new double[]{25.00, 100.00};
    }
    
    
    //SAVE ADMIN PASSWORD
    public static void saveAdminPassword(String password) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("adminPassword.txt"));

            writer.write(password);
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving password: " + e.getMessage());
        }
    }

    //LOAD ADMIN PASSWORD
    public static String loadAdminPassword() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("adminPassword.txt"));

            String password = reader.readLine();
            reader.close();

            if (password != null && !password.isEmpty()) {
                return password;
            }

        } catch (IOException e) {
            System.out.println("Using default admin password.");
        }

        return "AquaGo123";
    }


}
