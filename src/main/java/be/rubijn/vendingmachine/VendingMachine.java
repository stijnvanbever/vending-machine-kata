package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

@Component
public class VendingMachine {
    private final EuroDeterminer euroDeterminer;
    int amount = 0;
    Collection<Coin> returnTray = new LinkedList<>();
    Collection<Product> itemDispencer = new LinkedList<>();
    String display = "INSERT COIN";

    public VendingMachine(EuroDeterminer euroDeterminer) {
        this.euroDeterminer = euroDeterminer;
    }

    public String showDisplay() {
        return display;

        if (amount == 0) {
            return "INSERT COIN";
        }

        return String.format("AMOUNT: %.2f", amount / 100f);
    }

    public void accept(Coin coin) {
        euroDeterminer.recognise(coin).ifPresentOrElse(
                euroCoin -> amount += euroCoin.getValue(),
                () -> returnTray.add(coin)
        );
    }

    public Collection<Coin> getReturnTray() {
        return Collections.unmodifiableCollection(returnTray);
    }

    public String showInitMessage() {
        return "welkom in EUROpa, blijf hier tot ik doodga";
    }

    public void selectProduct(Product product) {
        if (product.price > amount){
            return;
        }

        display = "THANK YOU";
        amount -= product.price;
        itemDispencer.add(product);
    }

    public Collection<Product> getItemsFromDispenser() {
        return Collections.unmodifiableCollection(itemDispencer);
    }
}
