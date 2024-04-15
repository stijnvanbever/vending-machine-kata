package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class Display {
    Stack<String> text;

    public String readText(int amount) {
        return String.format("INSERT COIN.\nAMOUNT: %.2f", amount / 100f);
    }

    public String readAmount(int amount){

    }
}
