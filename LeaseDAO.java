package dao;

import models.Lease;
import dao.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseDAO {

    // Method to add a new lease
    public void addLease(Lease lease) {
        // SQL query to insert a new lease (we don't need to include lease_id, it's auto-increment)
        String query = "INSERT INTO lease (tenant_id, unit_id, start_date, end_date, rent_amount, payment_status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Setting parameters for the PreparedStatement
            stmt.setInt(1, lease.getTenantId());
            stmt.setInt(2, lease.getUnitId());
           stmt.setDate(3, java.sql.Date.valueOf(lease.getStartDate()));  // Adjust this
           stmt.setDate(4, java.sql.Date.valueOf(lease.getEndDate()));    // Adjust this

            stmt.setDouble(5, lease.getRentAmount());
            stmt.setString(6, lease.getPaymentStatus());

            // Execute the insert query
            stmt.executeUpdate(); 

            // Retrieve the generated lease_id (since it's auto-incremented)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    lease.setLeaseId(rs.getInt(1));  // Set the auto-generated lease_id
                }
            }

            System.out.println("Lease Added! Lease ID: " + lease.getLeaseId());

        } catch (SQLException e) {
            System.out.println("Error in adding lease: " + e.getMessage());
        }
    }

    // Method to get all leases
    public List<Lease> getAllLeases() {
        List<Lease> leases = new ArrayList<>();
        String query = "SELECT * FROM lease";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Loop through the result set and add leases to the list
            while (rs.next()) {
                Lease lease = new Lease(
                    rs.getInt("lease_id"),
                    rs.getInt("tenant_id"),
                    rs.getInt("unit_id"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getDouble("rent_amount"),
                    rs.getString("payment_status")
                );
                leases.add(lease);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching leases: " + e.getMessage());
        }
        return leases;
    }

    // Method to delete a lease by leaseId
    public void deleteLease(int leaseId) {
        String query = "DELETE FROM lease WHERE lease_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, leaseId);
            int rowsAffected = stmt.executeUpdate();  // Execute the delete query

            // Check if a lease was deleted
            if (rowsAffected > 0) {
                System.out.println("Lease Deleted! Lease ID: " + leaseId);
            } else {
                System.out.println("No Lease found with Lease ID: " + leaseId);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting lease: " + e.getMessage());
        }
    }
}
