package enums;

/**
 * @author - v.queignec
 */
public enum ActionsEnum {
    G(ActionTypeEnum.STATIC_MOVE),
    D(ActionTypeEnum.STATIC_MOVE),
    A(ActionTypeEnum.MOVE);

    private final ActionTypeEnum type;

    ActionsEnum(ActionTypeEnum type) {
        this.type = type;
    }

    public ActionTypeEnum getType() {
        return type;
    }
}
