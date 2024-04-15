package be.rubijn.vendingmachine;

public enum EuroCoin {
    TWO_EURO (200),
    ONE_EURO (100),
    FIFTY_CENTS (50);

    private final int value;

    EuroCoin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
