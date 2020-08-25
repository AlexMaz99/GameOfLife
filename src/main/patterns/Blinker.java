package patterns;

import board.Board;
import structures.Vector2d;

public class Blinker extends Board {
    public Blinker() {
        super(3, 3);
        addLivingCell(new Vector2d(0, 1, true));
        addLivingCell(new Vector2d(1, 1, true));
        addLivingCell(new Vector2d(2, 1, true));
    }
}
