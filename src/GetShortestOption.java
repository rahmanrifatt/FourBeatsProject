import java.util.List;
public class GetShortestOption {
    String sortestOption = null;
    public String  shortest(List<String> texts){
        for (String word : texts) {
            if (sortestOption == null || word.length() < sortestOption.length()) {
                sortestOption = word;
            }
        }
        return sortestOption;
    }
}
