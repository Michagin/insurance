package kea.dat20b;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class Controller {

    private final double SLOOP_BASEPRICE = 200000;
    private final double BRIG_BASEPRICE = 530000;
    private final double GAL_BASEPRICE = 1240000;

    private final double DOG_MODIFIER = 0.5;
    private final double CAT_MODIFIER = 1.0;
    private final double MONKEY_MODIFIER = 2.0;

    private final int DOUBLOON_TO_ANCIENTCOIN_CONVERTION_RATIO = 2500;


    private double q1Modifier = SLOOP_BASEPRICE;
    private double q2Modifier = 1;
    private double q3Modifier;
    private double q4Modifier = 1;
    private final double BASEPRICE = 12000;

    @FXML
    TitledPane Q1, Q2, Q3, Q4;

    @FXML
    BorderPane borderPane;

    @FXML
    Spinner<Integer> bombUnits;

    @FXML
    VBox innerBox;

    @FXML
    ComboBox<String> shipType, petAnswer, petType;

    @FXML
    Button q1nextButton;

    @FXML
    Label labelTotalDoubloons, labelTotalAncientCoin;

    @FXML
    CheckBox q2cb1, q2cb2, q2cb3, q2cb4, q2cb5, q2cb6;

    @FXML
    public void initialize() {
        innerBox.setPadding(new Insets(20, 20, 20, 20));
        setQuestionNumberOnTitledPanes();
        Q1Setup();
        Q2Setup();
        Q3Setup();
        Q4Setup();
    }

    public Controller() {

    }

    private void setQuestionNumberOnTitledPanes() {
        int currentIndex = 1;
        for (Node node : innerBox.getChildren()) {

            TitledPane tp = (TitledPane) node;
            tp.setText("Question " + currentIndex);
            currentIndex++;
        }
    }

    public void Q1NextButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(0);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(1);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }


    public void Q2NextButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(1);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(2);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }

    public void Q2BackButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(1);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(0);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }

    public void Q3NextButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(2);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(3);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }

    public void Q3BackButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(2);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(1);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }

    public void Q4BackButtonFire(ActionEvent actionEvent) {
        Node q1TitledPane;
        q1TitledPane = innerBox.getChildren().get(3);
        ((TitledPane) q1TitledPane).setExpanded(false);
        q1TitledPane = innerBox.getChildren().get(2);
        ((TitledPane) q1TitledPane).setExpanded(true);
    }

    private void Q1Setup() {
        //Question 1 setup
        Q1.setExpanded(true);
        shipType.setItems(FXCollections.observableArrayList(Arrays.asList("Sloop", "Brigantine", "Galleon")));
        shipType.getSelectionModel().selectFirst();
        shipType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Sloop" -> q1Modifier = SLOOP_BASEPRICE;
                case "Brigantine" -> q1Modifier = BRIG_BASEPRICE;
                case "Galleon" -> q1Modifier = GAL_BASEPRICE;
                default -> q1Modifier = 0;
            }
            setPriceLabels();
        });
    }

    private void Q2Setup() {
        //Question 2 setup
        Q2.setExpanded(false);

        q2cb1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

        q2cb2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

        q2cb3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

        q2cb4.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

        q2cb5.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

        q2cb6.selectedProperty().addListener((observable, oldValue, newValue) -> {
            q2Modifier = calcQ2Modifiers();
            setPriceLabels();
        });

    }

    private void Q3Setup() {
        //Question 3 setup
        Q3.setExpanded(false);
        int INITIAL_VALUE = 4;
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, INITIAL_VALUE);
        bombUnits.setValueFactory(svf);

        bombUnits.valueProperty().addListener((observable, oldValue, newValue) -> {
            q3Modifier = newValue;
            setPriceLabels();
        });
    }

    private void Q4Setup() {
        //Question 4 setup
        Q4.setExpanded(false);
        petAnswer.setItems(FXCollections.observableArrayList(Arrays.asList("Yes", "No")));
        petAnswer.getSelectionModel().selectFirst();
        petType.setItems(FXCollections.observableArrayList(Arrays.asList("Monkey", "Cat", "Dog")));
        petType.getSelectionModel().selectFirst();
        petAnswer.valueProperty().addListener((observable -> {
            petType.setVisible(petAnswer.getValue().equals("Yes"));
            if (!petType.isVisible()) {
                q4Modifier = 1;
                setPriceLabels();
            }
        }));
        petType.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("pet type just changed from: " + oldValue + " -> " + newValue);
            switch (newValue) {
                case "Dog" -> q4Modifier = DOG_MODIFIER;
                case "Cat" -> q4Modifier = CAT_MODIFIER;
                case "Monkey" -> q4Modifier = MONKEY_MODIFIER;
            }
            setPriceLabels();
        });

    }

    private double calcPrice() {
        return q1Modifier + BASEPRICE * (q2Modifier * q3Modifier * q4Modifier);
    }

    private void setPriceLabels() {
        labelTotalDoubloons.setText(String.valueOf(calcPrice()));
        labelTotalAncientCoin.setText(String.valueOf(calcPrice() / DOUBLOON_TO_ANCIENTCOIN_CONVERTION_RATIO));
    }

    private double calcQ2Modifiers() {
        double modifier = 1;
        if (q2cb1.selectedProperty().get() || q2cb2.selectedProperty().get()) {
            modifier *= 5.0;
        }
        if (q2cb3.selectedProperty().get()) {
            modifier *= 0.7;
        }
        if (q2cb4.selectedProperty().get()) {
            modifier *= 0.5;
        }
        if (q2cb5.selectedProperty().get()) {
            modifier *= 2.0;
        }
        if (q2cb6.selectedProperty().get()) {
            modifier *= 3.0;
        }

        return modifier;
    }

}
