package streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args){

        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.print("Original Values:");
        System.out.println(
                IntStream.of(values)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));

        System.out.printf("%n count: %d%n",IntStream.of(values).count());
        System.out.printf("%n Min: %d%n",IntStream.of(values).min().getAsInt());
        System.out.printf("%n Max: %d%n",IntStream.of(values).max().getAsInt());
        System.out.printf("%n Sum: %d%n",IntStream.of(values).sum());
        System.out.printf("%n Average: %.2f%n",IntStream.of(values).average().getAsDouble());
        System.out.printf("%n count: %d%n",IntStream.of(values).count());

        System.out.printf("Sum via reduce method: %d%n",
                IntStream.of(values)
                .reduce(0, (x,y) -> x + y));

        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values)
                .reduce((x,y) -> x * y).getAsInt());

        System.out.printf("Sum of squares via map and sum: %d%n%n",
                IntStream.of(values)
                        .map( x -> x * x)
                        .sum());
        System.out.printf("Values displayed in sorted order: %s %n",
                IntStream.of(values)
                        .sorted()
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }
}
