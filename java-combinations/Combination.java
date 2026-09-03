package com.hmkcode;

public class Combination {

    public static void main(String[] args) {
        Object[] elements = new Object[] {'A', 'B', 'C', 'D', 'E'};
        combination(elements, 3);
    }

    public static void combination(Object[] elements, int K) {

        // Validate input
        if (elements == null) {
            System.out.println("Invalid input, elements cannot be null");
            return;
        }

        int N = elements.length;

        if (K < 0 || K > N) {
            System.out.println("Invalid input, K must be between 0 and N");
            return;
        }

        // There is exactly one combination when K = 0
        if (K == 0) {
            System.out.println("C(" + N + ",0) = 1");
            return;
        }

        // Calculate the possible combinations
        c(N, K);

        // Initialize combination index array
        int[] combination = new int[K];

        int r = 0; // index for combination array
        int i = 0; // index for elements array

        while (r >= 0) {

            // Forward step if i < (N + (r - K))
            if (i <= (N + (r - K))) {

                combination[r] = i;

                // If combination array is full, print and increment i
                if (r == K - 1) {
                    print(combination, elements);
                    i++;
                } else {
                    // If combination is not full yet, select next element
                    i = combination[r] + 1;
                    r++;
                }

            } else {
                // Backward step
                r--;

                if (r >= 0) {
                    i = combination[r] + 1;
                }
            }
        }
    }

    private static int c(int n, int r) {

        int nf = fact(n);
        int rf = fact(r);
        int nrf = fact(n - r);

        int npr = nf / nrf;
        int ncr = npr / rf;

        System.out.println("C(" + n + "," + r + ") = " + ncr);

        return ncr;
    }

    private static int fact(int n) {

        if (n == 0) {
            return 1;
        }

        return n * fact(n - 1);
    }

    private static void print(int[] combination, Object[] elements) {

        StringBuilder output = new StringBuilder();

        for (int z = 0; z < combination.length; z++) {
            output.append(elements[combination[z]]);
        }

        System.out.println(output);
    }
}