import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start population: ");
        double n = sc.nextDouble();
        System.out.print("Enter end population: ");
        double x = sc.nextDouble();
        double a = n/3;
        double b = n/4;
        int years;
        for(years = 0; n < x;years++) 
        {
            n = n + (a-b);
            a = n/3;
            b = n/4;
        }
        System.out.println("It will take " + years + " years to reach the end population.");
    }
}
