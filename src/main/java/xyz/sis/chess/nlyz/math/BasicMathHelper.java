package xyz.sis.chess.nlyz.math;

public class BasicMathHelper {

    public static int[] range8() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public static boolean inRange8(int i) {
        return i >= 0 && i < 8;
    }

}
