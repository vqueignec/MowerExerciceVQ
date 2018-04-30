package mower.logic;

import enums.MoveEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author - v.queignec
 */
@Data
@Builder
@AllArgsConstructor
public class MoveCommand {

    private MoveEnum order;
}

