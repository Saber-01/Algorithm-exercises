package question62;

import java.util.ArrayList;

public class Question {
    public static int LastRemaining_Solution (int n, int m) {
        if (n <= 0 || m < 1) {
            return -1;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            a.add(i);
        }
        int index = 0;
        while (a.size()> 1) {
            index = index + m - 1;
            index = index% a.size();
            a.remove(index);
        }
        return a.get(0);
    }
    public static void main (String[] args) {
        int n = 5, m =3;
        System.out.println(LastRemaining_Solution(n,m));
    }
}
