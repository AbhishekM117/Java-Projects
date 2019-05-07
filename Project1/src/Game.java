import java.util.*;
import java.util.Random;
import java.util.Scanner;
class Game
{
        public static void main(String[] args)
	{
        	Random rand = new Random();
        	Scanner in = new Scanner(System.in);
        	int prize=0;
        int matches=0;
        System.out.println("Enter the betting amount:");
		Scanner sc = new Scanner(System.in);
		int betmoney=sc.nextInt();
        int[] user=new int[5];
		for(int i=0;i<5;i++)
        	{
        	    System.out.println("Enter "+(i+1)+" card number btw (1-13)no.:");
        	    user[i]=in.nextInt();
        	}
        	System.out.println("System's number "+" Guessed number"+"\n*************************************");
        int[] sys = new int[5];
        for(int i = 0; i<5; i++)
			{
			sys[i]=1+rand.nextInt(13);
             System.out.println(sys[i]+"\t\t\t\t\t\t"+user[i]);
			}


        for(int i = 0; i<5; i++)
        	{for(int j = 0; j<5; j++){
        	    if(user[i]==sys[j])
        	    {
        	        matches++;
        	        prize=matches*betmoney;
        	    }
        	}}
        	if(matches>=2)
        	{
        	    System.out.println("Matching Cards="+matches);
        	    System.out.println("Your Reward="+ prize);
        	}
       		else
                System.out.println("Game Over.... Better luck next time!!!");
	}
}
