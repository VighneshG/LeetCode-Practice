/*Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u',
and they can appear in both lower and upper cases, more than once.
Input: s = "hello"
Output: "holle"
*/
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "hello";
        String ans = reverseVowels(s);
        System.out.println("Original String is "+s);
        System.out.println("Reversed String is "+ans);
    }
    public static String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char[] chars = s.toCharArray();
        while (i<j){
            if (isNotVowel(chars[i])){
                i++;
                continue;
            }
            if (isNotVowel(chars[j])){
                j--;
                continue;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++; j--;

        }
        return String.copyValueOf(chars);
    }
    // utility function to check for vowel
    static boolean isNotVowel(char c) {
        return (c != 'a' && c != 'A' && c != 'e'
                && c != 'E' && c != 'i' && c != 'I'
                && c != 'o' && c != 'O' && c != 'u'
                && c != 'U');
    }
}
