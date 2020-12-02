package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private TextField PlayerScore;

    @FXML
    private ImageView PlayerImage;

    @FXML
    private Button Sten;

    @FXML
    private Button Saks;

    @FXML
    private Button Papir;

    @FXML
    private TextField ComputerScore;

    @FXML
    private ImageView ComputerImage;

    @FXML
    private Label LabelForSAndL;




    public void save()throws  FileNotFoundException {

        java.io.File file = new java.io.File("data/saveFile.txt");
        try{
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            output.print(plaScore + " ");
            output.print(comScore + " ");
            output.print(playerPick + " ");
            output.print(comValg);
            output.close();
            System.out.println("The file has been saved");
            LabelForSAndL.setText("Saved");
        }catch (Exception e ){
            System.out.println("Filen blev ikke gemt");
        }
    }

    public void load() throws FileNotFoundException {
        java.io.File file = new java.io.File("data/saveFile.txt");
        try{
            Scanner input = new Scanner(file);
                plaScore = input.nextInt();
                comScore = input.nextInt();
                playerPick = input.nextInt();
                comValg = input.nextInt();
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));
            if(playerPick == 1 ){
                PlayerImage.setImage(sten);
            }else if (playerPick == 2 ){
                PlayerImage.setImage(saks);
            }else if (playerPick == 3 ){
                PlayerImage.setImage(papir);
            }
            if(comValg == 1 ){
                ComputerImage.setImage(sten);
            }else if (comValg == 2 ){
                ComputerImage.setImage(saks);
            }else if (comValg == 3 ){
                ComputerImage.setImage(papir);
            }

            input.close();
            LabelForSAndL.setText("Loaded");
        }catch (Exception e ){
            System.out.println("The file was not loaded");
        }
    }



    int comScore;
    int plaScore;
    int playerPick;
    int comValg;
    Image sten = new Image("/image/rock.png");
    Image saks = new Image("/image/scissors.png");
    Image papir = new Image("/image/paper.png");

    public void updateScore(int playerPick, int comPick) {
        System.out.println("The player chose  " + playerPick);
        System.out.println("The computer chose  " + comPick);

        // Player Picks Rock
        if (comPick == 1 && playerPick == 1) {
            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));
            // Set picture.
            PlayerImage.setImage(sten);
            ComputerImage.setImage(sten);

        } else if (comPick == 2 && playerPick == 1) {

            // Adds a point to the player.
            this.plaScore = plaScore + 1;

            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            // set picture
            PlayerImage.setImage(sten);
            ComputerImage.setImage(saks);

        } else if (comPick == 3 && playerPick == 1) {
            // Adds a point to the computer
            this.comScore = comScore + 1;


            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            //set picture.
            PlayerImage.setImage(sten);
            ComputerImage.setImage(papir);

            // Player Picks Scissor
        } else if (comPick == 1 && playerPick == 2) {
            // adds a point to the cmoputer
            this.comScore = comScore + 1;


            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(saks);
            ComputerImage.setImage(sten);

        } else if (comPick == 2 && playerPick == 2) {
            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(saks);
            ComputerImage.setImage(saks);

        } else if (comPick == 3 && playerPick == 2) {
            // Adds a point to the player.
            this.plaScore = plaScore + 1;

            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(saks);
            ComputerImage.setImage(papir);


            // Player picks paper
        } else if (comPick == 1 && playerPick == 3) {
            // Adds a point to the player.
            this.plaScore = plaScore + 1;


            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(papir);
            ComputerImage.setImage(sten);

        } else if (comPick == 2 && playerPick == 3) {
            // adds a point to the computer.
            this.comScore = comScore + 1;


            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(papir);
            ComputerImage.setImage(saks);

        } else if (comPick == 3 && playerPick == 3) {
            // Sets the text on screne to match the score.
            PlayerScore.setText(String.valueOf(this.plaScore));
            ComputerScore.setText(String.valueOf(this.comScore));

            PlayerImage.setImage(papir);
            ComputerImage.setImage(papir);
        }
    }


    //Pc picks it role
    public int pcValg() {
        return (int) ((Math.random() * 3) + 1);
    }

    // Player chose stone
    public void sten() {
        this.playerPick = 1;
        this.comValg = pcValg();
        updateScore(playerPick, comValg);
    }

    // Player chose scissor
    public void saks() {
        this.playerPick = 2;
        this.comValg = pcValg();
        updateScore(playerPick, comValg);
    }

    // Player chose paper
    public void papir() {
        this.playerPick = 3;
        this.comValg = pcValg();
        updateScore(playerPick, comValg);
    }

}