module com.example.bouncingballjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bouncingballjavafx to javafx.fxml;
    exports com.example.bouncingballjavafx;
}