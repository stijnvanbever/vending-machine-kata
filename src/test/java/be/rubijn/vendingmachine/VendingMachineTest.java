package be.rubijn.vendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static be.rubijn.vendingmachine.Product.COLA;
import static be.rubijn.vendingmachine.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest(classes = VendingMachineTestConfiguration.class)
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class VendingMachineTest {
    @Autowired
    private VendingMachine vendingMachine;

    @Test
    void whenShowInitMessage_thenShowWelkomInEUROpapa(){
        assertThat(vendingMachine.showInitMessage()).isEqualTo("welkom in EUROpa, blijf hier tot ik doodga");
    }

    @Test
    void whenVendingMachineIsEmpty_thenShowInsertCoin(){
        assertThat(vendingMachine.showDisplay()).isEqualTo("INSERT COIN\nAMOUNT: 0.00");
    }

    @Test
    void whenCoinsAreAccepted_thenAddAmountToTotal(){
        vendingMachine.accept(ONE_EURO_COIN);

        assertThat(vendingMachine.showDisplay()).isEqualTo("INSERT COIN\nAMOUNT: 1.00");
    }

    @Test
    void whenMultipleCoinsAreAccepted_thenAddAmountToTotal(){
        vendingMachine.accept(ONE_EURO_COIN);
        vendingMachine.accept(FIFTY_CENT_COIN);
        vendingMachine.accept(TWO_EURO_COIN);

        assertThat(vendingMachine.showDisplay()).isEqualTo("INSERT COIN\nAMOUNT: 3.50");
    }

    @Test
    void whenInvalidCoinsAreAccepted_thenDontAddAmountToTotal(){
        vendingMachine.accept(INVALID_EURO_COIN);

        assertThat(vendingMachine.showDisplay()).isEqualTo("INSERT COIN\nAMOUNT: 0.00");
    }

    @Test
    void givenPreviousAmount_whenInvalidCoinsAreAccepted_thenDontAddAmountToTotal(){
        vendingMachine.accept(ONE_EURO_COIN);

        vendingMachine.accept(INVALID_EURO_COIN);

        assertThat(vendingMachine.showDisplay()).isEqualTo("INSERT COIN\nAMOUNT: 1.00");
    }

    @Test
    void whenInvalidCoinsAreAccepted_thenAddCoinToReturnTray(){
        vendingMachine.accept(INVALID_EURO_COIN);

        assertThat(vendingMachine.getReturnTray()).containsExactlyInAnyOrder(INVALID_EURO_COIN);
    }

    @Test
    void givenOneEuroIsInserted_whenColaIsSelected_thenProductIsDispenced(){
        vendingMachine.accept(ONE_EURO_COIN);

        vendingMachine.selectProduct(COLA);

        assertThat(vendingMachine.showDisplay()).isEqualTo("THANK YOU\nAMOUNT: 0.00");
        assertThat(vendingMachine.getItemsFromDispenser()).containsExactlyInAnyOrder(COLA);
    }
}
