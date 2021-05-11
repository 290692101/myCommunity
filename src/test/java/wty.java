import java.util.ArrayList;
import java.util.List;

public class wty {
    static List<Integer> res=new ArrayList<>();
    public wty() {
        res.add(1);
    }
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("接下来是数组的二分查找：");
        // 二分查找（所要查找的数组必须有序）
        //int[] arr2 = new int[] { 1, 44, 55, 22, 44,44,44,-99, -56, 33, -65, 35, 60, -95 };
        int[] arr2 = new int[] { 44, 44, 44, 44, 44,44,44 };
        //先排序
        for (int i = 0; i < arr2.length - 1; i++) {
            for (int j = 0; j < arr2.length - 1; j++) {
                if (arr2[j] > arr2[j + 1]) {
                    int temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }
        for (int j : arr2) {
            System.out.print(j + "\t");
        }
        System.out.println("");
        int dest1=44;
        int head=0,end=arr2.length-1;
        int middle =0;
        boolean flag1 = false;
        while(head<end) {
          // middle = (head+end)/2;
//            middle=head+(end-head)/2;

            //找第一个位置
//             if(arr2[middle]<dest1) {//如果mid小于目标数字
//                head=middle+1;
//            }
//            else {
//                end=middle;
//            }
            //找最后一个位置
            middle=head+(end-head+1)/2;
            if(arr2[middle]>dest1){
                end=middle-1;

            }else{
                head=middle;
            }

        }

        if(arr2[head]==dest1) {//在后面对head进行判断
            System.out.println("找到目标了，位置是：" + head);
        }


    }
}
