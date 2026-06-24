class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    private long[] powerApply(long[][] matrix, long[] vector, long exp) {
        while (exp > 0) {
            if ((exp & 1) == 1) {
                vector = multiply(matrix, vector);
            }

            matrix = multiply(matrix, matrix);
            exp >>= 1;
        }

        return vector;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int size = 2 * m;

        long[] base = new long[size];

        // Length = 2
        for (int i = 0; i < m; i++) {
            base[i] = i;               // up[i]
            base[m + i] = m - 1 - i;   // down[i]
        }

        long[][] transition = new long[size][size];

        // up'[i] = sum(down[j]) for j < i
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                transition[i][m + j] = 1;
            }
        }

        // down'[i] = sum(up[j]) for j > i
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                transition[m + i][j] = 1;
            }
        }

        long[] result = powerApply(transition, base, n - 2);

        long answer = 0;
        for (long value : result) {
            answer = (answer + value) % MOD;
        }

        return (int) answer;
    }
}
