package algorithms.recursion;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysSum {
    public static void main(String[] args) {
        ArraysSum arraysSum = new ArraysSum();
        System.out.println(arraysSum.factorialFunc(testData()));
    }

    public static ArrayList<Integer> testData() {
        return IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int factorialFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + this.factorialFunc(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }
}
