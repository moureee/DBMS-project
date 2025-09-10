package view;

import dao.UnitDAO;
import models.Unit;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class UnitFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Unit Management");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2)); // Use GridLayout for structured components

            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        JLabel unitNameLabel = new JLabel("Unit Name:");
        panel.add(unitNameLabel);

        JTextField unitNameText = new JTextField(20);
        panel.add(unitNameText);

        JLabel unitTypeLabel = new JLabel("Unit Type:");
        panel.add(unitTypeLabel);

        JTextField unitTypeText = new JTextField(20);
        panel.add(unitTypeText);

        JLabel unitSizeLabel = new JLabel("Unit Size (sq ft):");
        panel.add(unitSizeLabel);

        JTextField unitSizeText = new JTextField(20);
        panel.add(unitSizeText);

        JLabel rentAmountLabel = new JLabel("Rent Amount:");
        panel.add(rentAmountLabel);

        JTextField rentAmountText = new JTextField(20);
        panel.add(rentAmountText);

        JLabel tenantIdLabel = new JLabel("Tenant ID:");
        panel.add(tenantIdLabel);

        JTextField tenantIdText = new JTextField(20);
        panel.add(tenantIdText);

        JLabel imagePathLabel = new JLabel("Image Path:");
        panel.add(imagePathLabel);

        JTextField imagePathText = new JTextField(20);
        panel.add(imagePathText);

        // Button to add the unit to the database
        JButton addButton = new JButton("Add Unit");
        panel.add(addButton);

        // Add action listener for adding unit to the database
        addButton.addActionListener(e -> {
            String unitName = unitNameText.getText();
            String unitType = unitTypeText.getText();
            int unitSize = Integer.parseInt(unitSizeText.getText()); // Convert to int
            BigDecimal rentAmount = new BigDecimal(rentAmountText.getText()); // Convert to BigDecimal
            int tenantId = Integer.parseInt(tenantIdText.getText()); // Convert to int
            String imagePath = imagePathText.getText();

            // Create a new unit object
            Unit newUnit = new Unit(unitName, unitType, unitSize, rentAmount, tenantId, imagePath);

            // Create a UnitDAO object to insert the unit into the database
            UnitDAO unitDAO = new UnitDAO();
            unitDAO.addUnit(newUnit);  // Add the new unit to the database

            JOptionPane.showMessageDialog(null, "Unit added successfully!");
        });
    }
}
