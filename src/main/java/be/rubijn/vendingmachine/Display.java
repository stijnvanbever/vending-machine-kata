package be.rubijn.vendingmachine;

import java.util.Stack;

public class Display {
    Stack<String> text;

    public String read(int amount) {
        return String.format("INSERT COIN.\nAMOUNT: %.2f", amount / 100f);
    }
}
