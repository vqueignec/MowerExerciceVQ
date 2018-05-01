package mower;

import basic.Position;
import enums.DirectionsEnum;
import environment.mapCase.AbstractCase;
import lombok.Builder;
import lombok.Data;
import mower.logic.Command;
import mower.logic.CommandMachine;

import java.util.ArrayList;

/**
 * @author - v.queignec
 */
@Data
public class Mower extends AbstractMovable {

    @Builder
    public Mower(int x, int y, DirectionsEnum direction) {
        setPosition(new Position(x, y));
        setDirection(direction);
        this.setSpeed(1);
    }

    public void actionOnMove(AbstractCase currentCase, AbstractCase nextCase){
        super.actionOnMove(currentCase, nextCase);
        nextCase.mowed();
    }
}
