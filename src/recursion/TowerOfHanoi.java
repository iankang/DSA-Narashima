package recursion;

public class TowerOfHanoi {

    public void hanoiTower(int n, char source, char destination, char aux){

        if(n == 1){
            System.out.printf("Move disk 1 from %c to %c %n",source, destination);
            return;
        }
        hanoiTower(n -1, source, aux,destination);
        System.out.printf("Move disk %d from %c to %c %n", n,source,aux);
        hanoiTower(n - 1, aux,destination, source);
    }

}
