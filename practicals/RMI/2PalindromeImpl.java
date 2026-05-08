package practical;

import java.rmi.*;
import java.rmi.server.*;

public class PalindromeImpl extends UnicastRemoteObject implements Palindrome
{
    public PalindromeImpl() throws RemoteException
    {
        super();
    }

    public String checkPalindrome(String str) throws RemoteException
    {
        String rev = "";

        for(int i = str.length() - 1; i >= 0; i--)
        {
            rev = rev + str.charAt(i);
        }

        if(str.equalsIgnoreCase(rev))
        {
            return str + " is Palindrome";
        }
        else
        {
            return str + " is Not Palindrome";
        }
    }
}