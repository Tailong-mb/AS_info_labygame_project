module com.labygame.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.jetbrains.annotations;
    requires com.google.gson;
    requires org.junit.jupiter.api;

    opens com.labygame.demo to javafx.fxml;
    exports com.labygame.demo;
    exports com.labygame.demo.scenes;
    opens com.labygame.demo.scenes to javafx.fxml;
}