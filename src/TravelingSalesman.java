import java.util.Scanner;

/**
 * Created by TEEPOPUEANGSAWAT on 3/28/2017.
 */
public class TravelingSalesman {

    static Scanner sc = new Scanner(System.in);
    static int[][] distance;
    static int[][] possibility;
    static int counter = 0;
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {
        System.out.print("Number of towns : ");
        int numberOfTowns = sc.nextInt();
        System.out.println("Matrix of distance :");
        distance = new int[numberOfTowns][numberOfTowns];

        for (int i = 0; i < numberOfTowns; i++){
             for (int j = 0; j < numberOfTowns; j++) {
                 distance[i][j] = sc.nextInt();
             }
        }

        possibility = new int[factorial(numberOfTowns-1)][numberOfTowns+1];

        int[] route = new int[numberOfTowns+1];
        for (int i = 0; i <= numberOfTowns; i++){
            if (i == numberOfTowns){
                route[i] = 0;
            }else {
                route[i] = i;
            }
        }

        permutation(route,1,numberOfTowns);

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < factorial(numberOfTowns-1); i++){
            int totalDistance = 0;
            for (int j = 0; j < numberOfTowns;j++){
                totalDistance += distance[possibility[i][j]][possibility[i][j+1]];
            }
            if (shortest > totalDistance){
                shortest = totalDistance;
                route = possibility[i];
            }
        }

        System.out.println("Shortest costMatrix : " + shortest);
        System.out.print("Route : ");
        for (int r : route){
            System.out.print(alphabet[r]+" ");
        }

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
