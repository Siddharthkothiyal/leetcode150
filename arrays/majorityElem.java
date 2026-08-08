package arrays;

import java.util.Arrays;

public class majorityElem {

     public int majorityElement(int[] nums) {

          Arrays.sort(nums);
        return nums[nums.length/2 ];
        
    }
    
}
