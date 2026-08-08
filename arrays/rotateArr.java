package arrays;

public class rotateArr {

    public static void reverseFunction(int i, int j, int[] nums) {



        while (i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;

        }

    }

    public static void rotate(int[] nums, int k) {
       k = k % nums.length;

    int n = nums.length - 1;

    int sectionPoint = n - k;
    int secondSec = n - k + 1;

    int i = 0;

    reverseFunction(i, sectionPoint, nums);
    reverseFunction(secondSec, n, nums);
    reverseFunction(i, n, nums);

    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6,7};
        int  k = 3;

       rotate(nums, k);

       for (int i = 0; i < nums.length; i++) {
        System.out.print(nums[i] + " ");
       }
    }
}
