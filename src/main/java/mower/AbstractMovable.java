package mower;

import lombok.Data;
import mower.logic.Command;

/**
 * @author - v.queignec
 */
@Data
public abstract class AbstractMovable extends AbstractElement{

    private int speed;
}
