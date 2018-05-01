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
    @Builder.Default
    boolean mowed = false;

    public void setOccupied(boolean bool){
        this.occupied = bool;
        if(this.isOccupied())
            this.setAccessible(!this.isOccupied());
    }

    public void onEnter(){
        this.onEnter();
    }

    public void onLeave(){
        this.onLeave();
    }

    public void mowed(){
        this.mowed();
    }

}

