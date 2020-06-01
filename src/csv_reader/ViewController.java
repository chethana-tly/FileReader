/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author
 */
public class ViewController implements Initializable {

    @FXML
    public TextArea textarea;
    @FXML
    public RadioButton radiobutton1;
    @FXML
    public RadioButton radiobutton2;
    @FXML
    public RadioButton radiobutton3;
    @FXML
    public RadioButton radiobutton4;
    @FXML
    public RadioButton radiobutton5;
    @FXML
    public RadioButton radiobutton6;
    @FXML
    public Button update;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup group = new ToggleGroup();
        radiobutton1.setToggleGroup(group);
        radiobutton2.setToggleGroup(group);
        radiobutton3.setToggleGroup(group);
        radiobutton4.setToggleGroup(group);
        radiobutton5.setToggleGroup(group);
        radiobutton6.setToggleGroup(group);
        ArrayList filenames = new ArrayList();
        

        String path = "./ReadMe";

        File folder = new File(path);
        System.out.println("PWD:" + folder);

        File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                filenames.add(listOfFile.getName());
            }
        }
        if(filenames.size()>4){
        this.radiobutton1.setText(filenames.get(0).toString());
        this.radiobutton2.setText(filenames.get(1).toString());
        this.radiobutton3.setText(filenames.get(2).toString());
        this.radiobutton4.setText(filenames.get(3).toString());
        this.radiobutton5.setText(filenames.get(4).toString());
        this.radiobutton6.setText(filenames.get(5).toString());
        }
        else{
             Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("There must be minmum 5 files in this folder");
                a.setHeaderText("Invalid");
                // show the dialog 
                a.show();
        }

        radiobutton1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton1.getText();
                textarea.clear();

                try {
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    String content = "";
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        radiobutton2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton2.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        radiobutton3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton3.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        radiobutton4.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton4.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        radiobutton5.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton5.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    textarea.setText("");
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        radiobutton6.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String name = path + "/" + radiobutton6.getText();
                textarea.clear();
                try {
                    String content = "";

                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    textarea.clear();
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        content += data + "\n";
                        textarea.setText(content);
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        });

        update.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Updating file");
                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                String selectedFile = path + "/" +selectedRadioButton.getText();

                String content = "";
                File myObj = new File(selectedFile);

                content = textarea.getText();
                writeToFile(myObj, content);
                System.out.println("Updated");
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("File updated");
                a.setHeaderText("Success");
                // show the dialog 
                a.show();

            }
        });

    }

    public void writeToFile(File file, String data) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);

            out.write(data);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    void setParameter(Application.Parameters parameters) {
            //  System.out.println("PARAMS"+parameters.getUnnamed());
    }

}
