package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.pojo.User;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.TableColumn;

import static javafx.collections.FXCollections.*;

public class Controller {

    private ObservableList<User> usersData = observableArrayList();

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, Integer> c1Column;

    @FXML
    private TableColumn<User, Integer> c2Column;

    @FXML
    private TableColumn<User, Integer> c3Column;

    @FXML
    private TableColumn<User, Integer> c4Column;

    @FXML
    private TableColumn<User, Integer> c5Column;

    @FXML
    private Button btnR;

    @FXML
    private Button btnM;

    @FXML
    private TextField txtmn;

    @FXML
    private TextField txtmx;

    // инициализируем форму данными
    @FXML
    private void initialize() {
        //initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        c1Column.setCellValueFactory(new PropertyValueFactory<User, Integer>("c1"));
        c2Column.setCellValueFactory(new PropertyValueFactory<User, Integer>("c2"));
       c3Column.setCellValueFactory(new PropertyValueFactory<User, Integer>("c3"));
        c4Column.setCellValueFactory(new PropertyValueFactory<User, Integer>("c4"));
        c5Column.setCellValueFactory(new PropertyValueFactory<User, Integer>("c5"));



        btnR.setOnMouseClicked(mouseEvent -> {
            massmake();
        });

        btnM.setOnMouseClicked(mouseEvent -> {
            zadanie();
            initData();
        });

        // заполняем таблицу данными
        tableUsers.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        usersData.clear();
        usersData.add(new User(nums[0][0], nums[0][1], nums[0][2], nums[0][3],nums[0][4]));
        usersData.add(new User(nums[1][0], nums[1][1], nums[1][2], nums[1][3],nums[1][4]));
        usersData.add(new User(nums[2][0], nums[2][1], nums[2][2], nums[2][3],nums[2][4]));
        usersData.add(new User(nums[3][0], nums[3][1], nums[3][2], nums[3][3],nums[3][4]));
        usersData.add(new User(nums[4][0], nums[4][1], nums[4][2], nums[4][3],nums[4][4]));
    }
    
    int nums[][] = new int[5][5];
    int max=-1000, min = 1000;
    private void massmake(){

        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                nums[i][j]= (int)(Math.random()*2500-500);
            }
        }

        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (min > nums[i][j]){min = nums[i][j];}
                if (max < nums[i][j]){max = nums[i][j];}
            }
        }
        txtmn.setText(Integer.toString(min));
        txtmx.setText(Integer.toString(max));
        usersData.clear();
        usersData.add(new User(nums[0][0], nums[0][1], nums[0][2], nums[0][3],nums[0][4]));
        usersData.add(new User(nums[1][0], nums[1][1], nums[1][2], nums[1][3],nums[1][4]));
        usersData.add(new User(nums[2][0], nums[2][1], nums[2][2], nums[2][3],nums[2][4]));
        usersData.add(new User(nums[3][0], nums[3][1], nums[3][2], nums[3][3],nums[3][4]));
        usersData.add(new User(nums[4][0], nums[4][1], nums[4][2], nums[4][3],nums[4][4]));

    }
    private  void zadanie(){
        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (10*min <= max){
                    if (nums[i][j] == 0) {
                        nums[i][j] = 1;
                    }
                    if (nums[i][j] < 0) {
                        nums[i][j] = Math.abs(nums[i][j]);
                    }
                }

            }
        }

    }

}
