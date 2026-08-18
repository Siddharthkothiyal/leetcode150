package arrays;

public class prodExceptitself {
      public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int ans []= new int[n];

    

        for (int i = 1; i < ans.length; i++) {
            ans[i]= ans[i-1] * nums[i-1];
        }


            int suffix=1;

            for (int i = n-2; i >= 0; i++) {

                suffix = suffix * nums[i+1];

                ans[i]  *= suffix;
                
            }



            return ans;


        
    }
}
