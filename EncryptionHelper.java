package posist_code;

public class EncryptionHelper{

	public static String encrypt(String s, int k){

	   StringBuffer result = new StringBuffer();
 
        for (int i=0; i<s.length(); i++)
        {
            if (Character.isUpperCase(s.charAt(i)))
            {
                char ch = (char)(((int)s.charAt(i) + k - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)s.charAt(i) + k - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();

	}
	public static String decrypt(String s,int k){

	   StringBuffer result = new StringBuffer();
 
        for (int i=0; i<s.length(); i++)
        {
            if (Character.isUpperCase(s.charAt(i)))
            {
                char ch = (char)(((int)s.charAt(i) - k - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)s.charAt(i) - k - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

}