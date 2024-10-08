package fa.trainning.entities.Enums;

public enum SyllabusPublishStatus {
    ACTIVE("ACTIVE"),INACTIVE("INACTIVE"),DRAFTING("DRAFTING");
    private final String text;
    private SyllabusPublishStatus(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
