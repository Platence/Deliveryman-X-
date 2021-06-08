package deliverX;

import WareHouseCargo.Cargo;
import enums.Status;

public class RecipientInc implements Runnable{

    private final Cargo cargo;

    public RecipientInc(Cargo cargo) {
        this.cargo = cargo;
    }

    public void run() {
        ext();
    }

    private void ext(){

        while (true){

            try { Thread.sleep(220); }
            catch (InterruptedException e) { e.printStackTrace();}

            synchronized (cargo){

                if(!cargo.getStatus().equals(Status.DEV)){
                    System.out.println("RI : " + "Ожидаю получение груза... " + cargo.getStatus().getAbbr());
                    cargo.notify();
                    try {cargo.wait();}
                    catch (InterruptedException e) { e.printStackTrace(); }
                    continue;
                }

                System.out.println("RI : " + "Груз получен! ");
                cargo.notify();
                break;
            }
        }
    }

}
