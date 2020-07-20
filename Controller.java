package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import sample.pojo.Forma;

public class Controller {

    private ObservableList<Forma> FormData = FXCollections.observableArrayList();

    private double a, b;
    @FXML
    private TableView<Forma> Table;

    @FXML
    private TableColumn<Forma, Double> Col1;

    @FXML
    private TableColumn<Forma, Double> Col2;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private Button btnFill;

    @FXML
    private Button btnMake;

    @FXML
    private Button btnClean;

    @FXML
    private Button btnOut;

    @FXML
    void initialize() {
        btnFill.setOnMouseClicked(mouseEvent -> {
        Sluchainie();
        });
        btnClean.setOnMouseClicked(mouseEvent -> {
            FormData.clear();
            txtA.setText("");
            txtB.setText("");
            a=b=0;
        });
        btnOut.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
        btnMake.setOnMouseClicked(mouseEvent -> {
            initData();
        });

        Col1.setCellValueFactory(new PropertyValueFactory<Forma, Double>("K"));
        Col2.setCellValueFactory(new PropertyValueFactory<Forma, Double>("Y"));
        // заполняем таблицу данными
        Table.setItems(FormData);
    }

    private  void Sluchainie(){
        a = Math.random()*10-2;
        b = Math.random()*10-2;
        txtA.setText(Double.toString(a));
        txtB.setText(Double.toString(b));
    }
    private void initData() {

        FormData.clear();
        double k[] = new double[10];
        double y[] = new double[10];
        k[0] = 41.47342406523438;
        k[1] = 64.39332215245058;
        k[2] = 58.03188961218958;
        k[3] = 25.96451934393319;
        k[4] = 0.8103377551977098;
        k[5] = 96.68551565619254;
        k[6] = 74.19499719982521;
        k[7] = 58.00501336998136;
        k[8] = 59.27504691317262;
        k[9] = 18.976353605592976;
        FormData.add(new Forma(k[0], y[0]));
        double sum = 0;
        for (int i=1; i<10; i++){
            sum += k[i-1];
            y[i] = Math.sqrt(Math.pow(2,Math.cos(k[i]))/((Math.pow(2,a)+Math.pow(2,b))- Math.sin(k[i])))*sum;
            FormData.add(new Forma(k[i], y[i]));
        }

    }

}

