package dao;

import models.Unit;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UnitDAO {

    public void addUnit(Unit unit) {
        String query = "INSERT INTO unit (unit_name, unit_type, unit_size, rent_amount, tenant_id, image_path) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, unit.getUnitName());
            stmt.setString(2, unit.getUnitType());
            stmt.setInt(3, unit.getUnitSize());
            stmt.setBigDecimal(4, unit.getRentAmount());
            stmt.setInt(5, unit.getTenantId());
            stmt.setString(6, unit.getImagePath());

            stmt.executeUpdate();
            System.out.println("Unit added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();  // Better to use logging or throw an exception
        }
    }

    public Unit getUnit(int unitId) {
        String query = "SELECT * FROM unit WHERE unit_id = ?";
        Unit unit = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, unitId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                unit = new Unit(
                    rs.getString("unit_name"),
                    rs.getString("unit_type"),
                    rs.getInt("unit_size"),
                    rs.getBigDecimal("rent_amount"),
                    rs.getInt("tenant_id"),
                    rs.getString("image_path")
                );
                unit.setUnitId(rs.getInt("unit_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unit;
    }

    public void updateUnit(Unit unit) {
        String query = "UPDATE unit SET unit_name = ?, unit_type = ?, unit_size = ?, rent_amount = ?, tenant_id = ?, image_path = ? WHERE unit_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, unit.getUnitName());
            stmt.setString(2, unit.getUnitType());
            stmt.setInt(3, unit.getUnitSize());
            stmt.setBigDecimal(4, unit.getRentAmount());
            stmt.setInt(5, unit.getTenantId());
            stmt.setString(6, unit.getImagePath());
            stmt.setInt(7, unit.getUnitId());

            stmt.executeUpdate();
            System.out.println("Unit updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUnit(int unitId) {
        String query = "DELETE FROM unit WHERE unit_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, unitId);
            stmt.executeUpdate();
            System.out.println("Unit deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Unit> searchUnit(String unitName) {
        List<Unit> unitList = new ArrayList<>();
        String query = "SELECT * FROM unit WHERE unit_name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + unitName + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Unit unit = new Unit(
                    rs.getString("unit_name"),
                    rs.getString("unit_type"),
                    rs.getInt("unit_size"),
                    rs.getBigDecimal("rent_amount"),
                    rs.getInt("tenant_id"),
                    rs.getString("image_path")
                );
                unit.setUnitId(rs.getInt("unit_id"));
                unitList.add(unit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unitList;
    }
}
