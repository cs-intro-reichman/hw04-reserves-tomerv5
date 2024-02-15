public class StringOps {
    /*/
     Reminder:
     allowed methods
    
     1.charAt(int index)
     2.length()
     3.substring(int start)
     4.substring(int start,int ends)
     5.indexOf(String str)
    
     The rest are not allowed !
     if you want to use a different
     method, and you can implement
     it using material from the course
     you need to implement a version of
     the function by yourself.
    
     see example for substring
     in Recitation 3 question 5
    
    */
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("One two tHRee world"));
        System.out.println(camelCase("  tWo    wordS"));
        

    }

    public static String noSpacesstring(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ')
                newString += string.charAt(i);
        }
        return newString;
    }

    public static String lowCharstring(String string) {
        String newStringlow = "";
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') && string.charAt(i) != ' ')
                newStringlow += (char) (string.charAt(i) + 32);
            else
                newStringlow += string.charAt(i); // making it all low letters
        }
        return newStringlow;

    }

    public static String capVowelsLowRest(String string) {
        String newStringlow = lowCharstring(string);
        String capVowels = "";
        for (int i = 0; i < newStringlow.length(); i++) {
            if (newStringlow.charAt(i) == 'a' || newStringlow.charAt(i) == 'e' || newStringlow.charAt(i) == 'i'
                    || newStringlow.charAt(i) == 'o' || newStringlow.charAt(i) == 'u')
                capVowels += (char) (newStringlow.charAt(i) - 32);
            else
                capVowels += newStringlow.charAt(i);
        }
        return capVowels;
    }

    public static String camelCase(String string) {
        String newStringlow = lowCharstring(string);
        String newStringcap = "";
        for (int i = 0; i < newStringlow.length(); i++) {
            if ((newStringlow.charAt(i) == ' ' && i != newStringlow.length() - 1) //checking if it's space and not last char.
                && (newStringlow.charAt(i + 1) >= 'a' && newStringlow.charAt(i + 1) <= 'z')){ //and making sure its low case
                newStringcap += (char) (newStringlow.charAt(i + 1) - 32);
                i++;
            }
            else newStringcap += newStringlow.charAt(i);
        }
        newStringcap = noSpacesstring(newStringcap);  //removing spaces
        if(newStringcap.charAt(0) >= 'A' && newStringcap.charAt(0) <= 'Z') //handling the first letter if it remains capital because of spaces before the first word
            newStringcap = (char) (newStringcap.charAt(0)  +32) + newStringcap.substring(1);
        
        return newStringcap;
    }
    
    public static int[] allIndexOf(String string, char chr) {
        int count = 0;
        for(int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == chr) {
                count++;
            }
        }
        int [] index = new int[count];
        int resIndex = 0;
        for(int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == chr) {
                index[resIndex] = i;
                resIndex++;
            }
        }
        return index;
    }
}
