
import java.util.ArrayList;
import java.util.Scanner;

public class GameSettings {
    private static boolean isPlayerPlay;
    private static String name;
    private static int howManyPlayers;
    private static ArrayList<Integer> botLevelChoose;



    public static void askPlayerPlay(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you play or watch this game?");
        System.out.println("1-Yes");
        System.out.println("2-No");

        int answer = sc.nextInt(); //int alma fonksiyonu yaz
        if(answer==1){
            isPlayerPlay = true;
        } else if(answer == 2){
            isPlayerPlay = false;
        } else{
            System.out.println("You write wrong number. Please write 1 or 2");

        }
    }

    public static boolean getIsPlayerPlay(){
        return isPlayerPlay;
    }

    public static void nameOfPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your name");
        name = sc.nextLine();
    }

    public static int howManyPlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many bots will play?");
        howManyPlayers = sc.nextInt();
        return howManyPlayers;
        
    }

    public static void botLevelChoose(ArrayList<Bot> bots){
        Scanner sc = new Scanner(System.in);
        botLevelChoose = new ArrayList<>();
        System.out.println("Choose bots level:");
        System.out.println("1-Novice\t2-Regular\t3-Expert");
        if(isPlayerPlay = true){
            for(int i=1; i<=howManyPlayers;i++){
                System.out.println("Choose level of "+i+". bot.");
                int input =sc.nextInt();
                if(input ==1){
                    NoviceBot novice = new NoviceBot();
                    bots.add(novice);
                }
                if(input ==2){
                    RegularBot regular = new RegularBot();
                    bots.add(regular);
                }
                if(input ==3){
                    ExpertBot expert = new ExpertBot();
                    bots.add(expert);
                }
            }
        }
        

    }




    
}
