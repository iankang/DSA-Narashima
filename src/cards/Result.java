package cards;

import java.util.Arrays;

public class Result {
    public String set_name;
    public String[] cards;

    public Result(String set_name, String[] cards) {
        this.set_name = set_name;
        this.cards = cards;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Result{" +
                "set_name='" + set_name + '\'' +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}
