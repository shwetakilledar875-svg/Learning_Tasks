package org.dsa;

public class Dsa3 {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        Dsa3 dsa3 = new Dsa3();
        int result = dsa3.missingNumber(nums);
        System.out.println("Missing number is: " + result);
    }
    public int missingNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<=n;i++){
            boolean found=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    found=true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }
        return -1;
        }
    }
