package recursion;
import java.util.ArrayList;
import java.util.Scanner;
public class subset_having_given_sum 
{
   public static ArrayList<ArrayList<Integer>> subset(int[] arr, int s)
   {
      ArrayList<Integer> curr = new ArrayList<Integer>();
      ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
      subsets(arr, 0, curr, ans, s);
      return ans;
   }
   
   public static void subsets(int[] arr, int i, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int s)
   {
      if(i == arr.length)
      {
         int sum = 0;
         for(int j=0;j<curr.size();j++)
         {
            sum += curr.get(j);
         }
         if(sum == s)
         {
            ans.add(new ArrayList<Integer>(curr));
         }
         return;
      }
      curr.add(arr[i]);
      subsets(arr, i+1, curr, ans, s);
      curr.remove(curr.size() - 1);
      subsets(arr, i+1, curr, ans, s);
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int arr[] = new int[n];
      for(int i = 0; i < n; i++)
      {
         int k = sc.nextInt();
         arr[i] = k;
      }
      int s = sc.nextInt();
      ArrayList<ArrayList<Integer>> subsets = subset(arr, s);
      System.out.println("Subsets with sum " + s + ":");
      System.out.println(subsets);
      
   }
}
