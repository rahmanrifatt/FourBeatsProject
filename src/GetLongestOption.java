import java.util.List;
public class GetLongestOption {
    String longestOption = null;
    public String  longest(List<String> texts){
        for (String word : texts) {
            if (longestOption == null || word.length() > longestOption.length()) {
                longestOption = word;
            }
        }
        return longestOption;
    }
}
