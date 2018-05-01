package mower.logic;

import enums.ActionsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author - v.queignec
 */
@Data
@Builder
public class Command {

    private ActionsEnum order;
    @Builder.Default
    private boolean played = false;
}