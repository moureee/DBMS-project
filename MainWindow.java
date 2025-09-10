package services;

import dao.LeaseDAO;
import dao.TenantDAO;
import dao.UnitDAO;
import models.Lease;
import models.Tenant;
import models.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow {

    public void initialize() {
        JFrame frame = new JFrame("Tenant Management System - TenMan");
        frame.setSize(600, 700);  // Increased size to fit all buttons
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);  // Use null layout for custom positioning

        // Add image as the background
        ImageIcon backgroundImage = new ImageIcon("icons for tenman/front page.jpeg");  // Ensure this path is correct
        Image image = backgroundImage.getImage();
        Image scaledImage = image.getScaledInstance(600, 700, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, 600, 700);
        panel.add(backgroundLabel);

        placeComponents(panel);  // Add buttons on top of the image

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Button configuration (size and position adjusted)
        JButton addTenantButton = new JButton("Add Tenant");
        addTenantButton.setBounds(200, 50, 200, 50);  // Big button size
        panel.add(addTenantButton);
        addTenantButton.addActionListener(e -> showEntityForm("tenant"));

        JButton addLeaseButton = new JButton("Add Lease");
        addLeaseButton.setBounds(200, 120, 200, 50);
        panel.add(addLeaseButton);
        addLeaseButton.addActionListener(e -> showEntityForm("lease"));

        JButton addUnitButton = new JButton("Add Unit");
        addUnitButton.setBounds(200, 190, 200, 50);
        panel.add(addUnitButton);
        addUnitButton.addActionListener(e -> showEntityForm("unit"));

        // View buttons for tenants, leases, and units
        JButton viewTenantsButton = new JButton("View Tenants");
        viewTenantsButton.setBounds(200, 260, 200, 50);
        panel.add(viewTenantsButton);
        viewTenantsButton.addActionListener(e -> viewEntities("tenant"));

        JButton viewLeasesButton = new JButton("View Leases");
        viewLeasesButton.setBounds(200, 330, 200, 50);
        panel.add(viewLeasesButton);
        viewLeasesButton.addActionListener(e -> viewEntities("lease"));

        JButton viewUnitsButton = new JButton("View Units");
        viewUnitsButton.setBounds(200, 400, 200, 50);
        panel.add(viewUnitsButton);
        viewUnitsButton.addActionListener(e -> viewEntities("unit"));
    }

    private static void showEntityForm(String entityType) {
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

    // Method to view entities in a JTable
    private static void viewEntities(String entityType) {
        JFrame entityFrame = new JFrame(entityType + " List");
        entityFrame.setSize(600, 400);
        entityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel entityPanel = new JPanel();
        entityFrame.add(entityPanel);

        String[] columns = {};
        Object[][] data = {};

        // Fetch data based on entity type and fill table data
        switch (entityType.toLowerCase()) {
            case "tenant":
                columns = new String[] {"Tenant ID", "Name", "Contact Number", "Email", "Address", "Rent Amount"};
                data = fetchTenantData();
                break;
            case "lease":
                columns = new String[] {"Lease ID", "Tenant ID", "Unit ID", "Start Date", "End Date", "Rent Amount"};
                data = fetchLeaseData();
                break;
            case "unit":
                columns = new String[] {"Unit ID", "Unit Name", "Unit Type", "Size", "Rent Amount", "Tenant ID"};
                data = fetchUnitData();
                break;
            default:
                System.out.println("Entity type not recognized.");
                return;
        }

        // Create JTable with dynamic data
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        entityPanel.setLayout(new BorderLayout());
        entityPanel.add(scrollPane, BorderLayout.CENTER);

        entityFrame.setVisible(true);
    }

    // Fetch all tenants from the database
    private static Object[][] fetchTenantData() {
        TenantDAO tenantDAO = new TenantDAO();
        List<Tenant> tenants = tenantDAO.getAllTenants();
        Object[][] data = new Object[tenants.size()][6]; // 6 columns for Tenant data
        for (int i = 0; i < tenants.size(); i++) {
            Tenant tenant = tenants.get(i);
            data[i][0] = tenant.getTenantId();
            data[i][1] = tenant.getName();
            data[i][2] = tenant.getContactNumber();
            data[i][3] = tenant.getEmail();
            data[i][4] = tenant.getAddress();
            data[i][5] = tenant.getRentAmount();
        }
        return data;
    }

    // Fetch all leases from the database
    private static Object[][] fetchLeaseData() {
        LeaseDAO leaseDAO = new LeaseDAO();
        List<Lease> leases = leaseDAO.getAllLeases();
        Object[][] data = new Object[leases.size()][6]; // 6 columns for Lease data
        for (int i = 0; i < leases.size(); i++) {
            Lease lease = leases.get(i);
            data[i][0] = lease.getLeaseId();
            data[i][1] = lease.getTenantId();
            data[i][2] = lease.getUnitId();
            data[i][3] = lease.getStartDate();
            data[i][4] = lease.getEndDate();
            data[i][5] = lease.getRentAmount();
        }
        return data;
    }

    // Fetch all units from the database
    private static Object[][] fetchUnitData() {
        UnitDAO unitDAO = new UnitDAO();
        List<Unit> units = unitDAO.getAllUnits();
        Object[][] data = new Object[units.size()][6]; // 6 columns for Unit data
        for (int i = 0; i < units.size(); i++) {
            Unit unit = units.get(i);
            data[i][0] = unit.getUnitId();
            data[i][1] = unit.getUnitName();
            data[i][2] = unit.getUnitType();
            data[i][3] = unit.getUnitSize();
            data[i][4] = unit.getRentAmount();
            data[i][5] = unit.getTenantId();
        }
        return data;
    }
}
