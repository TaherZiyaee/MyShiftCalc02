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
    private ComboBox<String> comboMonth, combo3Friday;
    @FXML
    private Label lblMonthTitle, lblMonthDomain;

    public void exitApplication(MouseEvent event) {
        Platform.exit();
        System.out.println("Exit from application.");
    }

    public void setLblMonthDomain(Label lblMonthDomain) {
        int monthDays;
        String textDomain = null;
        selectedMonth = comboMonth.getSelectionModel().getSelectedItem();
        switch (selectedMonth) {
            case "FARVARDIN":
                textDomain = "21st Esfand ~ 20th Farvardin";
                monthDays = 31;
                break;
            case "ORDIBEHESHT":
                textDomain = "21st Farvardin ~ 20th Ordibehesht";
                break;
            case "KHORDAD":
                textDomain = "21st Ordibehesht ~ 20th Khordad";
                break;
            case "TIR":
                textDomain = "21st Khordad ~ 20th Tir";
                break;
            case "MORDAD":
                textDomain = "21st Tir ~ 20th Mordad";
                break;
            case "SHAHRIVAR":
                textDomain = "21st Mordad ~ 20th Shahrivar";
                break;
            case "MEHR":
                textDomain = "21st Shahrivar ~ 20th Mehr";
                break;
            case "ABAN":
                textDomain = "21st Mehr ~ 20th Aban";
                break;
            case "AZAR":
                textDomain = "21st Aban ~ 20th Azar";
                break;
            case "DAY":
                textDomain = "21st Azar ~ 20th Day";
                break;
            case "BAHMAN":
                textDomain = "21st Day ~ 20th Bahman";
                break;
            case "ESFAND":
                textDomain = "21st Bahman ~ 20th Esfand";
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
        lblMonthDomain.setText("21st ESFAND ~ 20th FARVARDIN");

        String[] threeFridaysSelect = {"None","Shift 1","Shift 2"};
        ObservableList<String> threeFri = FXCollections.observableArrayList(threeFridaysSelect);
        combo3Friday.setItems(threeFri);
        combo3Friday.setValue(threeFridaysSelect[0]);

    }


}
