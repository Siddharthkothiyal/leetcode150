package dp;

public class adjacentEle {
    public static int function(int index, int[] nums) {

        if (index == 0)
            return nums[0];

        if (index < 1)
            return 0;

        int Notpick = 0 + function(index - 1, nums);

         

        int pick = nums[index] + function(index - 2, nums);

        return Math.max(Notpick, pick);

    }

    public static int nonAdjacent(int[] nums) {

        return function(nums.length-1, nums);

    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 9 };

        System.out.println(nonAdjacent(nums));
    }
}
