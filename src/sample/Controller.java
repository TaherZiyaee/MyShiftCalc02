package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String selectedMonth;


    @FXML
    private ComboBox<String> comboMonth;
    @FXML
    private Label lblMonthTitle, lblMonthDomain;

    public void exitApplication(MouseEvent event) {
        Platform.exit();
        System.out.println("Exit from application.");
    }

    public void setLblMonthDomain(Label lblMonthDomain) {
        String textDomain = "21st ESFAND ~ 20th FARVARDIN";
        selectedMonth = comboMonth.getSelectionModel().getSelectedItem();
        switch (selectedMonth) {
            case "FARVARDIN":
                textDomain = "21st ESFAND ~ 20th FARVARDIN";
                break;
            case "ORDIBEHESHT":
                textDomain = "21st FARVARDIN ~ 20th ORDIBEHESHT";
                break;
        }
        lblMonthDomain.setText(textDomain);
        this.lblMonthDomain = lblMonthDomain;
    }

    public void comboAction(ActionEvent event) {
        selectedMonth = comboMonth.getSelectionModel().getSelectedItem();
        lblMonthTitle.setText(String.format("%s 1400",selectedMonth));
        setLblMonthDomain(lblMonthDomain);
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

        lblMonthTitle.setText(String.format("%s 1400",persianMonths[0]));
        //        String selectedMonth = comboMonth.getSelectionModel().getSelectedItem();
//        monthTitle.setText(String.format("%s 1400",selectedMonth));

    }


}
