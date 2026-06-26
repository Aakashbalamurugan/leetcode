public class countMajoritySubarraysII {
    
}
class BinaryIndexedTree {
    private int n;
    private int[] tree;

    public BinaryIndexedTree(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            tree[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int sum = 0;
        while (x > 0) {
            sum += tree[x];
            x -= x & -x;
        }
        return sum;
    }
}

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // BIT size = possible prefix sums [-n, n]
        BinaryIndexedTree bit = new BinaryIndexedTree(2 * n + 2);

        // prefix sum starts at 0
        // shift by n+1 so index is always positive
        int prefix = n + 1;

        bit.update(prefix, 1);

        long ans = 0;

        for (int x : nums) {

            if (x == target)
                prefix++;
            else
                prefix--;

            ans += bit.query(prefix - 1);

            bit.update(prefix, 1);
        }

        return ans;
    }
}