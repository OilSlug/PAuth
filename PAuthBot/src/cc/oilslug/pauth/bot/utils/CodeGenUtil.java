package cc.oilslug.pauth.bot.utils;

import java.util.Random;

public class CodeGenUtil {

    public static int generate2FA(){
        Random random = new Random();
        long max = 9999999999L;
        long min = 1000000000L;
        int diff = (int)(max-min);
        int rand = (int)(random.nextInt(diff)+min);
        return rand;
    }

    public static String transform(int code){
        String[] values = String.valueOf(code).split("");
        String tCode = "";
        for(int i = 0; i < values.length; i++){
            if(i != 0) {
                if (i % 3 == 0) {
                    tCode += values[i] + "-";
                } else {
                    tCode += values[i];
                }
            }
        }
        return removeLastChar(tCode);
    }

    public static String removeLastChar(String message) {
        return (message == null || message.length() == 0) ? null : (message.substring(0, message.length() - 1));
    }

}
