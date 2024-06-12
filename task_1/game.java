
import java.util.*;
import java.math.*;
public class game{
    public static void main(String args[]){

        //generate random number
        Random rd = new Random();
        int random=rd.nextInt(100)+1;

        //take input usinf scanner class
        Scanner sc = new Scanner(System.in);

        //define variable
        boolean correct = false;
        int attempts = 0;
        System.out.println("Guess number between 1 to 100");
        System.out.println("You have only Five attempts");
        System.out.println("GOOD LUCK!!");


        while(!correct && attempts<5)
       {
        //give input from user
        int guess = sc.nextInt();

        if(guess==random)
        {
            correct = true;
            System.out.println("YES! YOU ARE RIGHT ");
        }
        else{
            attempts++;

            if(guess>random){
                System.out.println("its too High ,try again");
            }
            else{
                System.out.println ("its too Low ,try again");
            }
        }
       } 
    }
}