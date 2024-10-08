package fa.trainning.entities.Enums;

public enum UserStatus {
    ACTIVE("ACTIVE"),INACTIVE("INACTIVE");
    private final String text;
    private UserStatus(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
