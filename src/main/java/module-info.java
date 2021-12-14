module at.acfhcampus.stud.team_garbagecan {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.datatransfer;
    requires java.desktop;

    opens at.acfhcampus.stud.team_garbagecan to javafx.fxml;
    exports at.acfhcampus.stud.team_garbagecan;
}