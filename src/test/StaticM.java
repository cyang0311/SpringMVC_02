package test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticM {
     static int id = 5974;

    public static void show(){
        System.out.println("静态方法");
    }
    public void show2(){
        System.out.println("普通方法");
    }


}
class Test{
    public static void main(String[] args) {
        Date date =new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(new SimpleDateFormat("YYYY-MM-dd  hh:mm:ss").format(date));
        long now = date.getTime()-1000*10;
        System.out.println(new SimpleDateFormat("YYYY-MM-dd  hh:mm:ss").format(now));
        Integer i=7;
        System.out.println(i.compareTo(10));
        System.out.println(Integer.parseInt("123"));
        Double a=1.1;
        System.out.println(Double.valueOf(a));

        DecimalFormat format = new DecimalFormat("###,###.###");
        System.out.println(format.format(123456.78));
        DecimalFormat format1 = new DecimalFormat("##.##%");
        System.out.println(format1.format(0.456));


    }
}
