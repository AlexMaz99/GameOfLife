package board;

import patterns.*;
import structures.Vector2d;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Simulation {
    private final Board board;

    public Simulation(String pattern) throws Exception {
        switch (pattern) {
            case "Beacon" -> this.board = new Beacon();
            case "Blinker" -> this.board = new Blinker();
            case "Pulsar" -> this.board = new Pulsar();
            case "Pentadecathlon" -> this.board = new Pentadecathlon();
            case "House" -> this.board = new House();
            case "Toad" -> this.board = new Toad();
            default -> throw new NoSuchObjectException("There is no pattern called " + pattern);
        }
    }

    public Simulation(int width, int height, String survivalRulesText, String birthRulesText, Set<Vector2d> positions) {
        List<Integer> survivalRules = new ArrayList<>();
        List<Integer> birthRules = new ArrayList<>();

        if (survivalRulesText.isEmpty() || birthRulesText.isEmpty())
            throw new NullPointerException("There is no rules");

        String[] survivalArray = survivalRulesText.split(" ");
        for (String word : survivalArray)
            survivalRules.add(Integer.valueOf(word));

        String[] birthArray = birthRulesText.split(" ");
        for (String word : birthArray)
            birthRules.add(Integer.valueOf(word));

        this.board = new Board(width, height, survivalRules, birthRules);

        for (Vector2d position : positions)
            this.board.addLivingCell(position);
    }

    public Board getBoard() {
        return this.board;
    }
}
