package practical;

import java.rmi.*;

public interface Palindrome extends Remote
{
    public String checkPalindrome(String str) throws RemoteException;
}
