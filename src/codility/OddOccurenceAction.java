package codility;

public class OddOccurenceAction {

    public static void main(String[] args) {

        OddOccurencesInArray oddOccurencesInArray = new OddOccurencesInArray();

        int[] array = {9,3,9,3,9,7,9};
        System.out.println("unpaired: "+ oddOccurencesInArray.solution(array));
    }
}
