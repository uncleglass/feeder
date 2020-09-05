package pl.uncleglass.feeder.domain;

public enum ProductUnit {
    GRAM(0),
    PIECE(1),
    PACKET(2),
    MILLILITRE(3);

    private final int code;

    ProductUnit(int code) {
        this.code = code;
    }

    public static ProductUnit fromCode(int code) {
        if (code == 0) {
            return GRAM;
        }
        if (code == 1) {
            return PIECE;
        }
        if (code == 2) {
            return PACKET;
        }
        if (code == 3) {
            return MILLILITRE;
        }
        throw new UnsupportedOperationException(
                "The code \"" + code + "\" is not supported!"
        );
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        switch (this) {
            case GRAM:
                return "gram";
            case PIECE:
                return "sztuka";
            case PACKET:
                return "opakowanie";
            case MILLILITRE:
                return "militry";
            default:
                throw new IllegalArgumentException();
        }
    }
}
