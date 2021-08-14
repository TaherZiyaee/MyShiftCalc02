package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> comboMonth;

    public void exitApplication(MouseEvent event) {
        Platform.exit();
        System.out.println("Exit from application.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] persianMonths = {
                "FARVARDIN","ORDIBEHESHT","KHORDAD",
                "TIR","MORDAD","SHAHRIVAR",
                "MEHR","ABAN","AZAR",
                "DAY","BAHMAN","ESFAND"
        };
        ObservableList<String> months = FXCollections.observableArrayList(persianMonths);
        comboMonth.setItems(months);
        comboMonth.setValue(persianMonths[0]);
    }
}
