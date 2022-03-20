package com.labygame.front.scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class CreditsScene extends GeneralScene{

    private final Timeline creditTimer;
    private int positionCreditY = 600;
    private final Text credit = new Text("""
                Congrulations !

                Creators :
                            
                Michael Bardou
                Emilien Godfrin
                Nathalie Parisse
                
                Music :
                
                Cody O'Quinn
                
                
                Thanks for playing !
                """);

    public CreditsScene(){
        //Set the timer
        creditTimer = new Timeline(new KeyFrame(Duration.millis(50),this::doStep));
        creditTimer.setCycleCount(500);

        //Set the text decoration
        credit.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        credit.setFill(Color.BLACK);
        credit.setTranslateX(10);
    }

    @Override
    public void draw() {
        //Draw background;
        Image backgroundMenu = new Image("file:doc/images/wallpaper/mainMenu.jpg",1200,850,false,false);
        gc.drawImage(backgroundMenu,0,0);
        //Launch the animation
        creditTimer.play();
    }

    private void doStep(ActionEvent e){
        //Remove the text from the root and draw it with new Y value
        root.getChildren().remove(credit);
        credit.setTranslateY(positionCreditY);
        root.getChildren().addAll(credit);
        this.setRoot(root);
        positionCreditY -= 2;
    }
}
