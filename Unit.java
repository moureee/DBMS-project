package models;

import java.math.BigDecimal;

public class Unit {
    private int unitId;   // Auto-incremented by MySQL
    private String unitName;
    private String unitType;
    private int unitSize;
    private BigDecimal rentAmount;
    private int tenantId;
    private String imagePath;

    // Constructor (without unitId, it will be auto-incremented by the database)
    public Unit(String unitName, String unitType, int unitSize, BigDecimal rentAmount, int tenantId, String imagePath) {
        this.unitId = 0;  // unitId will be auto-incremented by the database
        this.unitName = unitName;
        this.unitType = unitType;
        this.unitSize = unitSize;
        this.rentAmount = rentAmount;
        this.tenantId = tenantId;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
