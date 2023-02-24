package entity;

import java.util.Arrays;

public class StaffManagement {
    private Staff staff;
    private StaffManagementDetail[] staffManagementDetails;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffManagementDetail[] getStaffManagementDetails() {
        return staffManagementDetails;
    }

    public void setStaffManagementDetails(StaffManagementDetail[] staffManagementDetails) {
        this.staffManagementDetails = staffManagementDetails;
    }

    public StaffManagement(Staff staff, StaffManagementDetail[] staffManagementDetails) {
        this.staff = staff;
        this.staffManagementDetails = staffManagementDetails;
    }

    @Override
    public String toString() {
        return "StaffManagement{" +
                "staff=" + staff +
                ", staffManagementDetails=" + Arrays.toString(staffManagementDetails) +
                '}';
    }
    public void productType(){
        Product product;
        String type;
        for (int i = 0; i < staffManagementDetails.length; i++) {
            product = new Product();
            type = product.getProductType().value;

        }
    }
}
