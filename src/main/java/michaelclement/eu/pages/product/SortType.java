package michaelclement.eu.pages.product;

public enum SortType {
    PRICE ("Price"),
    NAME ("Name");

    private final String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
