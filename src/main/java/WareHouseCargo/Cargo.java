package WareHouseCargo;

import enums.Status;

public class Cargo {

    private String box;
    private Status status;

    public Cargo(String box) {
        this.box = box;
    }

    public String getBox() {
        return box;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
