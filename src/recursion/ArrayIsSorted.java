package recursion;

public class ArrayIsSorted {
    public int isArraySorted(int[] A, int index){
        if(A.length == 1 || index == 1){
            return 1;
        }
        return A[index - 1] < A[index - 2] ? 0 : isArraySorted(A, index - 1);
    }
}
