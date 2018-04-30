package mower;

import lombok.Data;
import mower.logic.MoveCommand;

/**
 * @author - v.queignec
 */
@Data
public abstract class AbstractMovable extends AbstractElement{

    private int speed;

    public void applyCommand(MoveCommand command){

    }
}
