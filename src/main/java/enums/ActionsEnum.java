package enums;

/**
 * @author - v.queignec
 */
public enum ActionsEnum {
    G(true),
    D(true),
    A(false);

    private final boolean staticMove;

    ActionsEnum(boolean staticMove) {
        this.staticMove = staticMove;
    }

    public boolean isStaticMove() {
        return staticMove;
    }
}
