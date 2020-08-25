package structures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void precedes() {
        // given
        Vector2d vector1 = new Vector2d(5, 6);
        Vector2d vector2 = new Vector2d(6, 6);

        // when then
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void follows() {
        // given
        Vector2d vector1 = new Vector2d(6, 6);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertTrue(vector1.follows(vector2));
    }

    @Test
    void upperRight() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.upperRight(vector2), new Vector2d(5, 7));
    }

    @Test
    void lowerLeft() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.lowerLeft(vector2), new Vector2d(4, 6));
    }

    @Test
    void add() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.add(vector2), new Vector2d(9, 13));

    }

    @Test
    void subtract() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.subtract(vector2), new Vector2d(-1, 1));
    }

    @Test
    void opposite() {
        // given
        Vector2d vector2d = new Vector2d(5, 6);

        // when then
        assertEquals(vector2d.opposite(), new Vector2d(-5, -6));

    }

    @Test
    void setVectorWidthPositive() throws Exception {
        // given

        // when
        Vector2d.setVectorWidth(16);

        // then
        assertEquals(Vector2d.VECTOR_WIDTH, 16);
    }

    @Test
    void setVectorWidthNotPositive() {
        // given

        // when then
        assertThrows(Exception.class, () -> {
            Vector2d.setVectorWidth(0);
        });
    }

    @Test
    void neighbours() throws Exception {
        // given
        Vector2d.setVectorWidth(24);
        Vector2d vector2d = new Vector2d(2, 2, true);

        // when
        List<Vector2d> neighbours = vector2d.neighbours();

        // then
        assertTrue(neighbours.contains(new Vector2d(72, 72)));
        assertTrue(neighbours.contains(new Vector2d(72, 48)));
        assertTrue(neighbours.contains(new Vector2d(48, 72)));
        assertTrue(neighbours.contains(new Vector2d(24, 24)));
        assertTrue(neighbours.contains(new Vector2d(24, 48)));
        assertTrue(neighbours.contains(new Vector2d(24, 72)));
        assertTrue(neighbours.contains(new Vector2d(48, 24)));
        assertTrue(neighbours.contains(new Vector2d(72, 24)));
    }
}