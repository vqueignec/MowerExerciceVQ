package environment.mapCase;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - v.queignec
 */
@Data
@NoArgsConstructor
public class Grass extends AbstractCase{

    private boolean mowed = false;
}
