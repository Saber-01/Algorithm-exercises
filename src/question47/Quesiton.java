package question47;

public class Quesiton {
    //从左上到右下角，要使得礼物价值最大。可以发现每一个格子最大的礼物是从它的上一个格子和左边一个格子中的最大价值加上它本身的价值就是最大价值
    //即 用g(i,j)代表 i,j位置的最大礼物值，则，g(i,j)=Max{g(i-1,j),g(i,j-1)}+value(i,j);
    //有了这个递归式，我们就可以用一个辅助数组来存储每一个格子的最大价值，以方便动态规划的递推。
    //而传统方法是创建一个同等大小矩阵的数组才存储这些最大价值。
    //分析发现用一维度数组即可，因为在新的一行矩阵的判断中，我们不需要存储i-1以上行的最大价值，
    //因此定义个一个等列的一维数组 maxValue，则maxValue的0到j-1位数存储当前i行的前j个格子的最大价值，而后j之后，保存i-1行的后n-j个格子礼物的最大价值
    public static int getMaxValueOfRoute (int[][] value) {
        if (value == null){
            System.out.println("the input value is null");
            return  0;
        }
        int[] maxValue = new int[value[0].length];
        for (int i = 0; i < value.length; i++) {
            for ( int j =0; j < value[0].length; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j-1];
                }
                maxValue[j] = Math.max(up,left) + value[i][j];
            }
        }
        return maxValue[value[0].length-1];
    }
    public static void main (String[] args) {
        int [][] value =new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println("the large value of the route is"+getMaxValueOfRoute(value));
    }
}
