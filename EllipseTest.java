import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseTest {

    @Test
    void testCreateEllipseSuccess() {
        Ellipse ellipse = Ellipse.createEllipse(10, 20, 30, 40);
        assertNotNull(ellipse);
        assertEquals(10, ellipse.x);
        assertEquals(20, ellipse.y);
        assertEquals(30, ellipse.width);
        assertEquals(40, ellipse.height);
    }

    @Test
    void testCreateEllipseInvalidWidth() {
        assertThrows(IllegalArgumentException.class, () -> Ellipse.createEllipse(10, 20, -30, 40));
    }

    @Test
    void testCreateEllipseInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Ellipse.createEllipse(10, 20, 30, -40));
    }

    @Test
    void testCreateEllipseInvalidWidthAndHeight() {
        assertThrows(IllegalArgumentException.class, () -> Ellipse.createEllipse(10, 20, -30, -40));
    }

    @Test
    void testCreateEllipses(){
        List<Ellipse> ellipses = Ellipse.createEllipses();
        assertEquals(1, ellipses.size());
        assertNotNull(ellipses.get(0));

    }

}