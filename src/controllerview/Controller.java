package controllerview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.CarDatabase;
import model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Simon Sperr
 * @version 2020.3, 14.01.2021
 **/
public class Controller {
    @FXML
    private TextField search_txt;
    @FXML
    private ListView vehicle_list;
    @FXML
    private Label error_msg;

    private ObservableList<Vehicle> found;

    CarDatabase carDatabase = new CarDatabase();

    public void searchBtnOnAction()
    {
        search();
    }

    public void exactBtnOnAction()
    {
        exactSearch();
    }

    public void exactSearch()
    {
        found = FXCollections.observableList(carDatabase.search(search_txt.getText(), true));
        if(found.contains(null))
        {
            error_msg.setText("Vehicle not found!");
            error_msg.setVisible(true);
        }
        else
        {
            error_msg.setVisible(false);
            vehicle_list.setItems(found);
        }
    }

    public void search()
    {
        found = FXCollections.observableList(carDatabase.search(search_txt.getText(), false));
        if(found.size() == 1 && found.contains(null))
        {
            error_msg.setText("Vehicle not found!");
            error_msg.setVisible(true);
        }
        else
        {
            error_msg.setVisible(false);
            vehicle_list.setItems(found);
        }
    }
}
