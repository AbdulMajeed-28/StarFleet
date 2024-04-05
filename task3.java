import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount in rupees: ");
        int amount = sc.nextInt();
        if(amount <= 0)
        {
            System.out.println("Invalid input. Please enter a positive amount.");
            return;
        }
        System.out.println("Change breakdown: ");
        if(amount == 10)
        {
            System.out.println("2 x 5 rupee(s)");
            return;
        }
        if(amount == 5)
        {
            System.out.println("2 x 2 rupee(s)\n1 x 1 rupee(s)");
            return;
        }
        if(amount == 2)
        {
            System.out.println("2 x 1 rupee(s)");
            return;
        }
        int[] changes = {10,5,2,1};
        int[] changeCount = new int[changes.length];

        for(int i = 0; i < 4; i++)
        {
            if(amount >= changes[i])
            {
                changeCount[i] = amount / changes[i];
                amount %= changes[i];
            }
        }
        for(int i = 0; i < 4; i++)
        {
            if(changeCount[i] > 0)
            {
                System.out.println(changeCount[i] + " x " + changes[i] + " rupee(s)");
            }
        }
    }
}
