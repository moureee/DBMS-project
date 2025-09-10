package models;

import java.math.BigDecimal;
import java.util.Date;

public class Tenant {
    private int tenantId;  // Auto-incremented by MySQL
    private String name;
    private String contactNumber;
    private String email;
    private String address;
    private String nationalId;
    private String emergencyContact;
    private String leaseType;
    private Date moveInDate;
    private Date moveOutDate;
    private BigDecimal rentAmount;

    // Constructor (without tenantId as it is auto-incremented)
    public Tenant(String name, String contactNumber, String email, String address, String nationalId, 
                  String emergencyContact, String leaseType, Date moveInDate, Date moveOutDate, BigDecimal rentAmount) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.nationalId = nationalId;
        this.emergencyContact = emergencyContact;
        this.leaseType = leaseType;
        this.moveInDate = moveInDate;
        this.moveOutDate = moveOutDate;
        this.rentAmount = rentAmount;
    }

    // Getters and Setters for each property
    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }
}
