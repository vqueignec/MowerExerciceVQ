package environment;

import environment.mapCase.AbstractCase;
import environment.mapCase.Grass;

/**
 * @author - v.queignec
 */
public class World {
    private static AbstractCase[][] field;
    private static int x;
    private static int y;


    public static void initField(int x, int y) {
        field = new AbstractCase[x][y];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new Grass();
            }
        }
        World.x = x;
        World.y = y;
    }

    public static AbstractCase[][] getField() {
        return field;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
