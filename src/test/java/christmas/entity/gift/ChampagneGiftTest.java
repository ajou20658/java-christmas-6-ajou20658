package christmas.entity.gift;

import christmas.entity.menu.MenuItem;
import christmas.filter.MenuFilter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChampagneGiftTest {
    @Test
    void wineValidate() {
        assertThat(ChampagneGift.wineValidate(121000))
                .isEqualTo(true);
    }

    @Test
    void give() {
        assertThat(ChampagneGift.give())
                .isEqualTo(MenuItem.CHAMPAGNE.getMenu());
    }

    @Test
    void getName() {
        assertThat(ChampagneGift.getName())
                .isEqualTo("증정 이벤트");
    }
    @Test
    void getName2(){
        assertThat(ChampagneGift.give())
                .isInstanceOf(MenuItem.CHAMPAGNE.getMenu().getClass());
    }
}