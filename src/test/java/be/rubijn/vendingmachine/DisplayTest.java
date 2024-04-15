package be.rubijn.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayTest {
    private final Display display = new Display();

    @Test
    void whenReadingDisplay_thenShowInsertCoin(){
        assertThat(display.read(0)).isEqualTo("INSERT COIN.\nAMOUNT: 0.00");
    }

    @Test
    void givenAmountOnePointFiveEuro_whenReadingDisplay_thenShowInsertCoin(){
        assertThat(display.read(150)).isEqualTo("INSERT COIN.\nAMOUNT: 1.50");
    }

    //todo test voor selected product
}
