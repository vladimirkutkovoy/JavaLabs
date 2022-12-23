package com.example.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorUIController implements Initializable {
    Double tmp = 0.0, res = 0.0;
    boolean isOperPres = false;
    String operator = "";
    @FXML
    TextField out;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        out.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    out.setText(oldValue);
                }
            }
        });
    }

    @FXML
    private void onNumberClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();

            if(isOperPres) {
                out.setText(btn.getText().trim());
            } else {
                out.setText(out.getText().trim() + btn.getText().trim());
            }

            isOperPres = false;
        }
    }
    @FXML
    private void onOperatorClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();

            if (!out.getText().isEmpty()) {
                tmp = Double.valueOf(out.getText());

                if (btn.getText().equals("%")) {
                    tmp = res * tmp / 100;
                }

                switch (operator) {
                    case "/":
                        res /= tmp;
                        break;
                    case "X":
                        res *= tmp;
                        break;
                    case "+":
                        res += tmp;
                        break;
                    case "-":
                        res -= tmp;
                        break;
                    default:
                        res = tmp;
                }
            }

            if (btn.getText().equals("=") || btn.getText().equals("%")) {
                out.setText(String.valueOf(res));
                operator = "";
            } else {
                out.setText("");
                operator = btn.getText().trim();
            }
            isOperPres = true;
        }
    }

    @FXML
    private void onDELClick(ActionEvent event) {
        if(out.getText().length() > 0) {
            out.setText(out.getText(0, out.getText().length() - 1));
        }
    }

    @FXML
    private void onCEClick(ActionEvent event) {
        out.setText("");
        tmp = 0.0;
        res = 0.0;
        isOperPres = false;
        operator = "";
    }
}
