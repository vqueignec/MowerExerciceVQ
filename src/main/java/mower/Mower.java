package mower;

import basic.Position;
import enums.DirectionsEnum;
import lombok.Data;
import mower.logic.MoveCommand;
import mower.logic.MoveCommandMachine;

/**
 * @author - v.queignec
 */
@Data
public class Mower extends AbstractMovable {

    public Mower(int x, int y, DirectionsEnum direction) {
        setPosition(new Position(x, y));
        setDirection(direction);
        this.setSpeed(1);
    }

    public void applyCommand(MoveCommand command){
        MoveCommandMachine.apply(this, command);
    }
}
