package com.cewit.healthcarescreening;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class SecondaryController implements Initializable{
    
    @FXML
    private ListView<Screening> screeningName = new ListView<>();
    private ObservableList<Screening> screenings;
    private ArrayList<Screening>  screeningList = new ArrayList<>();
    public static Patient pat = new Patient();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setListView();
    }
    public void setListView() {
        //String target = locations.getValue();
        screenings = (ObservableList<Screening>) screeningName.getItems();
        screenings.clear();
        
        queryForScreening("Neighborhood","");
        
        for(Screening curr : screeningList){
            screenings.add(curr);
        }
        screeningList.clear();
    }

    public void queryForScreening(String field, String target) {
        try {
            CollectionReference screenTable = App.fstore.collection("Screenings");
            Query query = screenTable.whereEqualTo(field, target);
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                Screening screening = new Screening();
                //criminal.fillCriminalInfo(document);
                screeningList.add(screening);
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}