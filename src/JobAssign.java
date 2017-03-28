import java.util.Scanner;

/**
 * Created by TEEPOPUEANGSAWAT on 3/28/2017.
 */
public class JobAssign {

    static Scanner sc = new Scanner(System.in);
    static int[][] costMatrix;
    static int[][] possibility;
    static int counter = 0;

    public static void main(String[] args) {
        System.out.print("Number of jobs : ");
        int numberOfJobs = sc.nextInt();
        System.out.println("Matrix of cost :");
        costMatrix = new int[numberOfJobs][numberOfJobs];

        for (int i = 0; i < numberOfJobs; i++){
            for (int j = 0; j < numberOfJobs; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }

        possibility = new int[factorial(numberOfJobs)][numberOfJobs];

        int[] theCase = new int[numberOfJobs];
        for (int i = 0; i < numberOfJobs; i++){
            if (i == numberOfJobs){
                theCase[i] = 0;
            }else {
                theCase[i] = i;
            }
        }

        permutation(theCase,0,numberOfJobs);

        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < factorial(numberOfJobs); i++){
            int totalDistance = 0;
            for (int j = 0; j < numberOfJobs;j++){
                totalDistance += costMatrix[j][possibility[i][j]];
            }
            if (lowest > totalDistance){
                lowest = totalDistance;
            }
        }

        System.out.println("Lowest cost : " + lowest);

    }

    public static void permutation(int[] a, int s, int e){
        if(s==e){
            for (int i = 0; i < a.length; i++){
                possibility[counter][i] = a[i];
            }
            counter++;
        } else{
            for(int i = s; i < e; i++){

                int temp = a[s];
                a[s] = a[i];
                a[i] = temp;

                permutation(a,s+1,e);

                temp = a[s];
                a[s] = a[i];
                a[i] = temp;
            }
        }
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
