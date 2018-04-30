package enums;

/**
 * @author - v.queignec
 */
public enum MoveEnum {
    G(true),
    D(true),
    A(false);

    private final boolean staticMove;

    MoveEnum(boolean staticMove) {
        this.staticMove = staticMove;
    }

    public boolean isStaticMove() {
        return staticMove;
    }
}
