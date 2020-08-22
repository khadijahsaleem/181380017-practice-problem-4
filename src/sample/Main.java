package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import java.awt.*;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {

    private Label titleLB , firstNameLB, lastNameLb, yearLb , dayLb , monthLb, outputLb;
    private TextField firstNameTf , lastNameTf, yearTf , monthTf , dayTf;
    private Button calculateHeartRate;
    private VBox root, yearVBox , monthVBox , dayVbox;
    private HBox dateHBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //create labels
        titleLB = new Label("Heart Rate Calculator");
        titleLB.setStyle("-fx-font : 26px  Arial");
        firstNameLB = new Label("First Name");
        lastNameLb = new Label("Last Name");
        yearLb = new Label("Year");
        monthLb = new Label("Month");
        dayLb = new Label("Day");
        outputLb = new Label();
        outputLb.setStyle("-fx-font: 24px Arial; -fx-text-fill: red;");

        //create textFields
        firstNameTf = new TextField();
        lastNameTf = new TextField();
        yearTf = new TextField();
        monthTf = new TextField();
        dayTf = new TextField();

        //create button
        calculateHeartRate = new Button("Calculate Heart Rate");

        //Button click Listner
        calculateHeartRate.setOnAction(event -> {

            int year = Integer.parseInt(yearTf.getText());
            String monthText = monthTf.getText();
            int day = Integer.parseInt(dayTf.getText());
            String fullname = firstNameTf.getText() + " " + lastNameTf.getText();
            Month month = getMonth(monthText);
            int ageInYears = getAgeInYears(year,month , day);
            double maxmimumHeartRate = getHeartRate(ageInYears);
            String targetHeartRate = getTargetHeartRate(maxmimumHeartRate);
            String result;
            result = "Name : " + fullname + "\n" + "Age : " + ageInYears + "\n" + "Maximum Heart Rate :  " + maxmimumHeartRate
                    + "\n" + "Target Heart Rate : " + targetHeartRate ;
            outputLb.setText(result);

        });

        //create vbox
        yearVBox = new VBox();
        yearVBox.getChildren().addAll(yearLb,yearTf);

        monthVBox = new VBox();
        monthVBox.getChildren().addAll(monthLb , monthTf);

        dayVbox = new VBox();
        dayVbox.getChildren().addAll(dayLb , dayTf);


        //create HBox
        dateHBox = new HBox();
        dateHBox.getChildren().addAll(yearVBox , monthVBox , dayVbox);
        dateHBox.setSpacing(20);

        //create root vbox and set
        root = new VBox();
        root.getChildren().addAll(titleLB , firstNameLB , firstNameTf , lastNameLb , lastNameTf,
                dateHBox , calculateHeartRate , outputLb);

        root.setSpacing(20);
        root.setPadding(new Insets(20));

        //Scene
        Scene scene = new Scene(root , 500 , 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.show();



    }



    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }

    private double getHeartRate(int year)
    {
        return  220 - year;
    }

    private String getTargetHeartRate(double heartRate)
    {
        return (int)(heartRate * 0.5) + " - " + (int)(heartRate * 0.85);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
