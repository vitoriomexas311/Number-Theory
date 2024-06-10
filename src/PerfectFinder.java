import java.util.ArrayList;
import java.util.List;

public class PerfectFinder {
  static boolean isPrime(long n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }

    for (long i = 5; i <= Math.sqrt(n); i = i + 6)
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    return true;
  }


  private List<Long> perfectNumbers() {
    List<Long> allPrimes = new ArrayList<>();
    for (long i = 1; i <= 10000; i = i + 2) {
      if (isPrime(i)) {
        allPrimes.add(i);
      }
    }
    List<Long> primesWeWant = new ArrayList<>();
    for (long prime : allPrimes) {
      if (isPrime((long) (Math.pow(2, prime) - 1))) {
        primesWeWant.add(prime);
      }
    }

    List<Long> perfectNumbers = new ArrayList<>();
    for (long prime : primesWeWant) {
      perfectNumbers.add(Math.multiplyExact((long) Math.pow(2, prime - 1), (long) (Math.pow(2, prime) - 1)));
    }
    return perfectNumbers;
  }

  public static void main(String[] args) {
    PerfectFinder finder = new PerfectFinder();
    List<Long> perfectNumbers = finder.perfectNumbers();
    for (long number : perfectNumbers) {
      System.out.printf("%d%n", number);
    }
  }
}
