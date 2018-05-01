package mower.logic.exceptions;

import mower.AbstractElement;
import mower.logic.Command;

/**
 * @author - v.queignec
 */
public class WrongCommandTypeException extends Exception{

    public WrongCommandTypeException(Command command, AbstractElement element) {
        super("I don't know how to do that, a "+ element.getClass().getName() + " can't do the command of type " + command.getOrder().getType());
    }
}
