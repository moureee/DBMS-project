package services;

import dao.LeaseDAO;
import models.Lease;

public class TestTenantDAO {
    public static void main(String[] args) {
        LeaseDAO leaseDAO = new LeaseDAO();

        // Add a new lease
        Lease lease = new Lease(0, 1, 101, "2023-01-01", "2024-01-01", 1200.50, "Paid");
        leaseDAO.addLease(lease);
        System.out.println("Lease Added! Lease ID: " + lease.getLeaseId());

        // Fetch and print all leases
        leaseDAO.getAllLeases().forEach(l -> {
            System.out.println("Lease ID: " + l.getLeaseId() + ", Tenant ID: " + l.getTenantId());
        });

        // Delete a lease by ID (use the leaseId from the added lease)
        leaseDAO.deleteLease(lease.getLeaseId());
    }
}
