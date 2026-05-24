package WORKKKKKKKKKKKKKK;

public class puls {
    public static void main(String[] args) {
        int num=1;
        int sum=0;
        int count=0;
        while(num<=1000)
        {
            if(num%7==0||String.valueOf(num).contains("7"))
            {
                count++;
                sum += num;
            }
            num++;
        }
        System.out.println("1-1000之间共有"+count+"个数，和为"+sum);
    }
}
