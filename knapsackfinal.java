import java.util.*;
public class knapsackfinal {
  
  public static void main(String[] args) {
    Scanner arn= new Scanner(System.in);
   System.out.println ("\n Enter the number of items u want to enter:");  
   int n=arn.nextInt();
   
    int w[]=new int[n+1];
    w[0]=0;
    int p[]=new int[n+1];
    p[0]=0;
     for(int i=1;i<=n;i++)  
        {  
          System.out.println ("\n Enter the weight  of "+i+" : item ");  
          w[i]=    arn.nextInt();  
          System.out.println ("\n Enter the profit  of "+i+" : item ");  
            p[i]= arn.nextInt(); 
         
        } 
     System.out.println ("\n Enter the capacity of the knapsack : ");  
       int c =arn.nextInt();
        int ar[][]=new int [n+1][c+1];
        for (int i=0; i<=n; i++){ 
      ar[i][0] = 0;
    }
    for (int i=0; i<=c; i++){
     ar[0][i] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= c; j++) {
        if(w[i]>j)
        {
          ar[i][j]=ar[i-1][j];
        }
        else{
          ar[i][j] = Math.max(ar[i-1][j], (p[i]+ar[i-1][j-w[i]]));
        }
      }
  }
    System.out.println("my knapsack 2d array is:");
     for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= c; j++) {
        System.out.print(ar[i][j]+" ");
}
      System.out.println();
   
}
 System.out.println("knapsack output is:");
 int y=1;

 while(ar[n][c]>0){
 if (ar[n][c] != ar[n-1][c])
 {
   
    System.err.println("choosen item number "+y+".  weight is: "+w[n]+ "  profit is: "+p[n]);
   y++;
    n = n-1; c = c-w[n];
 }
 else {
   
   n=n-1;
 }
 }
  }
}