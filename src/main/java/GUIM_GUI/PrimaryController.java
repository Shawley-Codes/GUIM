package GUIM_GUI;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {


    @javafx.fxml.FXML
    private ListView Spreadsheet;
    @javafx.fxml.FXML
    private MenuItem MI_FileSA;
    @javafx.fxml.FXML
    private MenuItem MI_FileN;
    @javafx.fxml.FXML
    private MenuButton AddButton;
    @javafx.fxml.FXML
    private MenuItem MI_AddItem;
    @javafx.fxml.FXML
    private MenuItem MI_FileS;
    @javafx.fxml.FXML
    private MenuItem MI_RemoveItem;
    @javafx.fxml.FXML
    private MenuButton FileButton;
    @javafx.fxml.FXML
    private MenuItem MI_AddNotify;
    @javafx.fxml.FXML
    private MenuButton RemoveButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Load current database from local memory when opening menu
    }

    @javafx.fxml.FXML
    public void fileSave(ActionEvent actionEvent) {
        //call to save database
    }

    @javafx.fxml.FXML
    public void fileSaveAs(ActionEvent actionEvent) {
        //call to save database under new local name
    }

    String getText(TextField field){
        if(field.getText().isEmpty()) {
            return "";
        } else {
            return field.getText();
        }
    }

    //attempts to parse string
    int parsetoInt(String textvalue){
        System.out.println(textvalue);
        try{
            return Integer.parseInt(textvalue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Data");
        }
        //returning number impossible for random to generate if parse fails
        return -1;
    }

    @javafx.fxml.FXML
    public void removeItemMenu(ActionEvent actionEvent) {
        //create item menu meant for removing items from database
        //create stage
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Remove Items");

        //create GUI elements
        Label catL = new Label();
        catL.setText("Catagory");

        TextField CatTF = new TextField();
        CatTF.setPromptText("Catagory: ");

        Label itemL = new Label();
        itemL.setText("Ammount to Remove");

        TextField ItemTF = new TextField();
        ItemTF.setPromptText("Number of Items: ");

        Button acceptButton = new Button("Remove");
        acceptButton.setOnAction(
                e -> removeItems(getText(CatTF), getText(ItemTF), dialog)
        );

        Button closeButton = new Button("Exit");
        closeButton.setOnAction(e -> dialog.close());

        //create layout structure
        VBox layout = new VBox(10);
        layout.getChildren().addAll(catL, CatTF, itemL, ItemTF, acceptButton, closeButton);
        layout.setAlignment(Pos.CENTER);

        //set scene
        Scene scene = new Scene(layout, 350, 300);
        dialog.setScene(scene);
        dialog.show();
    }
    public void removeItems(String Catagory, String Ammount, Stage dialog){
        //calls from removeItemMenu
        dialog.close();

        //use data to remove items, if no items is to be removed open dialog box stating error
        System.out.println(Catagory);
        int amm = parsetoInt(Ammount);
        System.out.println(amm);

        if (!checkSpreadsheet(Catagory)) {
            createErrorBox("Error Removing Items");
        }
    }
    public boolean checkSpreadsheet(String Catagory){
        for(int i = 0; i < Spreadsheet.getItems().size(); i++) {
            Object item = Spreadsheet.getItems().get(i);
            //get category value from item
            //then compare
            if (Catagory == item.toString()) {
                return true;
            }
        }
        return false;
    }
    public void createErrorBox(String ErrorMessage){
        //create stage
        Stage errdialog = new Stage();
        errdialog.initModality(Modality.APPLICATION_MODAL);
        errdialog.setTitle("Error");

        //create GUI elements
        Label label = new Label();
        label.setText(ErrorMessage);

        Button closeButton = new Button("Exit");
        closeButton.setOnAction(e -> errdialog.close());

        //create layout structure
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //set scene
        Scene scene = new Scene(layout, 250, 150);
        errdialog.setScene(scene);
        errdialog.show();
    }


    @javafx.fxml.FXML
    public void addNotifyMenu(ActionEvent actionEvent) {
        //create item menu meant for adding items from database
        //create stage
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add Notification");

        //create GUI elements
        Label NRL = new Label();
        NRL.setText("Notification Reason");

        TextField RTF = new TextField();
        RTF.setPromptText("Reason: ");

        Label dateL = new Label();
        dateL.setText("Date of Notification");

        TextField DateTF = new TextField();
        DateTF.setPromptText("9/25/2024, 4pm");

        Button acceptButton = new Button("Create");
        acceptButton.setOnAction(
                e -> addNotofication(getText(RTF), getText(DateTF), dialog)
        );

        Button closeButton = new Button("Exit");
        closeButton.setOnAction(e -> dialog.close());

        //create layout structure
        VBox layout = new VBox(10);
        layout.getChildren().addAll(NRL, RTF, dateL, DateTF, acceptButton, closeButton);
        layout.setAlignment(Pos.CENTER);

        //set scene
        Scene scene = new Scene(layout, 350, 300);
        dialog.setScene(scene);
        dialog.show();
    }
    public void addNotofication(String Reason, String date, Stage dialog){
        dialog.close();
        Date notificationDate = parseDate(date);

    }
    Date parseDate(String dateText){
        Date date = new Date();
        return date;
    }


    @javafx.fxml.FXML
    public void addItemMenu(ActionEvent actionEvent) {
        //create item menu meant for adding items from database
        //create stage
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add Items");

        //create GUI elements
        Label catL = new Label();
        catL.setText("Catagory");

        TextField CatTF = new TextField();
        CatTF.setPromptText("Catagory: ");

        Label nameL = new Label();
        nameL.setText("Item Name(s)");

        TextField NameTF = new TextField();
        NameTF.setPromptText("Name of Item(s): ");

        Label itemL = new Label();
        itemL.setText("Quantity");

        TextField ItemTF = new TextField();
        ItemTF.setPromptText("Number of Items: ");

        Button acceptButton = new Button("Add");
        acceptButton.setOnAction(
                e -> addItems(getText(CatTF), getText(ItemTF), getText(NameTF), dialog)
        );

        Button closeButton = new Button("Exit");
        closeButton.setOnAction(e -> dialog.close());

        //create layout structure
        VBox layout = new VBox(10);
        layout.getChildren().addAll(catL, CatTF, nameL, NameTF, itemL, ItemTF, acceptButton, closeButton);
        layout.setAlignment(Pos.CENTER);

        //set scene
        Scene scene = new Scene(layout, 350, 300);
        dialog.setScene(scene);
        dialog.show();
    }
    public void addItems(String Catagory, String Ammount, String Name, Stage dialog){
        dialog.close();

        //add items to the ui
        createErrorBox("Error Adding Items");
    }

    @javafx.fxml.FXML
    public void fileNew(ActionEvent actionEvent) {
    }

    public void sortList(){
        //  Spreadsheet.getItems().sort(c.Catagory);
    }


}
