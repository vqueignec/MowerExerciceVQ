package environment.mapCase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author - v.queignec
 * Exemple of another possble implementation of a case which wouldn't be accessible by mower.
 */
@Data
public class Wall extends AbstractCase{

    public Wall(){
        this.setAccessible(false);
    }
}
