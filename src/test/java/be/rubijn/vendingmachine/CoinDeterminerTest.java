package be.rubijn.vendingmachine;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static be.rubijn.vendingmachine.EuroCoin.*;
import static be.rubijn.vendingmachine.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CoinDeterminerTest {
    EuroDeterminer determiner = new EuroDeterminer();

    @Test
    void when1EuroIsInserted_then1EuroIsRecognised(){
        Optional<EuroCoin> euroCoin = determiner.recognise(ONE_EURO_COIN);

        assertThat(euroCoin).hasValue(ONE_EURO);
    }

    @Test
    void when50CentsIsInserted_then50CentsIsRecognised(){
        Optional<EuroCoin> euroCoin = determiner.recognise(FIFTY_CENT_COIN);

        assertThat(euroCoin).hasValue(FIFTY_CENTS);
    }

    @Test
    void when2EuroIsInserted_then2EuroIsRecognised(){
        Optional<EuroCoin> euroCoin = determiner.recognise(TWO_EURO_COIN);

        assertThat(euroCoin).hasValue(TWO_EURO);
    }

    @Test
    void whenInputInvalid_thenEmptyOptional(){
        Coin coin = new Coin(0,0);

        Optional<EuroCoin> euroCoin = determiner.recognise(coin);

        assertThat(euroCoin).isEmpty();
    }
}
