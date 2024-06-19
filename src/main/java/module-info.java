module com.example.java2dgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.java2dgame.main to javafx.fxml;
    exports com.example.java2dgame.main;

}