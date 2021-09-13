public class SpinWords {
    public String spinWords(String sentence) {
        String s_reverse="";
        for (int i = sentence.length()-1; i > -1; i--) {
            s_reverse+=sentence.charAt(i);
        }
        return s_reverse;
    }
}