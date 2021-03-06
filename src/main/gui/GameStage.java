package gui;

import board.Simulation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import structures.Vector2d;

import java.util.HashSet;
import java.util.Set;

import static structures.Vector2d.VECTOR_WIDTH;

public class GameStage extends Application {
    private Simulation simulation;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // set tittle
        stage.setTitle("Game of life");

        stage.setOnCloseRequest(actionEvent -> {
            System.exit(0);
        });

        // add buttons
        Button choosePatternButton = new Button("Choose pattern");
        choosePatternButton.setOnAction(actionEvent -> {
            setChoosePatternScene(stage);
        });

        Button createYourOwnPattern = new Button("Create your own pattern");
        createYourOwnPattern.setOnAction(actionEvent -> {
            setCreatePatternScene(stage);
        });

        // add grid pane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(choosePatternButton, 0, 0);
        gridPane.add(createYourOwnPattern, 1, 0);

        // create scene
        Scene homeScene = new Scene(gridPane);
        stage.setScene(homeScene);

        stage.show();
    }

    private void setChoosePatternScene(Stage stage) {
        GridPane gridPaneToChoosePattern = new GridPane();
        gridPaneToChoosePattern.setMinSize(400, 200);
        gridPaneToChoosePattern.setPadding(new Insets(10, 10, 10, 10));
        gridPaneToChoosePattern.setVgap(5);
        gridPaneToChoosePattern.setHgap(5);
        gridPaneToChoosePattern.setAlignment(Pos.CENTER);

        Label label = new Label("Choose one pattern");
        gridPaneToChoosePattern.add(label, 0, 0);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Beacon");
        choiceBox.getItems().add("Blinker");
        choiceBox.getItems().add("House");
        choiceBox.getItems().add("Pentadecathlon");
        choiceBox.getItems().add("Pulsar");
        choiceBox.getItems().add("Toad");
        gridPaneToChoosePattern.add(choiceBox, 0, 2);

        Button startGameButton = new Button("Start");
        startGameButton.setOnAction(actionEvent -> {
            try {
                this.simulation = new Simulation(choiceBox.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }

            GameScene gameScene = new GameScene(new Group(), simulation.getBoard().getWidth(), simulation.getBoard().getHeight(), simulation.getBoard().getAliveCells().keySet());
            stage.setScene(gameScene);
            gameScene.startGame(simulation);
        });
        gridPaneToChoosePattern.add(startGameButton, 0, 4);

        Scene scene2 = new Scene(gridPaneToChoosePattern);
        stage.setScene(scene2);
    }

    private void setCreatePatternScene(Stage stage) {
        GridPane gridPaneToChoosePattern = new GridPane();
        gridPaneToChoosePattern.setMinSize(400, 200);
        gridPaneToChoosePattern.setPadding(new Insets(10, 10, 10, 10));
        gridPaneToChoosePattern.setVgap(5);
        gridPaneToChoosePattern.setHgap(5);
        gridPaneToChoosePattern.setAlignment(Pos.CENTER);

        Label label = new Label("Width and height of board");
        gridPaneToChoosePattern.add(label, 0, 0);

        TextField width = new TextField("10");
        gridPaneToChoosePattern.add(width, 0, 1);

        TextField height = new TextField("10");
        gridPaneToChoosePattern.add(height, 1, 1);

        Label label2 = new Label("Survival rules and birth rules separated by space");
        gridPaneToChoosePattern.add(label2, 0, 2);

        TextField survivalRules = new TextField("2 3");
        gridPaneToChoosePattern.add(survivalRules, 0, 3);

        TextField birthRules = new TextField("3");
        gridPaneToChoosePattern.add(birthRules, 1, 3);

        Label label3 = new Label("Width of cell");
        gridPaneToChoosePattern.add(label3, 0, 4);

        TextField vectorWidth = new TextField("24");
        gridPaneToChoosePattern.add(vectorWidth, 0, 5);

        Button confirmParameters = new Button("Next");
        confirmParameters.setOnAction(actionEvent -> {
            try {
                Vector2d.setVectorWidth(Integer.parseInt(vectorWidth.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            chooseCells(stage, Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), survivalRules.getText(), birthRules.getText());
        });

        gridPaneToChoosePattern.add(confirmParameters, 0, 6);
        Scene scene = new Scene(gridPaneToChoosePattern);
        stage.setScene(scene);
    }

    private void chooseCells(Stage stage, int width, int height, String survivalRules, String birthRules) {
        Group root = new Group();
        Set<Vector2d> positions = new HashSet<>();

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

                rectangle.setOnMouseClicked(mouseEvent -> {
                    rectangle.setFill(Color.DARKRED);
                    positions.add(new Vector2d((int) rectangle.getX(), (int) rectangle.getY()));
                });

                root.getChildren().add(rectangle);
            }
        }


        Button startGameButton = new Button("Start");
        startGameButton.setOnAction(actionEvent -> {
            this.simulation = new Simulation(width, height, survivalRules, birthRules, positions);
            GameScene gameScene = new GameScene(new Group(), width, height, positions);
            stage.setScene(gameScene);
            gameScene.startGame(simulation);
        });


        startGameButton.setLayoutX(width * VECTOR_WIDTH / 2 - VECTOR_WIDTH);
        startGameButton.setLayoutY(height * VECTOR_WIDTH + VECTOR_WIDTH);

        root.getChildren().add(startGameButton);

        Scene scene = new Scene(root, width * VECTOR_WIDTH, height * VECTOR_WIDTH + 4 * VECTOR_WIDTH);
        stage.setScene(scene);
    }
}
