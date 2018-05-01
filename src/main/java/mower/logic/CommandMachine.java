package mower.logic;

import basic.Position;
import enums.ActionsEnum;
import environment.World;
import mower.AbstractElement;
import mower.AbstractMovable;
import mower.logic.exception.InvalidTranslationMoveException;
import mower.logic.exception.WrongCommandTypeException;

/**
 * @author - v.queignec
 */
public class CommandMachine {

    public static void apply(AbstractElement element, Command command) throws InvalidTranslationMoveException, WrongCommandTypeException {
        switch (command.getOrder().getType()) {
            case STATIC_MOVE:
                applyRotation(element, command);
                break;
            case MOVE:
                applyTranslation(element, command);
                break;
            default:
                throw new WrongCommandTypeException(command, element);
        }
    }

    private static void applyRotation(AbstractElement element, Command command) throws WrongCommandTypeException {
        AbstractMovable movable;
        try {
            movable = (AbstractMovable) element;
        } catch (Exception e) {
            throw new WrongCommandTypeException(command, element);
        }
        if (command.getOrder().equals(ActionsEnum.G))
            movable.setDirection(movable.getDirection().getToLeft());
        else
            movable.setDirection(movable.getDirection().getToRight());
    }

    private static void applyTranslation(AbstractElement element, Command command) throws InvalidTranslationMoveException, WrongCommandTypeException {
        AbstractMovable movable;
        try {
            movable = (AbstractMovable) element;
        } catch (Exception e) {
            throw new WrongCommandTypeException(command, element);
        }

        //old position
        Position oldPosition = movable.getPosition();
        switch (movable.getDirection()) {
            case N:
                if (movable.getPosition().getY() <= World.getY() - movable.getSpeed() && World.getField()[movable.getPosition().getX()][movable.getPosition().getY() + movable.getSpeed()].isAccessible())
                    movable.getPosition().setY(movable.getPosition().getY() + movable.getSpeed());
                else
                    throw new InvalidTranslationMoveException();
                break;
            case W:
                if (movable.getPosition().getX() >= 0 + movable.getSpeed() && World.getField()[movable.getPosition().getX() - movable.getSpeed()][movable.getPosition().getY()].isAccessible())
                    movable.getPosition().setX(movable.getPosition().getX() - movable.getSpeed());
                else
                    throw new InvalidTranslationMoveException();
                break;
            case S:
                if (movable.getPosition().getY() >= movable.getSpeed() && World.getField()[movable.getPosition().getX()][movable.getPosition().getY() - movable.getSpeed()].isAccessible())
                    movable.getPosition().setY(movable.getPosition().getY() - movable.getSpeed());
                else
                    throw new InvalidTranslationMoveException();
                break;
            case E:
                if (movable.getPosition().getX() <= World.getX() - movable.getSpeed() && World.getField()[movable.getPosition().getX() + movable.getSpeed()][movable.getPosition().getY()].isAccessible())
                    movable.getPosition().setX(movable.getPosition().getX() + movable.getSpeed());
                else
                    throw new InvalidTranslationMoveException();
                break;
            default:
                throw new InvalidTranslationMoveException();
        }
        movable.actionOnMove(World.getCase(oldPosition), World.getCase(movable.getPosition()));
    }
}
