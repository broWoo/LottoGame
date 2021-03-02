package choi.java.loto;

import java.io.*;
/**
   로또게임
*/
public class Lotto{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int[][] lotto;
      
      System.out.print("몇 게임 = ");
      int game = Integer.parseInt(br.readLine());

      lotto = new int[game][6];
      int count = 0;

      for(int line=0; line<lotto.length; line++){ // 게임수 = 행
         for(int col=0; col<lotto[line].length; col++){ // 컬럼
            lotto[line][col] = (int)(Math.random() * 45) + 1; // 1 ~ 45
            for(int tCol=0; tCol<col; tCol++){
               if(lotto[line][col] == lotto[line][tCol]){
                  col--; break;
               }
            }
         }// end for col

         for(int tLine=0; tLine<line; tLine++){
            count = 0;
            for(int col=0; col<lotto[line].length; col++){
               for(int tCol=0; tCol<lotto[tLine].length; tCol++){
                  if(lotto[line][col] == lotto[tLine][tCol]){
                     count++; break; // 컬럼 하나의 값이 같으면 count++하고 다음 컬럼을 값을 비교
                  }
               }
               if(count == col) break; // 하나의 값이라도 안같으면 그 줄 전체가 같지않다.
            }
            if(count == lotto[line].length){ // 같은 컬럼의 값이 6개냐?
               line--; break;
            }
         }
      }//end for line


      int temp;
      for(int line=0; line<lotto.length; line++){
         for(int i=lotto[line].length; i>0; i--) {
            for (int j=0; j<i-1; j++) {
               if(lotto[line][j] > lotto[line][j+1]) {
                  temp = lotto[line][j]; 
                  lotto[line][j] = lotto[line][j+1];
                  lotto[line][j+1] = temp;
               }
            }
         }
      }

      System.out.println();
      for(int i=0; i<lotto.length; i++){
         System.out.print(i + 1 + "번 추천번호 : ");
         for(int j=0; j<lotto[i].length; j++){
             System.out.print(lotto[i][j] + "\t"); 
         }
         System.out.println();
      }
   }
}