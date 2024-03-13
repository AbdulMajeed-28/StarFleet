import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void visa(String cardNumber)
    {
        if (cardNumber.startsWith("4") && (cardNumber.length() == 12 || cardNumber.length() == 15))
        {
            System.out.println("Visa card is valid");

        }
    }
    public static void amex(String cardNumber) {
        if (cardNumber.startsWith("34") || cardNumber.startsWith("37"))
        {
            if (cardNumber.length() == 14)
            {
                System.out.println("American Express card is valid");
            }
        }
    }
    public static void mastercard(String cardNumber)
    {
        if (cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53") || cardNumber.startsWith("54") || cardNumber.startsWith("55"))
        {
            if (cardNumber.length() == 15)
            {
                System.out.println("Mastercard is valid");
            }
            else
            {
                System.out.print("");
            }
        }
        else
        {
            System.out.print("");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a card number: ");
        String cardNumber = sc.nextLine().replaceAll("[\\s-]", "");
        char lastChar = cardNumber.charAt(cardNumber.length() - 1);
        cardNumber = cardNumber.substring(0, cardNumber.length() - 1);
        List<Integer> cardDigits = new ArrayList<>();
        for (char c : cardNumber.toCharArray())
        {
            cardDigits.add(Character.getNumericValue(c));
        }
        Collections.reverse(cardDigits);
        List<Integer> operatedDigits = new ArrayList<>();
        for (int i = 0; i < cardDigits.size(); i++) {
            int digit = cardDigits.get(i);
            if (i % 2 == 0)
            {
                int twoDigit = digit * 2;
                if (twoDigit > 9)
                {
                    twoDigit -= 9;
                }
                operatedDigits.add(twoDigit);
            }
            else
            {
                operatedDigits.add(digit);
            }
        }
        int total = Character.getNumericValue(lastChar) + operatedDigits.stream().mapToInt(Integer::intValue).sum();
        if (total % 10 == 0)
        {
            visa(cardNumber);
            amex(cardNumber);
            mastercard(cardNumber);
        }
        else
        {
            System.out.println("Invalid credit card");
        }
    }
}
