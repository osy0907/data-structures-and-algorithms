package algorithms.greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        fractionalKnapsack.knapsackFunc(objectList, 30.0);
    }

    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, (objectItem1, objectItem2) -> (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]));

        for (int index = 0; index < objectList.length; index++) {
            if ((capacity - (double) objectList[index][0]) > 0) {
                capacity -= (double) objectList[index][0];
                totalValue += (double) objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1]);
            } else {
                fraction = capacity / (double) objectList[index][0];
                totalValue += (double) objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }
}
