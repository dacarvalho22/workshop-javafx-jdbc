package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepart;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartAction() {
		System.out.println("onMenuItemDepartAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
		
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rs) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadView(String nameURL) {
		try {
			// Carregar a TELA
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nameURL));
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
									// ScrollPane -> Refere-se ao FXML da 'MainView.fxml'
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());			
		}catch(IOException e) {
			Alerts.showAlert("IOException.", "Erro leitura view", e.getMessage(), AlertType.ERROR);
		}
	}

}
