package patterns;

import board.Board;
import structures.Vector2d;

public class Beacon extends Board {
    public Beacon() {
        super(6, 6);
        addLivingCell(new Vector2d(1, 1, true));
        addLivingCell(new Vector2d(2, 1, true));
        addLivingCell(new Vector2d(1, 2, true));

        addLivingCell(new Vector2d(4, 3, true));
        addLivingCell(new Vector2d(4, 4, true));
        addLivingCell(new Vector2d(3, 4, true));
    }
}
