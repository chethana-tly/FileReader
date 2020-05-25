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
import java.util.ResourceBundle;
import java.util.Scanner;
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
        
        radiobutton1.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                String name = radiobutton1.getText();
                textarea.clear();
                
                try {
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String name = radiobutton2.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String name = radiobutton3.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String name = radiobutton4.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String name = radiobutton5.getText();
                textarea.clear();
                try {
                    String content = "";
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String name = radiobutton6.getText();
                textarea.clear();
                try {
                    String content = "";
                    
                    File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + name);
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
                String selectedFile = selectedRadioButton.getText();
                
                String content = "";
                File myObj = new File("C:\\Chi\\Projects\\CSV_Reader\\src\\csv_reader\\" + selectedFile);
                
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
    
}
