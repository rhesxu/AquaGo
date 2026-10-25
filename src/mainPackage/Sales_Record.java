package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Sales_Record extends Admin {

    //BUSINESS SUMMARY
    @Override
    public JPanel getPanel() {
        //--------------------Summary Content--------------------
        JPanel summaryContent = new JPanel(null);
        summaryContent.setPreferredSize(new Dimension(1069, 760));
        summaryContent.setBackground(Color.WHITE);

        Color navy = Color.decode("#174678");
        Color blue = Color.decode("#3096DE");
        Color lightblue = Color.decode("#EAF4FC");
        Color linecolor = Color.decode("#D5E7F7");
        Color muted = Color.decode("#7694AE");

        //--------------------Title--------------------
        JLabel title = new JLabel("Sales Record");
        title.setBounds(35, 47, 500, 48);
        title.setFont(new Font("Arial", Font.BOLD, 33));
        title.setForeground(navy);
        summaryContent.add(title);

        JLabel subtitle = new JLabel(
                "Overview of profits and reusable containers"
        );
        subtitle.setBounds(37, 96, 530, 25);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(muted);
        summaryContent.add(subtitle);

        //--------------------Profit Today Card--------------------
        JPanel todayCard = new JPanel(null);
        todayCard.setBounds(35, 148, 526, 142);
        todayCard.setBackground(lightblue);
        summaryContent.add(todayCard);

        JPanel todayAccent = new JPanel();
        todayAccent.setBounds(0, 0, 6, 142);
        todayAccent.setBackground(blue);
        todayCard.add(todayAccent);

        JLabel todayLabel = new JLabel("Profit Today");
        todayLabel.setBounds(26, 20, 260, 30);
        todayLabel.setForeground(navy);
        todayLabel.setFont(new Font("Arial", Font.BOLD, 17));
        todayCard.add(todayLabel);

        JLabel todayAmount = new JLabel("₱0.00");
        todayAmount.setBounds(26, 57, 460, 61);
        todayAmount.setForeground(navy);
        todayAmount.setFont(new Font("Arial", Font.BOLD, 38));
        todayCard.add(todayAmount);

        //--------------------Profit This Month Card--------------------
        JPanel monthCard = new JPanel(null);
        monthCard.setBounds(579, 148, 490, 142);
        monthCard.setBackground(lightblue);
        summaryContent.add(monthCard);

        JPanel monthAccent = new JPanel();
        monthAccent.setBounds(0, 0, 6, 142);
        monthAccent.setBackground(Color.decode("#70BBF0"));
        monthCard.add(monthAccent);

        JLabel monthLabel = new JLabel("Profit This Month");
        monthLabel.setBounds(26, 20, 300, 30);
        monthLabel.setForeground(navy);
        monthLabel.setFont(new Font("Arial", Font.BOLD, 17));
        monthCard.add(monthLabel);

        JLabel monthAmount = new JLabel("₱0.00");
        monthAmount.setBounds(26, 57, 440, 61);
        monthAmount.setForeground(navy);
        monthAmount.setFont(new Font("Arial", Font.BOLD, 38));
        monthCard.add(monthAmount);

        //--------------------Reusable Containers--------------------
        JPanel reusableCard = new JPanel(null);
        reusableCard.setBounds(35, 307, 1034, 105);
        reusableCard.setBackground(Color.decode("#F0F7FD"));
        reusableCard.setBorder(
                BorderFactory.createLineBorder(linecolor, 1)
        );
        summaryContent.add(reusableCard);

        JLabel reusableTitle = new JLabel("Reusable Containers");
        reusableTitle.setBounds(24, 20, 370, 31);
        reusableTitle.setFont(new Font("Arial", Font.BOLD, 21));
        reusableTitle.setForeground(navy);
        reusableCard.add(reusableTitle);

        JLabel reusableNote = new JLabel(
                "Containers currently available for reuse"
        );
        reusableNote.setBounds(25, 55, 440, 24);
        reusableNote.setFont(new Font("Arial", Font.PLAIN, 14));
        reusableNote.setForeground(muted);
        reusableCard.add(reusableNote);

        JLabel containerAmount = new JLabel("0");
        containerAmount.setBounds(750, 18, 250, 65);
        containerAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        containerAmount.setFont(new Font("Arial", Font.BOLD, 43));
        containerAmount.setForeground(blue);
        reusableCard.add(containerAmount);

        //--------------------Profit Records Header--------------------
        JLabel recordsTitle = new JLabel("Profit Records");
        recordsTitle.setBounds(35, 436, 340, 37);
        recordsTitle.setFont(new Font("Arial", Font.BOLD, 23));
        recordsTitle.setForeground(navy);
        summaryContent.add(recordsTitle);

        JLabel recordsNote = new JLabel("Your daily profit history");
        recordsNote.setBounds(36, 469, 450, 24);
        recordsNote.setFont(new Font("Arial", Font.PLAIN, 14));
        recordsNote.setForeground(muted);
        summaryContent.add(recordsNote);

        //--------------------Sorting--------------------
        JComboBox<String> sorting = new JComboBox<>(
                new String[]{
                    "Newest first",
                    "Oldest first",
                    "Highest profit",
                    "Lowest profit"
                }
        );

        sorting.setBounds(804, 443, 265, 42);
        sorting.setFont(new Font("Arial", Font.BOLD, 15));
        sorting.setForeground(navy);
        sorting.setBackground(lightblue);
        sorting.setBorder(
                BorderFactory.createLineBorder(linecolor, 1)
        );
        sorting.setFocusable(false);
        summaryContent.add(sorting);

        //--------------------Records Table--------------------
        JPanel recordCard = new JPanel(new BorderLayout());
        recordCard.setBounds(35, 510, 1034, 215);
        recordCard.setBackground(Color.WHITE);
        recordCard.setBorder(
                BorderFactory.createLineBorder(linecolor, 1)
        );
        summaryContent.add(recordCard);

        JPanel tableHeader = new JPanel(null);
        tableHeader.setPreferredSize(new Dimension(1032, 44));
        tableHeader.setBackground(lightblue);
        recordCard.add(tableHeader, BorderLayout.NORTH);

        JLabel dateHeader = new JLabel("DATE");
        dateHeader.setBounds(20, 9, 390, 26);
        dateHeader.setForeground(navy);
        dateHeader.setFont(new Font("Arial", Font.BOLD, 13));
        tableHeader.add(dateHeader);

        JLabel countHeader = new JLabel("TRANSACTIONS");
        countHeader.setBounds(500, 9, 185, 26);
        countHeader.setForeground(navy);
        countHeader.setFont(new Font("Arial", Font.BOLD, 13));
        tableHeader.add(countHeader);

        JLabel profitHeader = new JLabel("NET PROFIT");
        profitHeader.setBounds(820, 9, 190, 26);
        profitHeader.setForeground(navy);
        profitHeader.setFont(new Font("Arial", Font.BOLD, 13));
        tableHeader.add(profitHeader);

        JPanel recordsList = new JPanel();
        recordsList.setLayout(new BoxLayout(recordsList, BoxLayout.Y_AXIS));
        recordsList.setBackground(Color.WHITE);

        
        //--------------------LOAD SAVED TRANSACTIONS--------------------
        ArrayList<Object[]> transactions = AquagoLoadSave.loadTransactions();
        HashMap<String, double[]> dailyRecords = new HashMap<>();

        double todayProfit = 0;
        double monthProfit = 0;
        int totalReturned = 0;

        String today = java.time.LocalDate.now().toString();
        String month = java.time.YearMonth.now().toString();

        for (Object[] record : transactions) {

            String date = record[0].toString();
            double price = Double.parseDouble(record[6].toString()
                    .replace("₱", "").replace(",", "").trim());
            int returned = Integer.parseInt(record[5].toString());

            //TODAY'S SALES
            if (date.equals(today)) {
                todayProfit += price;
            }

            //MONTHLY SALES
            if (date.startsWith(month)) {
                monthProfit += price;
            }

            totalReturned += returned;

            //GROUP TRANSACTIONS BY DATE
            double[] daily = dailyRecords.get(date);

            if (daily == null) {
                daily = new double[]{0, 0};
                dailyRecords.put(date, daily);
            }

            daily[0]++;
            daily[1] += price;
        }

        //DISPLAY SUMMARY
        todayAmount.setText(String.format("₱%.2f", todayProfit));
        monthAmount.setText(String.format("₱%.2f", monthProfit));
        containerAmount.setText(String.valueOf(totalReturned));
        
        //--------------------DISPLAY AND SORT RECORD PANELS--------------------
        Runnable refreshRecords = () -> {

            recordsList.removeAll();

            ArrayList<Map.Entry<String, double[]>> dailyList =
                    new ArrayList<>(dailyRecords.entrySet());

            String selectedSort = sorting.getSelectedItem().toString();

            dailyList.sort((a, b) -> {
                if (selectedSort.equals("Newest first")) {
                    return b.getKey().compareTo(a.getKey());
                }

                if (selectedSort.equals("Oldest first")) {
                    return a.getKey().compareTo(b.getKey());
                }

                if (selectedSort.equals("Highest profit")) {
                    return Double.compare(b.getValue()[1], a.getValue()[1]);
                }

                return Double.compare(a.getValue()[1], b.getValue()[1]);
            });

            if (dailyList.isEmpty()) {

                JLabel empty = new JLabel("No sales records yet.");
                empty.setAlignmentX(Component.CENTER_ALIGNMENT);
                empty.setForeground(muted);
                empty.setFont(new Font("Arial", Font.PLAIN, 15));

                recordsList.add(Box.createVerticalStrut(50));
                recordsList.add(empty);

            } else {

                for (Map.Entry<String, double[]> entry : dailyList) {

                    JPanel row = new JPanel(null);
                    row.setPreferredSize(new Dimension(1032, 48));
                    row.setMinimumSize(new Dimension(1032, 48));
                    row.setMaximumSize(new Dimension(1032, 48));
                    row.setBackground(Color.WHITE);
                    row.setBorder(BorderFactory.createMatteBorder(
                            0, 0, 1, 0, linecolor));

                    //DATE
                    JLabel dateLabel = new JLabel(entry.getKey());
                    dateLabel.setBounds(20, 8, 390, 30);
                    dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                    dateLabel.setForeground(navy);
                    row.add(dateLabel);

                    //TRANSACTION COUNT
                    JLabel countLabel = new JLabel(
                            String.valueOf((int) entry.getValue()[0]));
                    countLabel.setBounds(500, 8, 185, 30);
                    countLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                    countLabel.setForeground(navy);
                    row.add(countLabel);

                    //COMBINED SALES
                    JLabel profitLabel = new JLabel(
                            String.format("₱%.2f", entry.getValue()[1]));
                    profitLabel.setBounds(820, 8, 190, 30);
                    profitLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    profitLabel.setForeground(blue);
                    row.add(profitLabel);

                    recordsList.add(row);
                }
            }

            recordsList.revalidate();
            recordsList.repaint();
        };

        refreshRecords.run();
        sorting.addActionListener(e -> refreshRecords.run());


        JScrollPane recordsScroll = new JScrollPane(recordsList);
        recordsScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );
        recordsScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        recordsScroll.getVerticalScrollBar().setUnitIncrement(16);
        recordCard.add(recordsScroll, BorderLayout.CENTER);

        //--------------------Main Content--------------------
        JPanel mainContent = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 30, 30)
        );
        mainContent.setBackground(Color.WHITE);
        mainContent.add(summaryContent);

        JScrollPane summaryScroll = new JScrollPane(mainContent);
        summaryScroll.setBorder(null);
        summaryScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        summaryScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        JPanel page = new JPanel(new BorderLayout());
        page.add(summaryScroll, BorderLayout.CENTER);
        return page;


    }
}
