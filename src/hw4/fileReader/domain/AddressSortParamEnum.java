package hw4.fileReader.domain;

public enum AddressSortParamEnum {
    HOUSE("house"),
    FLAT("flat");

    public final String sortParam;

    AddressSortParamEnum(String sortParam) {
        this.sortParam = sortParam;
    }

}
