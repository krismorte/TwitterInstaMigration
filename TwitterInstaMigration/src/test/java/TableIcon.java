/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JPanel {

    public TableIcon() {
        Icon aboutIcon = new ImageIcon("if_JD-19_2246834.png");
        Icon addIcon = new ImageIcon("if_JD-14_2246840.png");
        Icon copyIcon = new ImageIcon("if_calendar_1814093 (1).png");

        String[] columnNames = {"Picture", "Description"};
        Object[][] data
                = {
                    {aboutIcon, "About"},
                    {addIcon, "Add"},
                    {copyIcon, "Copy"},};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableIcon());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
