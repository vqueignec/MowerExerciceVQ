package environment.mapCase;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - v.queignec
 */
@Data
@NoArgsConstructor
public abstract class AbstractCase {

    @Builder.Default
    boolean accessible = true;
    @Builder.Default
    boolean occupied = false;

}

