package cc.oilslug.pauth;

import cc.oilslug.pauth.bot.Bot;

public class PAuth {

    public static void main(String[] args) {
        try {
            new Bot();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
