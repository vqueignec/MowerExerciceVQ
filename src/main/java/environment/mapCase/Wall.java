package environment.mapCase;

import lombok.Data;

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
