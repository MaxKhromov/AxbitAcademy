package hw4.fileReader.domain;

public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    public final String direction;

    SortDirection(String direction) {
        this.direction = direction;
    }
}
