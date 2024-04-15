package be.rubijn.vendingmachine;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static be.rubijn.vendingmachine.EuroCoin.*;

@Component
public class EuroDeterminer {
    Map<Coin, EuroCoin> euroMap = Map.of(
            new Coin(25.75, 8.5), TWO_EURO,
            new Coin(23.25, 7.5), ONE_EURO,
            new Coin(24.25, 7.8), FIFTY_CENTS
    );

    public Optional<EuroCoin> recognise(Coin coin) {
        return Optional.ofNullable(euroMap.get(coin));
    }
}
