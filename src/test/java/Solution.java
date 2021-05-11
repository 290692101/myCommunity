import java.util.*;

class Solution {
    public int clumsy(int N) {
        //使用双栈实现运算符的计算

        //操作符与优先级对应的哈希表
        Map<Character,Integer> map=new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);

        //操作符栈
        Deque<Character> ops=new ArrayDeque<>();
        //数字栈
        Deque<Integer> nums=new ArrayDeque<>();
        //操作符数组 用于计算
        char[] ccc=new char[]{'*','/','+','-'};


        //遍历计算阶乘
        for(int i=N,j=0;i>=1;i--,j++){
            char op=ccc[j%4];
            System.out.println(op);
            nums.addLast(i);
            //如果当前的操作符优先级小于等于栈顶的优先级
            //就把栈中的数字先计算了
            if(!ops.isEmpty()&&map.get(op)<=map.get(ops.peekLast())){
                Cac(ops,nums);

            }
            if(i>1){//如果是最后一个数字 则不添加运算符
                ops.addLast(op);
            }


        }



        while(!ops.isEmpty()){
            Cac(ops,nums);
        }
        return nums.peekLast();
    }

    //根据栈来计算的函数
    public void Cac(Deque<Character> ops, Deque<Integer> nums){
        //从操作符栈中弹出操作符
        //从数字栈中弹出两个数字
        //计算以后重新压栈

        if(nums.size()>=2){
            int a=nums.pollLast();
            int b=nums.pollLast();
            char c=ops.pollLast();

            if(c=='+'){
                nums.addLast(a+b);

            }else if(c=='-'){
                nums.addLast(a-b);

            }else if(c=='*'){
                nums.addLast(a*b);

            }else if(c=='/'){
                nums.addLast(b/a);

            }
        }else{
            return;
        }

    }


    static class IntComparator implements Comparator {



        @Override
        public int compare(Object o1, Object o2) {
            int a=(int) o1;
            int b=(int) o2;
            if(a>b){
                return 1;

            }else{
                return -1;
            }
            //return 0;
        }
    }

    static int seri(int n){
        List<Integer> ss=new ArrayList<>();
        while(n>0){
            int d=n%10;
            n=n/10;
            ss.add(d);

        }
        Collections.sort(ss);

        int res=0;
        for(int i=ss.size()-1;i>=0;i--){
            int s=ss.get(i);
            res=res*10+s;

        }
        return res;

    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] n=new int[]{1,3,5,2,4,6};
        //Arrays.sort(n,new IntComparator());
        //int res=s.clumsy(4);
        int res=seri(10);
        System.out.println();

    }
}