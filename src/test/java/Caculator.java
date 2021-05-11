import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Caculator {
    public int calculate(String s) {
        //计算器的题分为3部分
        //一开始的特判处理比较特殊
        //1.简单的初始化 map,array,deque
        //2.遍历字符串的算法
        //3.辅助函数

        //特判处理
        s=s.replaceAll(" ","");
        s=s.replaceAll("\\(-","(0-");
        s=s.replaceAll("\\(\\+","(0+");
        //System.out.println(s);
        //初始化
        char[] cs=s.toCharArray();
        //双栈
        Deque<Integer> nums=new ArrayDeque<>();
        Deque<Character> ops=new ArrayDeque<>();
        //运算符对应的哈希表
        //初始化里面的put用分号隔
        Map<Character,Integer> pri=new HashMap<>();
        pri.put('+',1);
        pri.put('-',1);
        pri.put('*',2);
        pri.put('/',2);







        //遍历字符数组
        int n=cs.length;

        for(int i=0;i<n;i++){//使用i作为索引遍历字符串中的符号
            char c=cs[i];
            //分情况讨论
            if(c=='('){//只入栈
                ops.addLast(c);

            }else if(c==')'){
                //计算栈中内容 直到遇到前括号
                while(!ops.isEmpty()){
                    if(ops.peekLast()=='('){
                        //这里一定要弹出前括号
                        ops.pollLast();
                        break;

                    }else{
                        cacl(nums,ops);
                    }
                }

            }else if(isNum(c)){
                //从当前位置i开始一直向后遍历 将连续的数值取出
                int d=0;
                int j=i;
                while(j<n&&isNum(cs[j])){
                    d=10*d+(cs[j]-'0');
                    j++;

                }
                //结束循环时 j肯定不是数字 i要定位到j-1 因为for循环自带加一
                i=j-1;
                nums.addLast(d);

            }else{//如果c是操作符
                while(!ops.isEmpty()&&ops.peekLast()!='('
                        &&pri.get(c)<=pri.get(ops.peekLast())){//优先级小于操作符栈顶元素
                    cacl(nums,ops);
                }
                ops.addLast(c);
            }
        }
        //遍历完还是要计算哦

        while(!ops.isEmpty()){
            cacl(nums,ops);

        }
        return nums.peekLast();


    }

    public void cacl(Deque<Integer> nums,Deque<Character> ops){
        //第一个辅助函数 传入两个栈 计算值 并将计算结果压入nums


        //特判
        if(ops.isEmpty()){
            return;
        }
        if(nums.isEmpty()||nums.size()<2){
            return;
        }

        //待加入的数字
        int ans=0;
        //后进的数字是b
        int b=nums.pollLast();
        int a=nums.pollLast();
        //根据不同的运算符做不同的计算
        char c=ops.pollLast();
        if(c=='+'){
            ans=a+b;

        }else if(c=='-'){
            ans=a-b;
        }else if(c=='*'){
            ans=a*b;

        }else if(c=='/'){
            ans=a/b;

        }
        //将结果数字加入nums集合
        nums.addLast(ans);

    }

    //第二个辅助函数 判断一个字符是否是数字
    //感觉可以替换成另一种实现
    boolean isNum(char c){
        return Character.isDigit(c);

    }

    //测试函数
    public static void main(String[] args) {
        /*
        Caculator c=new Caculator();
        int res=c.calculate("(3+(1+2))/3");
        System.out.println(res);*/
        System.out.println(Math.floor(Math.sqrt(10)));
    }

}