package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ShowController {

    @FXML private ListView<String[]> list;
    
    public void initialize(){
        list.setCellFactory(param -> new ListCell<>(){
            public void updateItem(String [] item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty)
                    setText(item[0] + " - " + item[1]);
                else
                    setText(null);
            }
        });
    }

    public void addData(String nameText, String receiptText) {
        String[] x = {nameText, receiptText};
        list.getItems().add(x);
    }
    
    public void Clear(){
        list.getItems().clear();
    }
}
