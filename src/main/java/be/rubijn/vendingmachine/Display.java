package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class Display {
    Stack<String> text;

    public String read(int amount) {
        return String.format("%s\n%s", readText(), readAmount(amount));
    }

    public String readText(){
        return "INSERT COIN";
    }

    public String readAmount(int amount){
        return String.format("AMOUNT: %.2f", amount / 100f);
    }
}
