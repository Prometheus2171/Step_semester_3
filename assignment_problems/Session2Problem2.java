public class Session2Problem2 {
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }
        String[] words = sentence.split(" ", -1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(' ');
            }
            result.append(new StringBuilder(words[i]).reverse());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}