package sample;

import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.util.StringUtils;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String selectedMonth;
    private int monthDays = 31;


    @FXML
    private ComboBox<String> comboMonth;
    @FXML
    private ComboBox<String> combo3Friday;
    @FXML
    private Label lblMonthTitle, lblMonthDomain, lblShift1, lblShift2, lblRegWorking;
    @FXML
    private JFXTextField txtFridays, txtThursdays, txtWednesdays, txtFHolidays, txtWHolidays, txtOther;

    public void exitApplication(MouseEvent event) {
        Platform.exit();
        System.out.println("Exit from application.");
    }

    public void setLblMonthDomain(Label lblMonthDomain) {
        String textDomain = null;
        selectedMonth = comboMonth.getSelectionModel().getSelectedItem();
        switch (selectedMonth) {
            case "FARVARDIN":
                textDomain = "21st Esfand ~ 20th Farvardin";
                monthDays = 31;
                break;
            case "ORDIBEHESHT":
                textDomain = "21st Farvardin ~ 20th Ordibehesht";
                monthDays = 31;
                break;
            case "KHORDAD":
                textDomain = "21st Ordibehesht ~ 20th Khordad";
                monthDays = 31;
                break;
            case "TIR":
                textDomain = "21st Khordad ~ 20th Tir";
                monthDays = 31;
                break;
            case "MORDAD":
                textDomain = "21st Tir ~ 20th Mordad";
                monthDays = 31;
                break;
            case "SHAHRIVAR":
                textDomain = "21st Mordad ~ 20th Shahrivar";
                monthDays = 31;
                break;
            case "MEHR":
                textDomain = "21st Shahrivar ~ 20th Mehr";
                monthDays = 30;
                break;
            case "ABAN":
                textDomain = "21st Mehr ~ 20th Aban";
                monthDays = 30;
                break;
            case "AZAR":
                textDomain = "21st Aban ~ 20th Azar";
                monthDays = 30;
                break;
            case "DAY":
                textDomain = "21st Azar ~ 20th Day";
                monthDays = 30;
                break;
            case "BAHMAN":
                textDomain = "21st Day ~ 20th Bahman";
                monthDays = 30;
                break;
            case "ESFAND":
                textDomain = "21st Bahman ~ 20th Esfand";
                monthDays = 29;
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

    public void calculation(MouseEvent event) {

        final String regText = "Regular Working Hour: ";
        int fri = 0, thur = 0, wed = 0, fHoliday = 0, wHoliday = 0, other = 0;

        fri = Integer.parseInt(txtFridays.getText());
        thur = Integer.parseInt(txtThursdays.getText());
        wed = Integer.parseInt(txtWednesdays.getText());
        fHoliday = Integer.parseInt(txtFHolidays.getText());
        wHoliday = Integer.parseInt(txtWHolidays.getText());
//        other = Integer.parseInt(txtOther.getText());

        int lastweek = fri + thur;
        int wedCalc = wed - wHoliday;
        int edariDays = monthDays - (lastweek + wedCalc + fHoliday);
        int edariHours = edariDays * 9;
        System.out.println(fri + 10);

        lblShift1.setText(txtFridays.getText());
        if (lblShift1.getText().length() < 2)
            lblShift1.setText("0" + lblShift1.getText());

        lblRegWorking.setText(regText + Integer.toString(edariHours));
    }

//    EventHandler<MouseEvent> eventHandler

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
