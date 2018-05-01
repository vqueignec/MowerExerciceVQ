package basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author - v.queignec
 */
@Data
@AllArgsConstructor
@Builder
public class Position {

    private int x;
    private int y;
}
