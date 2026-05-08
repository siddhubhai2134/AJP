package practical;

import java.rmi.*;
import java.util.Scanner;

public class PalindromeClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            Palindrome p = (Palindrome)Naming.lookup(
                "rmi://localhost/PalindromeService");

            System.out.print("Enter String or Number: ");
            String str = sc.nextLine();

            String result = p.checkPalindrome(str);

            System.out.println(result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
