package mower;

import basic.Position;
import enums.DirectionsEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mower.logic.Command;
import mower.logic.CommandMachine;
import mower.logic.exceptions.InvalidTranslationMoveException;
import mower.logic.exceptions.WrongCommandTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author - v.queignec
 */
@Data
public abstract class AbstractElement {

    private Position position;
    private DirectionsEnum direction;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    private Optional<Command> getNextCommand() {
        return commands.stream().filter(c -> !c.isPlayed()).findFirst();
    }

    public void applyCommands() {
        Optional<Command> commandToExec = this.getNextCommand();
        while (commandToExec.isPresent())
            try {
                CommandMachine.apply(this, commandToExec.get());
            } catch (InvalidTranslationMoveException e) {
                //Do nothing except logging/printing, let the show going on !
                System.out.println(e.getMessage());
            } catch (WrongCommandTypeException e) {
                //Do nothing except logging/printing, let the show going on !
                System.out.println(e.getMessage());
            } finally {
                commandToExec.ifPresent(c -> c.setPlayed(true));
                commandToExec = this.getNextCommand();
            }
    }
}