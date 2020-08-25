package gui;

import board.Simulation;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import structures.Cell;
import structures.Vector2d;

import java.util.HashMap;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import static structures.Vector2d.VECTOR_WIDTH;

public class GameScene extends Scene {
    private final HashMap<Vector2d, Rectangle> rectangles = new HashMap<>();
    Button stopButton = new Button("stop");

    public GameScene(Group root, int width, int height, Set<Vector2d> positions) {
        super(root, width * VECTOR_WIDTH, height * VECTOR_WIDTH + 3 * VECTOR_WIDTH);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Rectangle rectangle = new Rectangle(VECTOR_WIDTH, VECTOR_WIDTH);
                rectangle.setHeight(VECTOR_WIDTH);
                rectangle.setWidth(VECTOR_WIDTH);
                rectangle.setArcHeight(5);
                rectangle.setArcWidth(5);
                rectangle.setFill(Color.GAINSBORO);
                rectangle.setX(i * VECTOR_WIDTH);
                rectangle.setY(j * VECTOR_WIDTH);

                rectangles.put(new Vector2d((int) rectangle.getX(), (int) rectangle.getY()), rectangle);
                root.getChildren().add(rectangle);
            }
        }

        for (Vector2d position : positions) {
            Rectangle rectangle = rectangles.get(position);
            rectangle.setFill(Color.BLACK);
        }

        stopButton.setLayoutX(width * VECTOR_WIDTH / 2 - VECTOR_WIDTH);
        stopButton.setLayoutY(height * VECTOR_WIDTH + VECTOR_WIDTH);

        root.getChildren().add(stopButton);
    }

    void refreshScene(HashMap<Vector2d, Cell> aliveCells) {
        for (Vector2d position : rectangles.keySet()) {
            Rectangle rectangle = rectangles.get(position);
            if (aliveCells.containsKey(position)) {
                rectangle.setFill(Color.BLACK);
            } else {
                rectangle.setFill(Color.GAINSBORO);
            }
        }
    }

    void startGame(Simulation simulation) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (simulation.getBoard().isAnyCellAlive()) {
                        simulation.getBoard().day();
                        refreshScene(simulation.getBoard().getAliveCells());
                    } else {
                        refreshScene(simulation.getBoard().getAliveCells());
                        timer.cancel();
                    }
                });
            }
        }, 0, 100);

        stopButton.setOnAction(actionEvent -> {
            timer.cancel();
            System.exit(0);
        });
    }
}
