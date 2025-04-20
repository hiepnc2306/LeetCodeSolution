import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    // abcbacbb
    // a b c
    // b c
    // c -> add b
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int start = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            while (chars.contains(s.charAt(i))) {
                chars.remove(s.charAt(start));
                start += 1;
            }
            chars.add(s.charAt(i));
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
