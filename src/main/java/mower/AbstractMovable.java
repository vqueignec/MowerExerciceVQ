package mower;

import environment.mapCase.AbstractCase;
import lombok.Data;
import mower.logic.Command;

/**
 * @author - v.queignec
 */
@Data
public abstract class AbstractMovable extends AbstractElement{

    private int speed;

    public void actionOnMove(AbstractCase currentCase, AbstractCase nextCase){
        currentCase.onLeave();
        nextCase.onEnter();
    }
}
