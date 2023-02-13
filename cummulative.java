import java.util.*;
import java.util.Arrays;
class cummulative{
    public static void main (String []args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int [n];
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            sum =sum+ a[i];
            a[i] = sum;
        }
        System.out.println(Arrays.toString(a));
        sc.close();
    
    }
}