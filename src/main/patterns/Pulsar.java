package patterns;

import board.Board;
import structures.Vector2d;

public class Pulsar extends Board {
    public Pulsar() {
        super(15, 15);

        addLivingCell(new Vector2d(3, 1, true));
        addLivingCell(new Vector2d(4, 1, true));
        addLivingCell(new Vector2d(5, 1, true));

        addLivingCell(new Vector2d(3, 8, true));
        addLivingCell(new Vector2d(4, 8, true));
        addLivingCell(new Vector2d(5, 8, true));

        addLivingCell(new Vector2d(1, 3, true));
        addLivingCell(new Vector2d(1, 4, true));
        addLivingCell(new Vector2d(1, 5, true));

        addLivingCell(new Vector2d(1, 9, true));
        addLivingCell(new Vector2d(1, 10, true));
        addLivingCell(new Vector2d(1, 11, true));

        addLivingCell(new Vector2d(6, 3, true));
        addLivingCell(new Vector2d(6, 4, true));
        addLivingCell(new Vector2d(6, 5, true));

        addLivingCell(new Vector2d(3, 6, true));
        addLivingCell(new Vector2d(4, 6, true));
        addLivingCell(new Vector2d(5, 6, true));

        addLivingCell(new Vector2d(3, 13, true));
        addLivingCell(new Vector2d(4, 13, true));
        addLivingCell(new Vector2d(5, 13, true));

        addLivingCell(new Vector2d(6, 9, true));
        addLivingCell(new Vector2d(6, 10, true));
        addLivingCell(new Vector2d(6, 11, true));

        addLivingCell(new Vector2d(8, 3, true));
        addLivingCell(new Vector2d(8, 4, true));
        addLivingCell(new Vector2d(8, 5, true));

        addLivingCell(new Vector2d(9, 1, true));
        addLivingCell(new Vector2d(10, 1, true));
        addLivingCell(new Vector2d(11, 1, true));

        addLivingCell(new Vector2d(9, 6, true));
        addLivingCell(new Vector2d(10, 6, true));
        addLivingCell(new Vector2d(11, 6, true));

        addLivingCell(new Vector2d(9, 8, true));
        addLivingCell(new Vector2d(10, 8, true));
        addLivingCell(new Vector2d(11, 8, true));

        addLivingCell(new Vector2d(9, 13, true));
        addLivingCell(new Vector2d(10, 13, true));
        addLivingCell(new Vector2d(11, 13, true));

        addLivingCell(new Vector2d(13, 3, true));
        addLivingCell(new Vector2d(13, 4, true));
        addLivingCell(new Vector2d(13, 5, true));

        addLivingCell(new Vector2d(13, 9, true));
        addLivingCell(new Vector2d(13, 10, true));
        addLivingCell(new Vector2d(13, 11, true));

        addLivingCell(new Vector2d(8, 9, true));
        addLivingCell(new Vector2d(8, 10, true));
        addLivingCell(new Vector2d(8, 11, true));
    }
}
