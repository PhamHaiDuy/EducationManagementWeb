package fa.trainning.entities.Enums;

public enum SyllabusStatus {
    ACTIVE("ACTIVE"),DRAFT("DRAFT"),INACTIVE("INACTIVE");
    private final String text;
    private SyllabusStatus(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
