package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import static java.lang.Math.pow;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtX;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private Button btnMake;

    @FXML
    private Button btnClean;

    @FXML
    private Button btOut;

    @FXML
    private TextField txtAnswer;

    @FXML
    void initialize() {
        btnClean.setOnMouseClicked(mouseEvent -> {
            txtA.setText("");
            txtB.setText("");
            txtX.setText("");
            txtAnswer.setText("");
        });
        btnMake.setOnMouseClicked(mouseEvent -> {
            double a,b,x,y;
            a = Double.parseDouble(txtA.getText());
            b = Double.parseDouble(txtB.getText());
            x = Double.parseDouble(txtX.getText());
            if (x>7){
            y = x*Math.pow(2,(a+b));
                String txty = Double.toString(y);
                txtAnswer.setText(txty);
            }
            else { if (a == 0 && b == 0) {txtAnswer.setText("А и В не длжны одновременно равняться нулю");}
            else{
                y = (x+4)/(Math.pow(2,a)+Math.pow(2,b));
                String txty = Double.toString(y);
                txtAnswer.setText(txty);
                }
            }
        });

        btOut.setOnMouseClicked(mouseEvent -> {
          
            Platform.exit();
        });
    }
}

