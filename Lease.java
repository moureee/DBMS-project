package models;

public class Lease {
    private int leaseId;
    private int tenantId;
    private int unitId;
    private String startDate;
    private String endDate;
    private double rentAmount;
    private String paymentStatus;

    public Lease(int leaseId, int tenantId, int unitId, String startDate, String endDate, double rentAmount, String paymentStatus) {
        this.leaseId = leaseId;
        this.tenantId = tenantId;
        this.unitId = unitId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
    public int getLeaseId() { return leaseId; }
    public void setLeaseId(int leaseId) { this.leaseId = leaseId; }
    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }
    public int getUnitId() { return unitId; }
    public void setUnitId(int unitId) { this.unitId = unitId; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
