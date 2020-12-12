import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GamePane extends Pane {

    Label firstPlayerName = new Label();
    Label secondPlayerName = new Label();
    Label firstPlayerScore = new Label("0");
    Label secondPlayerScore = new Label("0");
    Label currentPlayerSymbol = new Label();
    GridPane boardPane = new GridPane();
    Button[] boardButtons = new Button[3*3];
    Button back = new Button("Retour");
    Button newGame = new Button("Nouvelle");
    ImageView boardBackground = new ImageView();

    boolean isGameEnds;
    
    boolean isFirstPlayerTurn = true;
    
    int XOCounter = 0;
    
    Random random = new Random();
    int randomNumber;
    
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;

    
    EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
        actionPerformed(e);
    };

    
    private void colorBackgroundWinnerButtons(Button b1, Button b2, Button b3)
    {
        b1.setStyle("-fx-background-color: yellow;");
        b2.setStyle("-fx-background-color: yellow;");
        b3.setStyle("-fx-background-color: yellow;");
    }
    
    
    private void createGameBoard() {
        
        int row = 0;
        int column = 0;
        
        for (int i = 0; i < boardButtons.length; i++) {

            boardButtons[i] = new Button();

            boardButtons[i].setPrefSize(90, 90);
            boardButtons[i].setFocusTraversable(false);

            GridPane.setMargin(boardButtons[i], new Insets(5));
            boardButtons[i].setFont(Font.font("Arial", FontWeight.BOLD, 40));

            boardPane.add(boardButtons[i], column, row);

            boardButtons[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
                
            column++;
            if(column == 3)
            {
                row++;
                column = 0;
            }
        }
        
    }

    private void checkIfGameEnds() {
            
        String t00 = boardButtons[0].getText();
        String t01 = boardButtons[1].getText();
        String t02 = boardButtons[2].getText();
        String t10 = boardButtons[3].getText();
        String t11 = boardButtons[4].getText();
        String t12 = boardButtons[5].getText();
        String t20=  boardButtons[6].getText();
        String t21 = boardButtons[7].getText();
        String t22 = boardButtons[8].getText();
  
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[1], boardButtons[2]);
        }
 
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[3], boardButtons[4], boardButtons[5]);
        }
 
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[6], boardButtons[7], boardButtons[8]);
        }
 
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[3], boardButtons[6]);
        }
 
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[1], boardButtons[4], boardButtons[7]);
        }
 
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[2], boardButtons[5], boardButtons[8]);
        }
 
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[0], boardButtons[4], boardButtons[8]);
        }
 
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinnerButtons(boardButtons[2], boardButtons[4], boardButtons[6]);
        }
        
        if( XOCounter >= 9)
        {
            isGameEnds = true;
            isFirstPlayerTurn = true;
            XOCounter = 0;
        }
        
        if(isGameEnds == true)
        {
            if(isFirstPlayerTurn)
                firstPlayerScore.setText(Integer.valueOf(firstPlayerScore.getText()) + 1 + "");
    
            else
                secondPlayerScore.setText(Integer.valueOf(secondPlayerScore.getText()) + 1 + "");

            XOCounter = 0;
            newGame.requestFocus();
        }
        
    }
    
    private void startNewGame() {

        isGameEnds = false;
        setCurrentPlayerSymbol();

        for (Button boardButton : boardButtons) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");
        }

    }


    private void setCurrentPlayerSymbol() {
        
        if (isFirstPlayerTurn == true) {
            currentPlayerSymbol.setText("X");
            currentPlayerSymbol.setTextFill(xForeground);
        } else {
            currentPlayerSymbol.setText("O");
            currentPlayerSymbol.setTextFill(oForeground);
        }
        
    }

    
    private void actionPerformed(ActionEvent e)
    {
        Button clickedButton = (Button) e.getSource();
        
        if( isGameEnds == false && clickedButton.getText().equals("") )
        {
            if(AppManager.challengeComputer == false)
            {
                if(isFirstPlayerTurn) {
                    clickedButton.setTextFill(xForeground);
                    clickedButton.setText("X");
                }
                else {
                    clickedButton.setTextFill(oForeground);
                    clickedButton.setText("O");
                }
                
                checkIfGameEnds();
                setCurrentPlayerSymbol();
                isFirstPlayerTurn = !isFirstPlayerTurn;
                setCurrentPlayerSymbol();
            }
    
            if (AppManager.challengeComputer == true)
            {
                XOCounter++;
                isFirstPlayerTurn = true;
                clickedButton.setTextFill(xForeground);
                clickedButton.setText("X");
                checkIfGameEnds();
                
                if(isGameEnds == false)
                {
                    for (Button boardButton : boardButtons) {
                        boardButton.removeEventHandler(ActionEvent.ACTION, eventHandler);
                    }
                    
                    XOCounter++;
                    isFirstPlayerTurn = false;
                    for (;;) {
                        randomNumber = random.nextInt(9);
                        if (boardButtons[randomNumber].getText().equals(""))
                        {
                            boardButtons[randomNumber].setTextFill(oForeground);
                            boardButtons[randomNumber].setText("O");
                            break;
                        }
                    }
                    checkIfGameEnds();
                    
                    for (Button boardButton : boardButtons) {
                        boardButton.addEventHandler(ActionEvent.ACTION, eventHandler);
                    }
                }
            }
    
        } 
    }
    
    public GamePane() {
        
        firstPlayerName.setPrefSize(150, 30);
        secondPlayerName.setPrefSize(150, 30);
        firstPlayerScore.setPrefSize(150, 30);
        secondPlayerScore.setPrefSize(150, 30);
        currentPlayerSymbol.setPrefSize(150, 30);
        boardPane.setPrefSize(300, 300);
        newGame.setPrefSize(140, 30);

        firstPlayerName.setTranslateY(10);
        secondPlayerName.setTranslateX(250);
        secondPlayerName.setTranslateY(10);
        firstPlayerScore.setTranslateY(40);
        secondPlayerScore.setTranslateX(250);
        secondPlayerScore.setTranslateY(40);
        currentPlayerSymbol.setTranslateX(120);
        currentPlayerSymbol.setTranslateY(25);
        boardBackground.setFitWidth(300);
        boardBackground.setFitHeight(300);
        boardBackground.setTranslateX(45);
        boardBackground.setTranslateY(105);
        boardPane.setTranslateX(45);
        boardPane.setTranslateY(105);
        back.setPrefSize(140, 30);
        back.setTranslateX(20);
        back.setTranslateY(455);
        newGame.setTranslateX(230);
        newGame.setTranslateY(455);
        
        firstPlayerName.setAlignment(Pos.CENTER);
        secondPlayerName.setAlignment(Pos.CENTER);
        firstPlayerScore.setAlignment(Pos.CENTER);
        secondPlayerScore.setAlignment(Pos.CENTER);
        currentPlayerSymbol.setAlignment(Pos.CENTER);

        createGameBoard();
        
        getChildren().add(firstPlayerName);
        getChildren().add(secondPlayerName);
        getChildren().add(firstPlayerScore);
        getChildren().add(secondPlayerScore);
        getChildren().add(currentPlayerSymbol);
        getChildren().add(boardPane);
        getChildren().add(boardBackground);
        getChildren().add(back);
        getChildren().add(newGame);

        startNewGame();
        
        back.setOnAction((Action) -> {

            startNewGame();
            
            if (AppManager.challengeComputer)
                AppManager.viewPane(AppManager.singlePlayerPane);
            
            else
                AppManager.viewPane(AppManager.multiPlayerPane);
            
        });

        newGame.setOnAction((Action) -> {
            startNewGame();
        });

    }

}
