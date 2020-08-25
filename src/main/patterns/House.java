package patterns;

import board.Board;
import structures.Vector2d;

public class House extends Board {
    public House() throws Exception {
        super(60, 65);
        Vector2d.setVectorWidth(10);
        addLivingCell(new Vector2d(22, 21, true));
        addLivingCell(new Vector2d(22, 22, true));
        addLivingCell(new Vector2d(22, 23, true));

        addLivingCell(new Vector2d(23, 20, true));
        addLivingCell(new Vector2d(24, 20, true));
        addLivingCell(new Vector2d(24, 21, true));

        addLivingCell(new Vector2d(23, 24, true));
        addLivingCell(new Vector2d(24, 24, true));
        addLivingCell(new Vector2d(24, 23, true));
    }
}
