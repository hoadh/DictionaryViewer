package dictionaryviewer;

/**
 * DictEntry class:
 * 
 * @author xxxx
 * @email xxxxx
 * @since 05 May 2010
 * @version 1.0.0
 */
public class DictEntry {
    private String word;        //Contains the letters of a word.
    private String definition;  //Contains the definition for that word.

    /**
     * @since 05 May 2010
     * @param word
     * @param definition
     */
    public DictEntry(String word, String definition) {
        this.word       = word;         //Contains the word name.
        this.definition = definition;   //Contains the definition for that word.
    }

    /**
     * containsTheseLetters:The method is used to check if some letters are contained in this word.
     * @since 06 May 2010
     * @param letters needs checking.
     * @return true if this word contains these letters. Otherwise, return false.
     */
    public boolean containsTheseLetters(String letters) {
        for (int i = 0; i<= word.length() - letters.length(); i++) {
        	//System.out.print(i + " ");System.out.println(word.substring(i, letters.length()+i));
        	if (word.substring(i, letters.length()+i).equals(letters))
                    return true; //Returns true if the word needs checking is contained in word.
        }
        return false;
    }

    /**
     * getWord:
     * @since 05 May 2010
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     * getDefinition:
     * @since 05 May 2010
     * @return
     */
    public String getDefinition() {
        return definition;
    }
}
