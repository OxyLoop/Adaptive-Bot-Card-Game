
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameSettings {
    private static boolean isPlayerPlay;
    private static int howManyBots;
    private static ArrayList<Bot> botLevelChoose;


    public static boolean askPlayerPlay(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Do you play ?");
            System.out.println("1-Yes");
            System.out.println("2-No");
            try {int answer = sc.nextInt(); //int alma fonksiyonu yaz
            if(answer==1){
                isPlayerPlay = true;
                break;
            } else if(answer == 2){
                isPlayerPlay = false;
                break;
            } else{
                System.out.println("You write wrong number. Please write 1 or 2");
            }
        } catch(java.util.InputMismatchException e){
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine(); 
        }

        }
        return isPlayerPlay;
    }

    public static String nameOfPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your name");
        String name = sc.nextLine();
        return name;
    }

    public static int howManyBots(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many bots will play between 1 to 3?");
        while(true) {
            try {
                howManyBots = sc.nextInt();
            if(howManyBots == 1 || howManyBots == 2 || howManyBots == 3)
                break;
            else
                System.out.println("Invalid input. Please try again.");
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
        return howManyBots;
    }

    public static void botLevelChoose(ArrayList<Players> bots) {
        Scanner sc = new Scanner(System.in);
        botLevelChoose = new ArrayList<>();
        System.out.println("Choose bots level:");
        System.out.println("1-Novice\t2-Regular\t3-Expert");
    
        for (int i = 0; i < howManyBots; i++) {
            System.out.println("Choose level of " + i + ". bot.");
            int input = sc.nextInt();
            if (input == 1) {
                NoviceBot novice = new NoviceBot("Novice Bot " + (i+1));
                botLevelChoose.add(novice);
            } else if (input == 2) {
                RegularBot regular = new RegularBot("Regular Bot " + (i+1));
                botLevelChoose.add(regular);
            } else if (input == 3) {
                ExpertBot expert = new ExpertBot("Expert Bot " + (i+1));
                botLevelChoose.add(expert);
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                i--;
            }
        }
        bots.addAll(botLevelChoose);
    } 

    static void saveScores(Players winner) {
        final String filename = "highscores.txt";
        ArrayList<String> scores = new ArrayList<String>();
        try {
            // Read in the existing high scores
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                scores.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // If the highscores.txt file does not exist, create a new empty file
            try {
                File file = new File(filename);
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creating new high scores file");
                return;
            }
        }
        
        // Add the new high score to the list
        scores.add(winner.getName() + "," + winner.getScore() + "," + winner.getClass());
        
        // Sort the list of high scores
        Collections.sort(scores, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int score1 = Integer.parseInt(o1.split(",")[1]);
                int score2 = Integer.parseInt(o2.split(",")[1]);
                return score2 - score1;
            }
        });
        
        // Write the high scores back to the file
        try {
            Formatter output = new Formatter(new FileWriter(filename));
            for (String score : scores) {
                output.format(score + "\n");
            }
            output.close();
        } catch (IOException e) {
            System.out.println("Error saving high scores to file");
        }
    }

    
}
