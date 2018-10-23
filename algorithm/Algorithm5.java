
public class Algorithm5 {
    private static String result = "";

    public static void main(String[] args) {
        String a = "123456789123";
        String b = "1202424567839";
        char[] cb = b.toCharArray();
        String upgrade = "";

        for (int i = cb.length - 1; i >= 0; i--) {
            int mer = cb[i] - '0';
            char[] ca = a.toCharArray();
            int plus = 0;

            for (int j = ca.length - 1; j >= 0; j--) {
                int m = ca[j] - '0';
                int cross = m * mer + plus;
                plus = cross / 10;
                ca[j] = (char) (cross % 10 + '0');
            }

            String delta = new String(ca) + upgrade;
            if (plus > 0) {
                delta = (char) (plus + '0') + delta;
            }

            add(delta);
            upgrade += "0";

        }

        System.out.println("result:" + result);

    }

    private static void add(String delta) {
        if (result.isEmpty()) {
            result = delta;
            return;
        }

        char[] charResult = result.toCharArray();
        char[] charDelta = delta.toCharArray();

        if (delta.length() > result.length()) {
            charResult = delta.toCharArray();
            charDelta = result.toCharArray();
        }

        int plus = 0;
        for (int i = 0; i < charDelta.length; i++) {
            int deltaIndex = charDelta.length - 1 - i;
            int resultIndex = charResult.length - 1 - i;
            int td = charDelta[deltaIndex] - '0';
            int tr = charResult[resultIndex] - '0';
            int sum = td + tr + plus;
            plus = sum / 10;

            charResult[resultIndex] = (char) (sum % 10 + '0');

        }

        int index = charResult.length - charDelta.length - 1;
        while (plus > 0 && index >= 0) {
            int t = charResult[index] - '0';
            int sum = t + plus;
            plus = sum / 10;
            charResult[index] = (char) (sum % 10 + '0');
        }

        result = new String(charResult);
        if (plus > 0) {
            result = plus + result;
        }

    }

}