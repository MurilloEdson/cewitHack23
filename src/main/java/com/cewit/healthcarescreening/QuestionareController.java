package com.cewit.healthcarescreening;

import java.io.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 *
 * @author murillo-edson
 */
public class QuestionareController {

    @FXML
    private TextField age, height, id, sex, weight;

    @FXML
    private CheckBox smoker;

    @FXML
    private void switchToSecondary() throws IOException {
        try {
            int sID = Integer.parseInt(id.getText());
            int sWeight = Integer.parseInt(weight.getText());
            int sAge = Integer.parseInt(age.getText());
            int sHeight = Integer.parseInt(height.getText());
            Patient pat = new Patient(sID, sWeight, sAge, sHeight, sex.getText().charAt(0));
            System.out.println(pat);
            App.setRoot("secondary");
        } catch (RuntimeException ite) {
            System.out.println("There is an empty field");
            App.setRoot("secondary");
        }
    }
}
