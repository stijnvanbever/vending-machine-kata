package be.rubijn.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayTest {
    private final Display display = new Display();

    @Test
    void whenReadingDisplay_thenShowInsertCoin(){
        assertThat(display.read(0)).isEqualTo("INSERT COIN\nAMOUNT: 0.00");
    }

    @Test
    void givenAmountOnePointFiveEuro_whenReadingDisplay_thenShowInsertCoin(){
        assertThat(display.read(150)).isEqualTo("INSERT COIN\nAMOUNT: 1.50");
    }

    @Test
    void givenTextToDisplay_whenReadingDisplay_thenShowText(){
        display.addText("THANK YOU");

        assertThat(display.read(150)).isEqualTo("THANK YOU\nAMOUNT: 1.50");
    }

    @Test
    void givenMultipleTextsToDisplay_whenReadingDisplay_thenShowTextsInOrder(){
        display.addText("THANK YOU");
        display.addText("SECOND TEXT");
        display.addText("LAST TEXT");

        assertThat(display.read(150)).isEqualTo("LAST TEXT\nAMOUNT: 1.50");
        assertThat(display.read(150)).isEqualTo("SECOND TEXT\nAMOUNT: 1.50");
        assertThat(display.read(150)).isEqualTo("THANK YOU\nAMOUNT: 1.50");
    }
}
