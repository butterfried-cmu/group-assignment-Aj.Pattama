import java.util.Scanner;

/**
 * Created by TEEPOPUEANGSAWAT on 3/28/2017.
 */
public class Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of items : ");
        int numberOfItems = sc.nextInt();

        System.out.print("Limit weight : ");
        int limitWeight = sc.nextInt();

        int[][] items = new int[numberOfItems][2];
        System.out.println("\"weight value\"");
        for (int i=0; i<numberOfItems;i++ ){
            // weight
            items[i][0] = sc.nextInt();
            // price
            items[i][1] = sc.nextInt();
        }

        int numberOfPossibility = (int) Math.pow(2, numberOfItems);

        int maxPrice = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfPossibility; i++){
            int[] temp = new int[numberOfItems];
            int temp2 = i;
            for (int j = numberOfItems-1; j >= 0; j--){
                if (temp2%2 > 0) temp[j] = 1;
                temp2 = temp2/2;
            }

            int totalWeight = 0;
            int totalPrice = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 1){
                    totalWeight += items[j][0];
                    totalPrice += items[j][1];
                }
            }
            if (totalWeight <= limitWeight && totalPrice > maxPrice){
                maxPrice = totalPrice;
            }
        }

        System.out.println("Most valuable : " + maxPrice);
    }
}
