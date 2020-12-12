import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class AppManager {
    
    static StartPane startPane = new StartPane();
    static SinglePlayerPane singlePlayerPane = new SinglePlayerPane();
    static MultiPlayerPane multiPlayerPane = new MultiPlayerPane();
    static SettingsPane settingsPane = new SettingsPane();
    static GamePane gamePane = new GamePane();
    
    static String preferredBoard;

    static Font preferredFont;
    
    static boolean challengeComputer;
    
    public static void viewPane(Pane pane)
    {
        startPane.setVisible(false);
        singlePlayerPane.setVisible(false);
        multiPlayerPane.setVisible(false);
        settingsPane.setVisible(false);
        gamePane.setVisible(false);
        
        pane.setVisible(true);
    }
    
    public static void setDefaultSettings()
    {
        settingsPane.boardsComboBox.getSelectionModel().selectFirst();
        settingsPane.fontSizesComboBox.getSelectionModel().select(1);
        
        setFont();
    }

    public static void setFont()
    {
        startPane.singlePlayer.setFont(preferredFont);
        startPane.multiPlayer.setFont(preferredFont);
        startPane.exit.setFont(preferredFont);
        
        singlePlayerPane.playerNameLabel.setFont(preferredFont);
        singlePlayerPane.playerName.setFont(preferredFont);
        singlePlayerPane.start.setFont(preferredFont);
        singlePlayerPane.back.setFont(preferredFont);
        
        multiPlayerPane.playerXLabel.setFont(preferredFont);
        multiPlayerPane.playerOLabel.setFont(preferredFont);
        multiPlayerPane.firstPlayerName.setFont(preferredFont);
        multiPlayerPane.secondPlayerName.setFont(preferredFont);
        multiPlayerPane.start.setFont(preferredFont);
        multiPlayerPane.back.setFont(preferredFont);
        
        gamePane.firstPlayerName.setFont(preferredFont);
        gamePane.secondPlayerName.setFont(preferredFont);
        gamePane.firstPlayerScore.setFont(preferredFont);
        gamePane.secondPlayerScore.setFont(preferredFont);
        gamePane.currentPlayerSymbol.setFont(preferredFont);
        gamePane.newGame.setFont(preferredFont);
        gamePane.back.setFont(preferredFont);
        
        
        settingsPane.labelForBoards.setFont(preferredFont);
        settingsPane.labelForFontSizes.setFont(preferredFont);
        settingsPane.reset.setFont(preferredFont);
        settingsPane.back.setFont(preferredFont);
        
        settingsPane.boardsComboBox.setStyle(
            "-fx-font-family:" + preferredFont.getName() + ";"
           +"-fx-font-size: " + preferredFont.getSize() +"px;"
           +"-fx-font-weight: bold;"
        );
        settingsPane.fontSizesComboBox.setStyle(
            "-fx-font-family:" + preferredFont.getName() + ";"
           +"-fx-font-size: " + preferredFont.getSize() +"px;"
           +"-fx-font-weight: bold;"
        );
    }
    
}
