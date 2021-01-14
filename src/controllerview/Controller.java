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
        found = arrayToObservablelist(carDatabase.search(search_txt.getText(), true));
        if(found.contains(null))
        {
            error_msg.setText("Vehicle not found!");
            error_msg.setVisible(true);
        }
        else
        {
            error_msg.setVisible(false);
            vehicle_list.setItems(FXCollections.observableList(found));
        }
    }

    public void search()
    {
        found = arrayToObservablelist(carDatabase.search(search_txt.getText(), false));
        if(found.contains(null))
        {
            error_msg.setText("Vehicle not found!");
            error_msg.setVisible(true);
        }
        else
        {
            error_msg.setVisible(false);
            vehicle_list.setItems(FXCollections.observableList(found));
        }
    }

    public ObservableList<Vehicle> arrayToObservablelist(Vehicle[] array)
    {
        ArrayList<Vehicle> list = new ArrayList<>();
        for (int c = 0; c < array.length; c++)
        {
            list.add(array[c]);
        }
        return FXCollections.observableList(list);
    }


}
