package Event;

import Charactor.*;

public class event {
    public static boolean checkHit(Whale whale, Wave wave, int whaleSize, int waveHeight) {
        return whale.x + whaleSize > wave.x && whale.x < wave.x && // Check horizontal overlap
                whale.y + whaleSize > wave.y && whale.y < wave.y + waveHeight; // Check vertical overlap
    }

    public static void gameStop(Wave[] wave,Environment[] env) {

    }

}
