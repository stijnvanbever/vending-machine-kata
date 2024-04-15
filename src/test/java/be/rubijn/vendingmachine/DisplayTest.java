package be.rubijn.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayTest {
    @Test
    void whenReadingDisplay_thenShowInsertCoin(){
        Display display = new Display();

        assertThat(display.read()).isEqualTo("INSERT COIN.\nAMOUNT: 0.00");
    }

    @Test
    void givenAmountOnePointFiveEuro_whenReadingDisplay_thenShowInsertCoin(){
        Display display = new Display();

        assertThat(display.read()).isEqualTo("INSERT COIN.\nAMOUNT: 1.50");
    }

    //todo test voor selected product
}
