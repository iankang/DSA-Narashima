package codility;

public class BinaryGap {

    public Integer[] decimalToBinary(Integer number){

        Integer[] binary = new Integer[100];
        int index = 0;
        Integer num = number;
        while(num > 0 ){
            binary[index] = num % 2;
            index++;
            num = num / 2;
        }
        return binary;
    }

    public String decimalToBinaryString(Integer number){
        return Integer.toBinaryString(number);
    }

    public Integer countGap(String binary){

        Integer longest = 0;
        Integer current = 0;
        Integer oneCount = 0;

        for(char c : binary.toCharArray()){

            if(c == '1'){

                current = 0;
                oneCount++;
            } else {

                current++;
                longest = Math.max(current,longest);
            }
        }

        if(oneCount>1){
            return longest;
        }
        return 0;
    }
}
