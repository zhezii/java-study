package org.zhezii.easy;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/22
 */
public class Twosum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(twoSum(nums,target)[0]+"***"+twoSum(nums,target)[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] arr = null;
        for (int i = 0;i < nums.length; i++){
            int num1 = nums[i];
            for (int j = i + 1;  j < nums.length;j++){
                int num2 = nums[j];
                if((num1+num2) == target){
                    arr = new int[]{i,j};
                }
            }
        }
        return arr;
    }

}



