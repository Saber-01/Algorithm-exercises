package question63;

public class Question {
    //注意到股票是有时间节点的。所以往后遍历只需要关注前面i个值中出现的最小值即可，
    //只需要每次遍历时候，等同于，每次判断以numbers[i]价格卖出时，可能获得的最大利润
    //所以每次遍历需要维护min和maxProfit;
    public static int findMaxProfit(int[] numbers) {
        int maxProfit = 0;
        if (numbers.length < 2) {
            return maxProfit;
        }
        maxProfit = numbers[1] - numbers[0];
        int min = numbers[0]; //保存遍历位置前的最小值。
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - min > maxProfit) {//判断当前股票价格卖出的可能最大收益和历史最大收益比较。
                maxProfit = numbers[i] - min;
            }
            if (numbers[i] < min)  //维护min.
                min = numbers[i];
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] numbers =new int[] {9,1,0};
        int maxProfit = findMaxProfit(numbers);
        System.out.println(maxProfit);
    }
}
