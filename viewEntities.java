package services;

import dao.TenantDAO;
import models.Tenant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class viewEntities {

    public static void showTenantList() {
        JFrame frame = new JFrame("Tenant List");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        TenantDAO tenantDAO = new TenantDAO();
        List<Tenant> tenants = tenantDAO.getAllTenants();

        // Column names for the table
        String[] columns = {"Name", "Contact", "Email", "Address", "Rent Amount"};

        // Prepare data for the table
        Object[][] data = new Object[tenants.size()][5];
        for (int i = 0; i < tenants.size(); i++) {
            Tenant tenant = tenants.get(i);
            data[i][0] = tenant.getName();
            data[i][1] = tenant.getContactNumber();
            data[i][2] = tenant.getEmail();
            data[i][3] = tenant.getAddress();
            data[i][4] = tenant.getRentAmount();
        }

        JTable tenantTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(tenantTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
