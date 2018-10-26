package algorithm;

public class Algorithm2 {
    public static void main(String[] args) {
        char[] str = "i am chinese!".toCharArray();

        reverse(str);
        System.out.println(str);
    }

    public static void reverse(char[] str) {
        subReverse(str, 0, str.length - 1);

        for (int k = 0; k < str.length;) {
            int s = k;
            while (k < str.length && str[k] != ' ')
                k++;
            subReverse(str, s, k - 1);
            while (k < str.length && str[k] == ' ')
                k++;
        }
    }

    public static void subReverse(char[] str, int i, int j) {

        if (i >= j)
            return;
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}
