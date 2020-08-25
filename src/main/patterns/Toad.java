package patterns;

import board.Board;
import structures.Vector2d;

public class Toad extends Board {
    public Toad() {
        super(6, 6);

        addLivingCell(new Vector2d(1, 3, true));
        addLivingCell(new Vector2d(2, 3, true));
        addLivingCell(new Vector2d(3, 3, true));

        addLivingCell(new Vector2d(2, 2, true));
        addLivingCell(new Vector2d(3, 2, true));
        addLivingCell(new Vector2d(4, 2, true));
    }
}
