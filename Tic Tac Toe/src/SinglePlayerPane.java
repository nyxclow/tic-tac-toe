import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SinglePlayerPane extends Pane {
    
    Label playerNameLabel = new Label("Joueur nom");
    TextField playerName = new TextField("joueur");
    Button start = new Button("Start");
    Button back = new Button("Retour");
    
    public SinglePlayerPane() {

        playerNameLabel.setPrefSize(100, 30);
        playerName.setPrefSize(130, 30);
        start.setPrefSize(240, 40);
        back.setPrefSize(240, 40);

        playerNameLabel.setTranslateX(80);
        playerNameLabel.setTranslateY(170);
        playerName.setTranslateX(190);
        playerName.setTranslateY(170);
        start.setTranslateX(80);
        start.setTranslateY(220);
        back.setTranslateX(80);
        back.setTranslateY(280);

        getChildren().add(playerNameLabel);
        getChildren().add(playerName);
        getChildren().add(start);
        getChildren().add(back);
        
      
        start.setOnAction((Action) -> {
            AppManager.gamePane.firstPlayerName.setText(playerName.getText());
            AppManager.gamePane.secondPlayerName.setText("Computer");
            AppManager.gamePane.firstPlayerScore.setText("0");
            AppManager.gamePane.secondPlayerScore.setText("0");

            AppManager.challengeComputer = true;
            
            AppManager.gamePane.boardBackground
                    .setImage(new Image(getClass().getResourceAsStream("/images/"+AppManager.preferredBoard)));
            
            AppManager.viewPane(AppManager.gamePane);
        });

        back.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.startPane);
        });
    }
    
}
