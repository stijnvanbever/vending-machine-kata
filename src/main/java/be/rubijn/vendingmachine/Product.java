package be.rubijn.vendingmachine;

public enum Product {
    COLA (100);

    final int price;

    Product(int price) {
        this.price = price;
    }
}
