import bigo.CountTask;

import java.util.ArrayList;
import java.util.List;

import static util.Utils.sleep;
import static util.Utils.timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("======TIMER EXAMPLE=======");
        timer(() -> sleep(1000), "1 second sleep");

        runCountingExample();
    }

    private static void runCountingExample() {
        List<Integer> inputVals = List.of(0, 50, 100, 150, 200, 300, 400);
        List<Long> dummyTimeConsumed = new ArrayList<>();
        List<Long> dummyTimeWithConstant1Consumed = new ArrayList<>();
        List<Long> dummyTimeWithConstant2Consumed = new ArrayList<>();
        List<Long> smartTimeConsumed = new ArrayList<>();

        System.out.println("======COUNTING EXAMPLES=======");
        var countTask = new CountTask();
        System.out.println("===Dummy Counting===");
        for (int inputVal : inputVals) {
            var time = timer(() -> countTask.dummyCalc(0, inputVal), "dummy calc from 0 to " + inputVal);
            dummyTimeConsumed.add(time);
        }
        System.out.println("===Dummy Counting With Constant 1===");
        for (int inputVal : inputVals) {
            var time = timer(() -> countTask.dummyCalcWithConstant1(0, inputVal), "dummy calc with constant 1 from 0 " + inputVal);
            dummyTimeWithConstant1Consumed.add(time);
        }
        System.out.println("===Dummy Counting With Constant 2===");
        for (int inputVal : inputVals) {
            var time = timer(() -> countTask.dummyCalcWithConstant2(0, inputVal), "dummy calc with constant 2 from 0 " + inputVal);
            dummyTimeWithConstant2Consumed.add(time);
        }
        System.out.println("===Smart Counting===");
        for (int inputVal : inputVals) {
            var time = timer(() -> countTask.startCalc(0, inputVal), "smart calc from 0 to " + inputVal);
            smartTimeConsumed.add(time);
        }


        System.out.println("===Excel Output For Counting Example===");
        for (int i = 0; i < dummyTimeConsumed.size(); i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", inputVals.get(i), dummyTimeConsumed.get(i),
                    dummyTimeWithConstant1Consumed.get(i), dummyTimeWithConstant2Consumed.get(i), smartTimeConsumed.get(i));
        }
    }
}