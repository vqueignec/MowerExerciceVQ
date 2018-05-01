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

    public void onEnter(){
        this.setOccupied(true);
        this.setAccessible(this.isOccupied());
    }

    public void onLeave(){
        this.setOccupied(false);
        this.setAccessible(this.isOccupied());
    }

    public void mowed(){
        setMowed(true);
    }
}
