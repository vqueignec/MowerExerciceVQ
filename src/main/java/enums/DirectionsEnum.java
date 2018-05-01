package enums;

/**
 * @author - v.queignec
 */
public enum DirectionsEnum {
    N("W","E"),
    E("N","S"),
    W("S","N"),
    S("E","W");

    private String toLeft;
    private String toRight;

    DirectionsEnum(String toLeft, String toRight) {
        this.toLeft = toLeft;
        this.toRight = toRight;
    }

    public DirectionsEnum getToLeft() {
        return DirectionsEnum.valueOf(toLeft);
    }

    public DirectionsEnum getToRight() {
        return DirectionsEnum.valueOf(toRight);
    }
}
