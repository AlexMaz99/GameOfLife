package structures;

import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    private static Board board;
    private static Cell cell;

    @BeforeAll
    static void init() {
        board = new Board(5, 5);
        cell = new Cell(new Vector2d(2, 2, true), board);
    }

    @Test
    void changeState() {
        // given

        // when
        cell.changeState();

        // then
        assertEquals(cell.getState(), State.DEAD);
    }

    @Test
    void updateNeighbours() {
        // given
        board.addLivingCell(new Vector2d(1, 1, true));
        board.addLivingCell(new Vector2d(1, 2, true));
        board.addLivingCell(new Vector2d(3, 3, true));

        // when
        cell.updateNeighbours();

        // then
        assertEquals(cell.getNeighbours(), 3);
    }

    @Test
    void resetNeighbours() {
        // given

        // when
        cell.resetNeighbours();

        // then
        assertEquals(cell.getNeighbours(), 0);
    }

}