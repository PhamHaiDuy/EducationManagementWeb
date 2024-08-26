package fa.trainning.entities.Enums;

public enum StatusClass {
    PLANNING("PLANNING"),SCHEDULED("SCHEDULED"),OPENING("OPENING"),CLOSED("CLOSED");
    private final String text;
    private StatusClass(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
