package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

@Component
public class VendingMachine {
    private final EuroDeterminer euroDeterminer;
    private final Display display;
    int amount = 0;
    Collection<Coin> returnTray = new LinkedList<>();
    Collection<Product> itemDispencer = new LinkedList<>();

    public VendingMachine(EuroDeterminer euroDeterminer, Display display) {
        this.euroDeterminer = euroDeterminer;
        this.display = display;
    }

    public String showDisplay() {
        return display.read(amount);
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

        display.addText("THANK YOU");
        amount -= product.price;
        itemDispencer.add(product);
    }

    public Collection<Product> getItemsFromDispenser() {
        return Collections.unmodifiableCollection(itemDispencer);
    }
}
