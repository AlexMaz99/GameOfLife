package board;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import structures.Cell;
import structures.Vector2d;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private static Board board;

    @BeforeAll
    static void init() throws Exception {
        Vector2d.setVectorWidth(12);
        board = new Board(5, 5);
    }

    @Test
    void day() throws Exception {
        // given
        Vector2d.setVectorWidth(12);
        Board board1 = new Board(3, 3);
        board1.addLivingCell(new Vector2d(0, 1, true));
        board1.addLivingCell(new Vector2d(1, 1, true));
        board1.addLivingCell(new Vector2d(2, 1, true));

        // when
        board1.day();
        HashMap<Vector2d, Cell> aliveCells = board1.getAliveCells();

        // then
        assertTrue(aliveCells.containsKey(new Vector2d(1, 1, true)));
        assertTrue(aliveCells.containsKey(new Vector2d(1, 0, true)));
        assertTrue(aliveCells.containsKey(new Vector2d(1, 2, true)));
        assertFalse(aliveCells.containsKey(new Vector2d(0, 1, true)));
        assertFalse(aliveCells.containsKey(new Vector2d(2, 1, true)));
    }

    @Test
    void countLivingNeighbours() {
        // given
        Vector2d vector2d = new Vector2d(2, 2, true);
        Vector2d vector2d1 = new Vector2d(1, 2, true);
        Vector2d vector2d2 = new Vector2d(1, 1, true);
        board.addLivingCell(vector2d);
        board.addLivingCell(vector2d1);
        board.addLivingCell(vector2d2);

        // when then
        assertEquals(board.countLivingNeighbours(vector2d), 2);
        assertEquals(board.countLivingNeighbours(vector2d1), 2);
        assertEquals(board.countLivingNeighbours(vector2d2), 2);
    }

    @Test
    void updateNeighbours() {
        // given
        Vector2d vector2d = new Vector2d(2, 2, true);
        Vector2d vector2d1 = new Vector2d(1, 2, true);
        Vector2d vector2d2 = new Vector2d(4, 5, true);
        board.addLivingCell(vector2d);
        board.addLivingCell(vector2d1);
        board.addLivingCell(vector2d2);

        // when
        board.updateNeighbours();
        HashMap<Vector2d, Cell> aliveCells = board.getAliveCells();

        // then
        assertEquals(aliveCells.get(vector2d).getNeighbours(), 1);
        assertEquals(aliveCells.get(vector2d1).getNeighbours(), 1);
        assertEquals(aliveCells.get(vector2d2).getNeighbours(), 0);
    }

    @Test
    void addLivingCell() {
        // given
        Vector2d vector2d = new Vector2d(12, 12);

        // when
        board.addLivingCell(vector2d);

        // then
        assertTrue(board.getAliveCells().containsKey(vector2d));
    }

    @Test
    void removeDeadCell() {
        // given
        Vector2d vector2d = new Vector2d(12, 12);
        board.addLivingCell(vector2d);

        // when
        board.removeDeadCell(vector2d);

        // then
        assertFalse(board.isAliveCell(vector2d));
    }

    @Test
    void isAliveCell() {
        // given
        Vector2d vector2d = new Vector2d(24, 24);
        Vector2d vector2d1 = new Vector2d(12, 12);

        // when
        board.addLivingCell(vector2d);

        // then
        assertTrue(board.isAliveCell(vector2d));
        assertFalse(board.isAliveCell(vector2d1));
    }

    @Test
    void insideBoard() {
        // given
        Vector2d vector2d = new Vector2d(12, 12);
        Vector2d vector2d1 = new Vector2d(60, 60);
        Vector2d vector2d2 = new Vector2d(61, 61);

        // when then
        assertTrue(board.insideBoard(vector2d));
        assertTrue(board.insideBoard(vector2d1));
        assertFalse(board.insideBoard(vector2d2));
    }


    @Test
    void isAnyCellAliveWhenIs() {
        // given
        Vector2d vector2d = new Vector2d(12, 12);

        // when
        board.addLivingCell(vector2d);

        // then
        assertTrue(board.isAnyCellAlive());
    }

}