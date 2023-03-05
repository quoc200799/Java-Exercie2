package contants;

public enum CustomerType {
    CN("Cá nhân"),
    TT("Tập thể"),
    DN("Doanh nghiệp");
    public String value;

    CustomerType(String value) {
        this.value = value;
    }
}
