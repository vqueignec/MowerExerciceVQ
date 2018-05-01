package mower;

import basic.Position;
import enums.DirectionsEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mower.logic.Command;

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

    public Optional<Command> getNextCommand() {
        return commands.stream().filter(c -> !c.isPlayed()).findFirst();
    }

    public void applyCommands() {

    }
}