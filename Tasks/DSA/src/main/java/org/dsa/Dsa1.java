package org.dsa;


//Largest Number At Least Twice of Others
public class Dsa1 {
    public static void main(String[] args) {
        Dsa1 dsa1 = new Dsa1();
        int[] nums = {3, 6, 1, 0};
        int result = dsa1.dominantIndex(nums);
        System.out.println(result);
    }

    public int dominantIndex(int[] nums) {
            int maxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            int maxValue = nums[maxIndex];

            for (int i = 0; i < nums.length; i++) {
                if (i != maxIndex) {
                    if (maxValue < 2 * nums[i]) {
                        return -1;
                    }
                }
            }
            return maxIndex;
        }
    }
