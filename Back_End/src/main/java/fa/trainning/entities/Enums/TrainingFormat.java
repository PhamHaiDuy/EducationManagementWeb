package fa.trainning.entities.Enums;

public enum TrainingFormat {
    ONLINE("ONLINE"),OFFLINE("OFFLINE");
    private final String text;
    private TrainingFormat(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
