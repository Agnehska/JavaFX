package sample;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
public class Controller {
    @FXML
    private TextField text1;
    @FXML
    public void onClickMethod(){
        String os = System.getProperty("os.name");
        text1.setText(os);
    }
}



