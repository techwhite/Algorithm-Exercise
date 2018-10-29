package algorithm;

public class Algorithm8 {
    public static void main(String[] args) {
        String article = "Returns the value to which the specified key is mapped," +
        "or {@code null} if this map contains no mapping for the key." +
        "* <p>More formally, if this map contains a mapping from a key" +
        "* {@code k} to a value {@code v} such that {@code (key==null ? k==null :" +
        "* key.equals(k))}, then this method returns {@code v}; otherwise" +
        "* it returns {@code null}.  (There can be at most one such mapping.)";
        char[] p = article.toCharArray();

        System.out.println(wordCount(p));
        
    }

    private static int wordCount(char[] p) {
        int count = 0;

        boolean isEndOfWord = true;
        for (int i = 0; i < p.length; i++) {
            if (isElemOfWord(p[i])) {
                if (isEndOfWord) {
                    count++;
                    isEndOfWord = false;
                }
            } else {
                isEndOfWord = true;
            }
        }

        return count;
        
    }

    private static boolean isElemOfWord(char a) {
        return a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a >= '0' && a <= '9';
    }

    
}
