package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController {

    @FXML
    private Button btnBubbleSort;

    @FXML
    private Button btnHeapSort;

    @FXML
    private Button btnShellSort;
    
    @FXML 
    void menuAbout(ActionEvent event) {
    	   try {
    	        FXMLLoader fxmlLoader = new FXMLLoader();
    	        fxmlLoader.setLocation(getClass().getResource("/application/About.fxml"));
    	        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
    	        Stage newstage = new Stage();
    	        newstage.setTitle("Info");
    	        newstage.setScene(scene);
    	        newstage.show();
    	    } catch (IOException e) {
    	    	e.printStackTrace();
    	    }
    }
    
    @FXML 
    void menuExit(ActionEvent e) {
    	Stage stage = (Stage) btnBubbleSort.getScene().getWindow();
    	int i = JOptionPane.showConfirmDialog(null, "Do you really want to exit?","EXIT",JOptionPane.YES_NO_OPTION);
    	if (i == 0) {
    		stage.close();
    	}
    }
    

    @FXML
    void bubbleSortScreen(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnBubbleSort.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/bubbleSort.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Bubble Sort");
		stage.setScene(scene);
    }

    @FXML
    void shellSortScreen(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnShellSort.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/shellSort.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Shell Sort");
		stage.setScene(scene);
    }

    @FXML
    void heapSortScreen(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHeapSort.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/heapSort.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Heap Sort");
		stage.setScene(scene);
    }

}
