package twoPointers;

public class containerWIthmostWater {
    public static int maxArea(int[] height) {

        int maxArea = 1;

        int i = 0;
        int j = height.length-1;

        while (i < j) {
             int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }

        return maxArea;

    }


    public static void main(String[] args) {
        int heights []= {1,1};

System.out.println(maxArea(heights));
    }

}
