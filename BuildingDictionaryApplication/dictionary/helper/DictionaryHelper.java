package dictionary.helper;

import java.util.List;

public interface DictionaryHelper {
    public boolean insert(String word);

    public boolean search(String word);

    public boolean delete(String word);

    public List<String> autoSuggest(String prefix);

    public List<String> autoCorrect(String word);
}
