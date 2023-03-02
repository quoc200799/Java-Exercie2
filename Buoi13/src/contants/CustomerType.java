package contants;

public enum CustomerType {
    CN("Cá nhân"),
    HC("Đại diện đơn vụ hành chính"),
    KD("Đại diện đơn vị kinh doanh");
    public String value;

    CustomerType(String value) {
        this.value = value;
    }
}
