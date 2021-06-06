import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void getLiquidType() {
        Cup c = new Cup("Orange juice",85.5);
//        assertEquals(42,24);
        assertEquals("Orange juice",c.getLiquidType());
    }
    @Test
    void getPercentFull() {
        Cup c = new Cup("Orange juice",85.5);
        assertEquals(85.5,c.getPercentFull(),0.001);
    }

    @Test
    void setLiquidType() {
        Cup c = new Cup("Orange juice",85.5);
        c.setLiquidType("water");
        assertEquals("water",c.getLiquidType());
    }

    @Test
    void setPercentFull() {
        Cup c = new Cup("Orange juice",85.5);
        c.setPercentFull(85.5);
        assertEquals(85.5,c.getPercentFull());
    }
}