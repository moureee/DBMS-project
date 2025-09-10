package test;

import dao.UnitDAO;
import models.Unit;
import java.math.BigDecimal;

public class TestUnitDAO {

    public static void main(String[] args) {
        // Create a new UnitDAO object to test the method
        UnitDAO unitDAO = new UnitDAO();
        
        // Step 1: Test Add Unit (Create)
        Unit newUnit = new Unit("Apartment 104", "3BHK", 1500, new BigDecimal("1500"), 1, "unit_4.jpeg");
        unitDAO.addUnit(newUnit);  // Add the new unit to the database
        
        // Step 2: Test Get Unit (Read)
        Unit retrievedUnit = unitDAO.getUnit(1);  // Assuming unitId = 1
        if (retrievedUnit != null) {
            System.out.println("Unit Name: " + retrievedUnit.getUnitName());
        } else {
            System.out.println("No unit found with the given ID.");
        }
        
        // Step 3: Test Update Unit (Update)
        newUnit.setUnitName("Updated Apartment 104");
        newUnit.setUnitSize(1600);
        unitDAO.updateUnit(newUnit);  // Update the unit in the database
        
        // Step 4: Test Delete Unit (Delete)
        unitDAO.deleteUnit(1);  // Delete the unit with unitId = 1
    }
}
