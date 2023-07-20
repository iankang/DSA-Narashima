package cards;

public class CardAction {
    public static void main(String[] args) {

        String[] cards = {"2H", "4H","7C","9D","10D","KS","D"};
        CardSolution solution = new CardSolution();
        System.out.println(solution.extractRankAndSuitFromList(cards));
        System.out.println(solution.singleCard(cards));
    }
}
