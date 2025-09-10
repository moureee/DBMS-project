package services;

import dao.TenantDAO;
import models.Tenant;

import javax.swing.*;

public class EntityController {

    // Show entity form (Tenant, Lease, Unit)
    public static void showEntityForm(String entityType) {
        JFrame entityFrame = new JFrame(entityType + " Management");
        entityFrame.setSize(400, 400);
        entityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel entityPanel = new JPanel();
        entityFrame.add(entityPanel);

        switch (entityType.toLowerCase()) {
            case "tenant":
                placeTenantComponents(entityPanel);
                break;
            case "lease":
                placeLeaseComponents(entityPanel);
                break;
            case "unit":
                placeUnitComponents(entityPanel);
                break;
            default:
                System.out.println("Entity type not recognized.");
                return;
        }

        entityFrame.setVisible(true);
    }

    // Method to add Tenant components
    private static void placeTenantComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel tenantLabel = new JLabel("Tenant Name:");
        tenantLabel.setBounds(10, 20, 100, 25);
        panel.add(tenantLabel);

        JTextField tenantNameField = new JTextField(20);
        tenantNameField.setBounds(120, 20, 165, 25);
        panel.add(tenantNameField);

        JLabel tenantContactLabel = new JLabel("Contact Number:");
        tenantContactLabel.setBounds(10, 50, 100, 25);
        panel.add(tenantContactLabel);

        JTextField tenantContactField = new JTextField(20);
        tenantContactField.setBounds(120, 50, 165, 25);
        panel.add(tenantContactField);

        JButton addTenantButton = new JButton("Add Tenant");
        addTenantButton.setBounds(10, 100, 150, 25);
        panel.add(addTenantButton);

        
        addTenantButton.addActionListener(e -> {
            String name = tenantNameField.getText();
            String contactNumber = tenantContactField.getText();

            Tenant tenant = new Tenant(name, contactNumber, "", "", "", "", "", null, null, null);
            TenantDAO tenantDAO = new TenantDAO();
            tenantDAO.addTenant(tenant);
            JOptionPane.showMessageDialog(null, "Tenant added successfully!");
        });
    }

    // Placeholder methods for Lease and Unit components
    private static void placeLeaseComponents(JPanel panel) {
        // Similar approach as placeTenantComponents
    }

    private static void placeUnitComponents(JPanel panel) {
        // Similar approach as placeTenantComponents
    }
}
