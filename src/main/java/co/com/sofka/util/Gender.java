package co.com.sofka.util;

public enum Gender {
    ADMIN("Admin"),
    FEMALE("Female"),
    OTHER("Other");

    private final String value;

    public String getValue() {
        return value;
    }

    Gender(String value) {
        this.value = value;
    }
}
