package de.htwk.aop.fantasy.gui;

import java.util.ArrayList;

import de.htwk.aop.fantasy.service.Market;
import de.htwk.aop.fantasy.service.entities.Trader;
import de.htwk.aop.fantasy.service.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MarketMenu {
	private Market market;

	public MarketMenu(Market market) {
		this.market = market;
	}

	public void showAllTraders(Stage primaryStage) {
		showSpecificTrader(primaryStage,market.getSmith());
	
	}

	public void showSpecificTrader(Stage primaryStage, Trader<? extends Item> trader) {
		ObservableList<Item> items = FXCollections.observableArrayList(trader.getItems());
		final Scene scene = new Scene(new Group(), 520, 570);
		final Stage neuesWindow2 = new Stage();

		neuesWindow2.setTitle(trader.getName());
		neuesWindow2.initModality(Modality.WINDOW_MODAL);
		neuesWindow2.initOwner(primaryStage);
		neuesWindow2.setX(primaryStage.getX() + 400);
		neuesWindow2.setY(primaryStage.getY() + 10);

		final Label label;
		label = new Label("Handelswaren");
		label.setFont(new Font("Arial", 14));
		final TableView<Item> table = new TableView<>();
		table.setEditable(true);
		table.prefWidthProperty().bind(neuesWindow2.widthProperty().multiply(0.92));

		final TableColumn<Item, String> typSpalte = new TableColumn<>("Typ");
		final TableColumn<Item, String> descSpalte = new TableColumn<>("Beschreibung");
		final TableColumn<Item, String> priceSpalte = new TableColumn<>("Preis");
		final TableColumn<Item, String> idSpalte = new TableColumn<>("ID");


		typSpalte.setCellValueFactory(new PropertyValueFactory<Item, String>("typ"));
		descSpalte.setCellValueFactory(new PropertyValueFactory<Item, String>("desc"));
		priceSpalte.setCellValueFactory(new PropertyValueFactory<Item, String>("price"));
		idSpalte.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
		

		table.setItems(items);
		table.getColumns().addAll(typSpalte, descSpalte, priceSpalte, idSpalte);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		Button switchToSchmied = new Button("Schmied");
		Button switchToJeweler = new Button("Juwelier");
		Button switchToBookstore = new Button("Buchladen");
		Button backToGameMenu = new Button("Zurück");
		
		
		switchToSchmied.setOnAction((ActionEvent actionEvent) -> {
			neuesWindow2.close();
			showSpecificTrader(primaryStage, market.getSmith());
		});
		
		switchToJeweler.setOnAction((ActionEvent actionEvent) -> {
			neuesWindow2.close();
			showSpecificTrader(primaryStage, market.getJeweler());
		});
		
		switchToBookstore.setOnAction((ActionEvent actionEvent) -> {
			neuesWindow2.close();
			showSpecificTrader(primaryStage, market.getBookstore());
		});
		
		switchToBookstore.setOnAction((ActionEvent actionEvent) -> {
			neuesWindow2.close();
			showSpecificTrader(primaryStage, market.getBookstore());
		});
		
		backToGameMenu.setOnAction(actionEvent -> neuesWindow2.close());
		
		
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.getChildren().addAll(label, table, switchToSchmied, switchToJeweler, switchToBookstore, backToGameMenu);
		

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		neuesWindow2.setScene(scene);
		neuesWindow2.show();
	}
}
