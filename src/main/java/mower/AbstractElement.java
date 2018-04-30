package mower;

import basic.Position;
import enums.DirectionsEnum;
import lombok.Data;

/**
 * @author - v.queignec
 */
@Data
public abstract class AbstractElement {

    private Position position;
    private DirectionsEnum direction;
}
