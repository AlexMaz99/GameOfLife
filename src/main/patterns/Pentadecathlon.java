package patterns;

import board.Board;
import structures.Vector2d;

public class Pentadecathlon extends Board {
    public Pentadecathlon() {
        super(18, 11);
        addLivingCell(new Vector2d(4, 5, true));
        addLivingCell(new Vector2d(5, 5, true));

        addLivingCell(new Vector2d(7, 5, true));
        addLivingCell(new Vector2d(8, 5, true));
        addLivingCell(new Vector2d(9, 5, true));
        addLivingCell(new Vector2d(10, 5, true));

        addLivingCell(new Vector2d(12, 5, true));
        addLivingCell(new Vector2d(13, 5, true));

        addLivingCell(new Vector2d(6, 4, true));
        addLivingCell(new Vector2d(6, 6, true));

        addLivingCell(new Vector2d(11, 4, true));
        addLivingCell(new Vector2d(11, 6, true));
    }
}
