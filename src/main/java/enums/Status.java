package enums;

public enum Status {

    SEND("send"),
    MOVE("movable"),
    DEV("delivered");

    private String abbr;

    Status(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

}
