module com.example.javaoopproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaoopproject to javafx.fxml;
    exports com.example.javaoopproject;
}