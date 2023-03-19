import recursion.ArrayIsSorted;
import recursion.TowerOfHanoi;

public class Main {
    public static void main(String[] args) {

        TowerOfHanoi tower = new TowerOfHanoi();
        tower.hanoiTower(3,'A','C','B');

        System.out.println();
        System.out.println();

        ArrayIsSorted isSorted = new ArrayIsSorted();
        System.out.println(isSorted.isArraySorted(new int[]{1, 2, 3, 4, 5, 6},6));
        System.out.println(isSorted.isArraySorted(new int[]{1, 2, 3, 5, 4, 6},6));
    }
}
