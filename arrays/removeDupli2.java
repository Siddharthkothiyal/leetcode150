package arrays;

public class removeDupli2 {

     public int removeDuplicates(int[] nums) {

        int i=0;
        

        for (int j = 0; j < nums.length; j++) {

            if(nums[i] != nums[j]){
                nums[i+2]= nums[j];
                i= i+2;
            }
            
        }


        return i-1;
        
    }
    
}
