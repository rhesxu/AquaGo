package mainPackage;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Transactions extends Admin implements ActionListener, KeyListener {

    //COMPONENTS
    JTextField tfsearch = new JTextField();
    JComboBox<String> tffrom = new JComboBox<>();
    JComboBox<String> tfto = new JComboBox<>();

    JComboBox<String> sortbox = new JComboBox<>(
            new String[]{"Newest first", "Oldest first"}
    );

    JButton btfilter = new JButton("Apply");

    JTable table;
    DefaultTableModel model;
    //STORES ALL RECORDS EVEN WHEN TABLE IS FILTERED
    ArrayList<Object[]> records = new ArrayList<>();

    //METHOD OVERRIDING
    @Override
    public JPanel getPanel() {

        //COLORS
        Color navy = Color.decode("#174678");
        Color blue = Color.decode("#3096DE");
        Color lightblue = Color.decode("#EAF4FC");
        Color linecolor = Color.decode("#D5E7F7");
        Color muted = Color.decode("#7694AE");
        Color white = Color.WHITE;

        //MAIN PANEL
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setPreferredSize(new Dimension(1100, 745));

        //--------------------TITLE--------------------

        JLabel title = new JLabel("Transaction");
        title.setBounds(35, 30, 300, 40);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(navy);
        mainpanel.add(title);

        JLabel subtitle = new JLabel("View and manage all water refill transactions.");
        subtitle.setBounds(35, 68, 420, 25);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(muted);
        mainpanel.add(subtitle);

        //--------------------FILTER PANEL--------------------

        JPanel filterpanel = new JPanel(null);
        filterpanel.setBounds(35, 110, 1030, 80);
        filterpanel.setBackground(white);
        filterpanel.setBorder(BorderFactory.createLineBorder(linecolor, 1));
        mainpanel.add(filterpanel);

        //SEARCH
        tfsearch.setBounds(20, 20, 350, 40);
        tfsearch.setFont(new Font("Arial", Font.PLAIN, 14));
        tfsearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(linecolor, 1),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));
        tfsearch.setText("");
        filterpanel.add(tfsearch);

        JLabel searchlabel = new JLabel("Search by name, contact number, or address");
        searchlabel.setBounds(30, 2, 300, 18);
        searchlabel.setFont(new Font("Arial", Font.PLAIN, 11));
        searchlabel.setForeground(muted);
        filterpanel.add(searchlabel);

        //FROM
        JLabel fromlabel = new JLabel("From");
        fromlabel.setBounds(405, 2, 80, 18);
        fromlabel.setFont(new Font("Arial", Font.BOLD, 12));
        fromlabel.setForeground(navy);
        filterpanel.add(fromlabel);

        tffrom.setBounds(405, 20, 150, 40);
        tffrom.setFont(new Font("Arial", Font.PLAIN, 14));
        tffrom.setBackground(lightblue);
        tffrom.setFocusable(false);
        filterpanel.add(tffrom);

        //TO
        JLabel tolabel = new JLabel("To");
        tolabel.setBounds(585, 2, 80, 18);
        tolabel.setFont(new Font("Arial", Font.BOLD, 12));
        tolabel.setForeground(navy);
        filterpanel.add(tolabel);

        tfto.setBounds(585, 20, 150, 40);
        tfto.setFont(new Font("Arial", Font.PLAIN, 14));
        tfto.setBackground(lightblue);
        tfto.setFocusable(false);
        filterpanel.add(tfto);

        //SORT
        JLabel sortlabel = new JLabel("Sort");
        sortlabel.setBounds(770, 2, 80, 18);
        sortlabel.setFont(new Font("Arial", Font.BOLD, 12));
        sortlabel.setForeground(navy);
        filterpanel.add(sortlabel);

        sortbox.setBounds(770, 20, 170, 40);
        sortbox.setFont(new Font("Arial", Font.PLAIN, 14));
        sortbox.setBackground(lightblue);
        sortbox.setFocusable(false);
        filterpanel.add(sortbox);

        //FILTER BUTTON
        btfilter.setBounds(950, 20, 60, 40);
        btfilter.setFont(new Font("Arial", Font.BOLD, 13));
        btfilter.setBackground(blue);
        btfilter.setForeground(Color.WHITE);
        btfilter.setBorder(null);
        btfilter.setFocusPainted(false);
        filterpanel.add(btfilter);

        //--------------------TABLE PANEL--------------------

        JPanel tablepanel = new JPanel(new BorderLayout());
        tablepanel.setBounds(35, 210, 1030, 500);
        tablepanel.setBackground(Color.WHITE);
        tablepanel.setBorder(BorderFactory.createLineBorder(linecolor, 1));
        mainpanel.add(tablepanel);

        //TABLE MODEL
        String[] columns = {
            "Date",
            "Customer Name",
            "Contact No.",
            "Address",
            "Refilled",
            "Returned",
            "Price"
        };

        model = new DefaultTableModel(columns, 0);

        //SAMPLE DATA
        records.add(new Object[]{"2026-10-21", "Juan Dela Cruz", "09171234567", "Bustos, Bulacan", 8, 6, "₱400.00"});
        records.add(new Object[]{"2026-10-20", "Maria Santos", "09181234567", "Baliwag, Bulacan", 5, 5, "₱125.00"});
        records.add(new Object[]{"2026-10-19", "Pedro Reyes", "09191234567", "Not provided", 10, 8, "₱450.00"});
        records.add(new Object[]{"2026-10-18", "Ana Cruz", "09201234567", "San Rafael, Bulacan", 3, 3, "₱75.00"});
        records.add(new Object[]{"2026-10-17", "Liza Garcia", "09211234567", "Plaridel, Bulacan", 7, 6, "₱275.00"});

        //DATE DROPDOWNS (DATES FROM TRANSACTION RECORDS)
        tffrom.addItem("Any date");
        tfto.addItem("Any date");

        for (int i = 0; i < records.size(); i++) {
            String date = records.get(i)[0].toString();
            tffrom.addItem(date);
            tfto.addItem(date);
        }

        //TABLE
        table = new JTable(model);
        //DISABLE CELL EDITING WITHOUT CREATING AN EXTRA CLASS
        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(35);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.setSelectionBackground(lightblue);
        table.setGridColor(linecolor);
        table.setShowGrid(true);
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 13));
        header.setBackground(lightblue);
        header.setForeground(navy);
        header.setPreferredSize(new Dimension(1030, 40));

        //COLUMN WIDTHS
        table.getColumnModel().getColumn(0).setPreferredWidth(90);   //Date
        table.getColumnModel().getColumn(1).setPreferredWidth(170);  //Name
        table.getColumnModel().getColumn(2).setPreferredWidth(130);  //Contact
        table.getColumnModel().getColumn(3).setPreferredWidth(200);  //Address
        table.getColumnModel().getColumn(4).setPreferredWidth(70);   //Refilled
        table.getColumnModel().getColumn(5).setPreferredWidth(70);   //Returned
        table.getColumnModel().getColumn(6).setPreferredWidth(100);  //Price

        //SHOW ALL TRANSACTIONS WHEN PAGE OPENS
        applyFilters();

        JScrollPane scroll = new JScrollPane(table);
        scroll.getVerticalScrollBar().setUnitIncrement(80);
        tablepanel.add(scroll, BorderLayout.CENTER);

        //--------------------EVENT LISTENERS--------------------

        tfsearch.addKeyListener(this);
        sortbox.addActionListener(this);
        btfilter.addActionListener(this);

        //CENTER CONTENT WITHOUT CHANGING ADMIN FRAME
        JPanel centerpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        centerpanel.setBackground(Color.WHITE);
        centerpanel.setPreferredSize(new Dimension(1100, 785));
        centerpanel.add(mainpanel);

        return centerpanel;
    }

    //--------------------BUTTON ACTIONS--------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortbox) {
            applySorting();
        } else if (e.getSource() == btfilter) {
            applyFilters();
        }
    }

    //--------------------SEARCH KEY EVENTS--------------------

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tfsearch) {
            applyFilters();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //--------------------APPLY FILTERS--------------------

    public void applyFilters() {

        String searchText = tfsearch.getText().trim().toLowerCase();
        String fromDate = tffrom.getSelectedItem().toString();
        String toDate = tfto.getSelectedItem().toString();

        if (fromDate.equals("Any date")) {
            fromDate = "";
        }
        if (toDate.equals("Any date")) {
            toDate = "";
        }

        if (!fromDate.isEmpty() && !toDate.isEmpty()
                && fromDate.compareTo(toDate) > 0) {
            JOptionPane.showMessageDialog(null, "The From date must be before the To date.");
            return;
        }

        //CLEAR ONLY THE VISIBLE TABLE, NOT OUR SAVED RECORDS
        model.setRowCount(0);

        //CHECK EACH TRANSACTION USING A FOR LOOP
        for (int i = 0; i < records.size(); i++) {
            Object[] record = records.get(i);

            String date = record[0].toString();
            String name = record[1].toString().toLowerCase();
            String contact = record[2].toString().toLowerCase();
            String address = record[3].toString().toLowerCase();

            //SEARCH BY NAME, CONTACT OR ADDRESS
            boolean matchesSearch = name.contains(searchText)
                    || contact.contains(searchText)
                    || address.contains(searchText);

            //CHECK FROM AND TO DATES
            boolean matchesFrom = fromDate.isEmpty() || date.compareTo(fromDate) >= 0;
            boolean matchesTo = toDate.isEmpty() || date.compareTo(toDate) <= 0;

            if (matchesSearch && matchesFrom && matchesTo) {
                model.addRow(record);
            }
        }

        applySorting();
    }

    //--------------------BUBBLE SORT--------------------

    public void applySorting() {

        int rows = model.getRowCount();

        //NEWEST FIRST = 0, OLDEST FIRST = 1
        boolean newestFirst = sortbox.getSelectedIndex() == 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {

                //GET THE TWO DATES TO COMPARE
                String date1 = model.getValueAt(j, 0).toString();
                String date2 = model.getValueAt(j + 1, 0).toString();

                int comparison = date1.compareTo(date2);

                //SWAP ROWS WHEN THEY ARE IN THE WRONG ORDER
                if ((newestFirst && comparison < 0)
                        || (!newestFirst && comparison > 0)) {
                    model.moveRow(j, j, j + 1);
                }
            }
        }
    }
}
