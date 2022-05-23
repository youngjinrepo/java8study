package sortFuntion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 공부하는김에 정리
public class sort {

    public static void main(String[] args) {
        usingArray();
    }

    //
    public static void usingArray() {
        String[] strArr = {"e","D","i","Y","a"};
        //asc
        Arrays.sort(strArr);
        System.out.println("======================================");
        for (String s : strArr) {
            System.out.println("s = " + s);
        }
        System.out.println("======================================");
        Arrays.sort(strArr, String::compareTo);
        for (String s : strArr) {
            System.out.println("s = " + s);
        }

        //desc
        Arrays.sort(strArr, Comparator.reverseOrder());
        System.out.println("======================================");
        for (String s : strArr) {
            System.out.println("s = " + s);
        }

        // 사용자 정의 desc
        Arrays.sort(strArr, new test1());
        System.out.println("======================================");
        for (String s : strArr) {
            System.out.println("s = " + s);
        }
    }

    public static class test1 implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
