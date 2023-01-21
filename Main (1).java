package com.jannatul;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final  int range = 1000;

        final List<Integer> primes = findPrimes(range);

        System.out.println("Number of Primes found between 0 and " + range + " : "+ primes.size() + "\n" + primes);
    }

    static List<Integer> findPrimes(Integer n) {
        // Prime list -> Initially empty
        final ArrayList<Boolean> primeList = new ArrayList<Boolean>();

        // Array primeList indicates whether a number is prime or not.
        // Initially Assuming all numbers are prime
        // Array indices is the number and value of the indices is its prime status
        // True -> prime; False -> not prime
        for (int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        // 0 and 1 are not prime by definition
        primeList.set(0, false);
        primeList.set(1, false);

        for (int i = 2; i < Math.sqrt(n); i++) {

            if (primeList.get(i)) {
                // Loop over from i to i*j and cross out any number that is divisible by i, i.e. not a prime
                for (int j = i; i * j <= n; j++) {
                    primeList.set(i * j, false);
                }
            }

        }

        // Filter the prime numbers from primeList array, i.e. indices where primeList[i] == True
        final ArrayList<Integer> filteredPrimeList = new ArrayList();

        for (int i = 0; i < primeList.size(); i++) {
            if(primeList.get(i)) filteredPrimeList.add(i);
        }

        return filteredPrimeList;
    }
}
