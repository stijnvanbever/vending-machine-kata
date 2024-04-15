package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class Display {
    private Stack<String> text = new Stack<>();

    public String read(int amount) {
        return String.format("%s\n%s", readText(), readAmount(amount));
    }

    public String readText(){
        if (text.empty()) {
            return "INSERT COIN";
        }

        return text.pop();
    }

    public String readAmount(int amount){
        return String.format("AMOUNT: %.2f", amount / 100f);
    }

    public void addText(String string) {
        text.push(string);
    }
}
