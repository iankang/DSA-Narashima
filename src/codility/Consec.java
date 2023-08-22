package codility;

public class Consec {

    public static String solution(String S) {

        int stringLength = S.length();
        int consX = 0;
        int consO = 0;
        int totalX = 0;
        int totalY = 0;

        for (int i = 0; i < stringLength; i++) {

            char c = S.charAt(i);
            if (c == 'X') {
                consX++;
                if (consX == 3) {
                    totalX++;
                }
                consO = 0;

            } else if (c == 'O') {
                consO++;
                if (consO == 3) {
                    totalY++;
                }
                consX = 0;

            }
        }

        if (totalX > 0 && totalY == 0) {
            return "X";
        } else if (totalY > 0 && totalX == 0) {
            return "O";
        } else {
            return "tie";
        }
    }

    public static void main(String[] args) {
        String input = "XOXOXOXXX";
//        String input = "XX";
//        String input = "XOXXXOOOXOOO";
        System.out.println(solution(input));
    }
}
