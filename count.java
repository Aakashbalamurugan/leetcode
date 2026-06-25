import java.util.*;

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int freq = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    freq++;
                }

                int len = j - i + 1;

                if (freq > len / 2) {
                    count++;
                }
            }
        }

        return count;
    }
}