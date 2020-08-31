package cc.oilslug.pauth.bot.utils;

import java.util.Random;

public class CodeGenUtil {

    public static int generate2FA(){
        Random random = new Random();
        int rand = random.nextInt(999999);
        return rand;
    }

}
