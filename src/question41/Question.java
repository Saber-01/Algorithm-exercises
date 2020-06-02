package question41;

public class Question {
    public static void main(String[] args){
        DynamicArray array=new DynamicArray();
        array.Insert(1);
        array.Insert(2);
        System.out.print(" "+array.GetMedian());
        array.Insert(3);
        System.out.print(" "+array.GetMedian());
        array.Insert(4);
        System.out.print(" "+array.GetMedian());
        array.Insert(5);
        System.out.print(" "+array.GetMedian());
        array.Insert(6);
        System.out.print(" "+array.GetMedian());
        array.Insert(7);
        System.out.print(" "+array.GetMedian());
    }
}
