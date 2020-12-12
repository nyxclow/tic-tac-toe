import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MultiPlayerPane extends Pane {

    Label playerXLabel = new Label("Joueur X");
    Label playerOLabel = new Label("JoueurO");
    TextField firstPlayerName = new TextField("Joueur 1");
    TextField secondPlayerName = new TextField("Joueur 2");
    Button start = new Button("Start");
    Button back = new Button("Retour");

    public MultiPlayerPane() {

        playerXLabel.setPrefSize(70, 30);
        firstPlayerName.setPrefSize(160, 30);
        playerOLabel.setPrefSize(70, 30);
        secondPlayerName.setPrefSize(160, 30);
        start.setPrefSize(240, 40);
        back.setPrefSize(240, 40);

        playerXLabel.setTranslateX(80);
        playerXLabel.setTranslateY(130);
        firstPlayerName.setTranslateX(160);
        firstPlayerName.setTranslateY(130);
        playerOLabel.setTranslateX(80);
        playerOLabel.setTranslateY(190);
        secondPlayerName.setTranslateX(160);
        secondPlayerName.setTranslateY(190);
        start.setTranslateX(80);
        start.setTranslateY(250);
        back.setTranslateX(80);
        back.setTranslateY(310);
        
        getChildren().add(playerXLabel);
        getChildren().add(playerOLabel);
        getChildren().add(firstPlayerName);
        getChildren().add(secondPlayerName);
        getChildren().add(start);
        getChildren().add(back);

        start.setOnAction((Action) -> {
            AppManager.gamePane.firstPlayerName.setText(firstPlayerName.getText());
            AppManager.gamePane.secondPlayerName.setText(secondPlayerName.getText());
            AppManager.gamePane.firstPlayerScore.setText("0");
            AppManager.gamePane.secondPlayerScore.setText("0");

            AppManager.challengeComputer = false;
            
            AppManager.gamePane.boardBackground
                    .setImage(new Image(getClass().getResourceAsStream("/images/"+AppManager.preferredBoard)));
            
            AppManager.viewPane(AppManager.gamePane);
        });
        
        back.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.startPane);
        });
    }
    
}
