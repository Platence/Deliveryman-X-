package bigboss;

import WareHouseCargo.Cargo;
import deliverX.SendInc;

public class BigBoss {

    public BigBoss() {
        doing();
    }

    private void doing(){
        Cargo cargo = new Cargo("X");
        new Thread(new SendInc(cargo)).start();
    }
}
