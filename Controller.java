package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView ImgField;

    @FXML
    /*void initialize() {
        
        ImgField.setOnMouseClicked(event -> { 
            System.out.println("Вы нажали на изображение");
        });

    }*/
    void initialize() { // Отслеживаем нажатие на кнопку
        ImgField.setOnMouseClicked(event -> {
                    // Делаем объект неактивным
            ImgField.setVisible(false);
        });
    }
}
