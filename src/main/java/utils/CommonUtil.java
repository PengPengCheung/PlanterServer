package utils;

public class CommonUtil {

    private static final boolean DEBUG = true;
    
    public static int getMinimumNum(int x, int y, int z){
        int min = x;
        if(y < min){
            min = y;
        }
        
        if(z < min){
            min = z;
        }
        
        return min;
    }

    public static void printLog(String msg){
        if(DEBUG){
            System.out.println(msg);
        }
    }

    public static int getRandomInt(int total){
        if(total < 0){
            total = 0;
        }

        if(total >= Integer.MAX_VALUE){
            total = Integer.MAX_VALUE;
        }

        int randomNum = (int)(Math.random() * total);
        return randomNum;
    }

    public static String getRandomCode(){
        double originCode = Math.random() * 9 + 1;
        int code = (int)(originCode*100000);
        return String.valueOf(code);
    }
}