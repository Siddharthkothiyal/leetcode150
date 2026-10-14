package dp.twoDp;

public class nunjaTraining {

      public  static  int funtion (int[][] matrix , int i , int previousDayAct) {

        for (int days = 0; days <= matrix.length; days++) {

            int notPick =0;
            int pick=0;


            

            if (i != previousDayAct ) {
                pick = matrix[days][j] + funtion(matrix, pick, i);
                
            }
            
        }









      }
        

    
     public int ninjaTraining(int[][] matrix) {

        funtion(matrix, matrix[0].length-1, -1);




    }
}
