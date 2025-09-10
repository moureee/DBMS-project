package dao;

import models.Tenant;
import java.sql.*;

public class TenantDAO {

    public void addTenant(Tenant tenant) {
        String query = "INSERT INTO tenant (name, contact_number, email, address, national_id, emergency_contact, lease_type, move_in_date, move_out_date, rent_amount) " +
                       "VALUES ('" + tenant.getName() + "', '" + tenant.getContactNumber() + "', '" + tenant.getEmail() + "', '" + tenant.getAddress() + "', '" +
                       tenant.getNationalId() + "', '" + tenant.getEmergencyContact() + "', '" + tenant.getLeaseType() + "', '" + new java.sql.Date(tenant.getMoveInDate().getTime()) + "', " +
                       (tenant.getMoveOutDate() != null ? "'" + new java.sql.Date(tenant.getMoveOutDate().getTime()) + "'" : "NULL") + ", " +
                       tenant.getRentAmount() + ")";

            try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            stmt.setString(1, tenant.getName());
            stmt.setString(2, tenant.getContactNumber());
            stmt.setString(3, tenant.getEmail());
            stmt.setString(4, tenant.getAddress());
            stmt.setString(5, tenant.getNationalId());
            stmt.setString(6, tenant.getEmergencyContact());
            stmt.setString(7, tenant.getLeaseType());

            // Handle move-in and move-out dates
            if (tenant.getMoveInDate() != null) {
                stmt.setDate(8, new java.sql.Date(tenant.getMoveInDate().getTime()));
            } else {
                stmt.setNull(8, Types.DATE);
            }

            if (tenant.getMoveOutDate() != null) {
                stmt.setDate(9, new java.sql.Date(tenant.getMoveOutDate().getTime()));
            } else {
                stmt.setNull(9, Types.DATE);
            }

            // Set rent amount (BigDecimal)
            stmt.setBigDecimal(10, tenant.getRentAmount());

            stmt.executeUpdate();  // Execute the query

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}