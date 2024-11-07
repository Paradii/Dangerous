package Event;

import Charactor.*;

public class event {
    public static boolean checkHit(Whale whale,Wave wave,int whaleSize,int waveHeight){
        if(whale.x+whaleSize>wave.x&&whale.x<wave.x) {
            if(whale.y+whaleSize>=wave.y-waveHeight) {
                return true;
            }
        }
        return false;
    }

    public static void gameStop(Wave[] wave,Environment[] env) {

    }

}
