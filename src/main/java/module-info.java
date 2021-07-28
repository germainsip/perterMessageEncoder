module peterMessageEncoder {

    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires org.apache.commons.lang3;

    opens org.petersix.GUI to javafx.fxml;
    exports org.petersix;
}