package environment;

import environment.exceptions.ThatsMyHomeException;
import environment.mapCase.AbstractCase;
import environment.mapCase.Grass;
import mower.AbstractElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - v.queignec
 */
public class World {
    private static List<AbstractElement> elements;
    private static AbstractCase[][] field;
    private static int x;
    private static int y;


    public static void init(int x, int y) {
        //Indexes from 0 to x/y included
        field = new AbstractCase[x+1][y+1];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                //Could randomize the type of case or use an external schema ?
                field[i][j] = new Grass();
            }
        }
        World.x = x;
        World.y = y;

        elements = new ArrayList<>();
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

    public static void addAnElement(AbstractElement ele) throws ThatsMyHomeException {
        //Checking if the corresponding case is already occupied
        if(field[ele.getPosition().getX()][ele.getPosition().getY()].isOccupied())
             throw new ThatsMyHomeException();
        elements.add(ele);
        //The case is then occupied
        field[ele.getPosition().getX()][ele.getPosition().getY()].setOccupied(true);
    }

    public static ArrayList<AbstractElement> getElements(){
        return new ArrayList<>(elements);
    }

    public static void play(){
        elements.stream().forEach(e -> e.applyCommands());
    }
}
