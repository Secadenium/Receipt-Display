package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML TextField nameText, receiptText;
    @FXML Button enterBtn;
    @FXML Button frontClear;
    @FXML ListView<String[]> nameList;

    public void initialize(){
        nameList.setCellFactory(param -> new ListCell<>(){
            public void updateItem(String [] item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty)
                    setText(item[0] + " - " + item[1]);
                else
                    setText(null);
            }
        });
    }

    public void addData1(String nameText, String receiptText) {
        String[] x = {nameText, receiptText};
        nameList.getItems().add(x);
    }

    public void setMaster(ShowController controller2) {
        enterBtn.setOnAction(event -> {
            if(nameText.getText()!=null && receiptText.getText()!=null){
                if(!nameText.getText().equalsIgnoreCase("")&&!receiptText.getText().equalsIgnoreCase("")) {
                    controller2.addData(nameText.getText(), receiptText.getText());
                    addData1(nameText.getText(), receiptText.getText());

                    nameText.clear();
                    receiptText.clear();
                }
            }
        });

        frontClear.setOnAction(event -> controller2.Clear());
    }
}