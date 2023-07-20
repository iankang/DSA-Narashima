package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardSolution {

    public String getRank(String rankAndSuit) {
        int length = rankAndSuit.length();
        return rankAndSuit.substring(0,length - 1);
    }
    public String getSuit(String rankAndSuit) {

        int length = rankAndSuit.length();
        return String.valueOf(rankAndSuit.charAt(length - 1));
    }

    public Map<String,String> extractRankAndSuitFromList(String[] rankAndStrings) {

        Map<String,String> rankingAndSuiting = new HashMap<>();
        for(String card:rankAndStrings){
            String rank = getRank(card);
            String suit = getSuit(card);
            rankingAndSuiting.put(rank,suit);
        }
        return rankingAndSuiting;
    }

    public Integer getRankValue(String rank){
        Map<String,Integer> ranking = new HashMap<>();
        ranking.put("",1);
        ranking.put("2",2);
        ranking.put("3",3);
        ranking.put("4",4);
        ranking.put("5",5);
        ranking.put("6",6);
        ranking.put("7",7);
        ranking.put("8",8);
        ranking.put("9",9);
        ranking.put("10",10);
        ranking.put("J",11);
        ranking.put("Q",12);
        ranking.put("K",13);
        ranking.put("A",14);
        return ranking.get(rank);
    }

    public Result singleCard(String[] rankAndStrings){

        int rankValue = 0;
        String[] stringArr = new String[1];
        String rank = "";
        for(String ranking: rankAndStrings){
            String singleRank= getRank(ranking);
            int ranked = getRankValue(singleRank);

            if(ranked>rankValue){
                rankValue = ranked;
                rank = ranking;
            }
        }
        stringArr[0] = rank;
        return new Result("single card",stringArr);
    }

//    public Result pair(String[] rankAndStrings){
//
//        Map<String,Integer> cardCount = new HashMap<>();
//        for(String rankAndString: rankAndStrings){
//
//        }
//    }
}
