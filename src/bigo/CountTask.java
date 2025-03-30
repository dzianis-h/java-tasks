package bigo;

import static util.Utils.sleep;

// what is O ?
public class CountTask {
    public int dummyCalc(int from, int to) {
        int count = 0;
        for (int i = from; i < to; i++) {
            sleep(10); // some operations here
            count ++;
        }
        return count;
    }

    public int dummyCalcWithConstant1(int from, int to) {
        sleep(500); // some one-time heavy load here
        int count = 0;
        for (int i = from; i < to; i++) {
            sleep(10); // some operations here
            count ++;
        }
        return count;
    }

    public int dummyCalcWithConstant2(int from, int to) {
        sleep(1500); // some one-time heavy load here
        int count = 0;
        for (int i = from; i < to; i++) {
            sleep(3); // some operations here
            count ++;
        }
        return count;
    }

    public int startCalc(int from, int to) {
        sleep(50); // some one-time load here
        return to - from;
    }
}
