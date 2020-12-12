import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartPane extends Pane {

    Button singlePlayer = new Button("Un Joueur");
    Button multiPlayer = new Button("Deux Joueurs");
    Button exit = new Button("Quitter");

    Alert alert = new Alert(AlertType.INFORMATION);

    public StartPane() {

        singlePlayer.setPrefSize(240, 40);
        multiPlayer.setPrefSize(240, 40);
        exit.setPrefSize(240, 40);

        singlePlayer.setTranslateX(80);
        singlePlayer.setTranslateY(170);
        multiPlayer.setTranslateX(80);
        multiPlayer.setTranslateY(230);
        exit.setTranslateX(80);
        exit.setTranslateY(290);

        getChildren().add(singlePlayer);
        getChildren().add(multiPlayer);
        getChildren().add(exit);

        singlePlayer.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.singlePlayerPane);
        });

        multiPlayer.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.multiPlayerPane);
        });

        exit.setOnAction((Action) -> {
            System.exit(0);
        });
    }

}
