package RandomIntegers;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class main {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        System.out.println("10 Random numbers:\n");
        int[] randomInt = randomNumbers.ints(10,0,1000).toArray();
        System.out.printf("Values: %s%n \nOdd: %d%nEven: %d%n \nAverage of all: %.2f%nAverage of odd: %.2f%nAverage of even: %.2f%n",
                IntStream.of(randomInt).mapToObj(String::valueOf).collect(Collectors.joining("   ")),
                IntStream.of(randomInt).filter(x -> x % 2 == 0).map(x -> 1).sum(),
                IntStream.of(randomInt).filter(x -> x % 2 == 1).map(x -> 1).sum(),
                (double)IntStream.of(randomInt).sum()/IntStream.of(randomInt).map(x -> 1).sum(),
                (double)IntStream.of(randomInt).filter(x -> x % 2 == 0).sum()/IntStream.of(randomInt).filter(x -> x % 2 == 0).map(x -> 1).sum(),
                (double)IntStream.of(randomInt).filter(x -> x % 2 == 1).sum()/IntStream.of(randomInt).filter(x -> x % 2 == 1).map(x -> 1).sum());
    }
}
