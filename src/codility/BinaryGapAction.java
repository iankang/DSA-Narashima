package codility;

import java.util.Arrays;

public class BinaryGapAction {

    public static void main(String[] args){

        BinaryGap binaryGap = new BinaryGap();
        System.out.println("Natural number is 52");
        System.out.println("In Binary, it is: "+ binaryGap.decimalToBinaryString(52));
        System.out.println("Binary gap is "+ binaryGap.countGap(binaryGap.decimalToBinaryString(52)));

        System.out.println("Natural number is 9");
        System.out.println("In Binary, it is: "+ Arrays.toString(binaryGap.decimalToBinary(9)));

        System.out.println("Natural number is 9");
        System.out.println("In Binary, it is: "+ binaryGap.decimalToBinaryString(9));
        System.out.println("Binary gap is "+ binaryGap.countGap(binaryGap.decimalToBinaryString(9)));


    }
}
