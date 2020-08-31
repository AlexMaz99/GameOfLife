package board;

import structures.Cell;
import structures.Vector2d;

import java.util.*;

public class Board {

    private final Vector2d lowerLeft, upperRight;
    private final int width, height;
    private final List<Integer> survivalRules;
    private final List<Integer> birthRules;
    private final HashMap<Vector2d, Cell> aliveCells;

    public Board(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0, true);
        this.upperRight = new Vector2d(width, height, true);
        this.width = width;
        this.height = height;
        this.aliveCells = new HashMap<>();
        this.survivalRules = new ArrayList<>();
        this.birthRules = new ArrayList<>();
        this.survivalRules.add(2);
        this.survivalRules.add(3);
        this.birthRules.add(3);
        this.updateNeighbours();
    }

    public Board(int width, int height, List<Integer> survivalRules, List<Integer> birthRules) {
        this.lowerLeft = new Vector2d(0, 0, true);
        this.upperRight = new Vector2d(width, height, true);
        this.width = width;
        this.height = height;
        this.aliveCells = new HashMap<>();
        this.survivalRules = new ArrayList<>();
        this.birthRules = new ArrayList<>();
        this.survivalRules.addAll(survivalRules);
        this.birthRules.addAll(birthRules);
        this.updateNeighbours();
    }


    public void day() {
        this.updateNeighbours();
        List<Cell> deadCells = new ArrayList<>();
        Collection<Cell> livingCells = this.aliveCells.values();

        for (Cell cell : livingCells) {
            if (!this.survivalRules.contains(cell.getNeighbours())) {
                deadCells.add(cell);
            }
        }
        Set<Vector2d> cellsPosition = new HashSet<>();

        for (Cell cell : livingCells) {
            cellsPosition.addAll(cell.getPosition().neighbours());
        }

        List<Vector2d> correctCandidates = new ArrayList<>();

        for (Vector2d position : cellsPosition) {
            if (insideBoard(position) && !this.isAliveCell(position) && this.birthRules.contains(this.countLivingNeighbours(position)))
                correctCandidates.add(position);
        }

        for (Vector2d position : correctCandidates) {
            this.addLivingCell(position);
        }
        for (Cell deadCell : deadCells) {
            this.removeDeadCell(deadCell.getPosition());
        }
        deadCells.clear();
    }

    public int countLivingNeighbours(Vector2d position) {
        int livingNeighbours = 0;
        for (Vector2d neighbour : position.neighbours()) {
            if (insideBoard(neighbour) && this.isAliveCell(neighbour)) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;

    }

    public void updateNeighbours() {
        for (Cell livingCell : this.aliveCells.values()) livingCell.updateNeighbours();
    }

    public void addLivingCell(Vector2d position) {
        this.aliveCells.put(position, new Cell(position, this));
    }

    public void removeDeadCell(Vector2d position) {
        Cell cell = this.aliveCells.get(position);
        cell.changeState();
        this.aliveCells.remove(position);
    }

    public boolean isAliveCell(Vector2d position) {
        return this.aliveCells.get(position) != null;
    }

    public boolean insideBoard(Vector2d position) {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }

    public boolean isAnyCellAlive() {
        return !this.aliveCells.isEmpty();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Vector2d getUpperRight() {
        return this.upperRight;
    }

    public Vector2d getLowerLeft() {
        return this.lowerLeft;
    }

    public HashMap<Vector2d, Cell> getAliveCells() {
        return aliveCells;
    }


    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (this.aliveCells.containsKey(new Vector2d(i, j))) {
                    boardString.append("■");
                } else boardString.append("□");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
