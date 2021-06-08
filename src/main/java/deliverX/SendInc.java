package deliverX;

import WareHouseCargo.Cargo;
import enums.Status;

public class SendInc implements Runnable {

    private final Cargo cargo;

    public SendInc(Cargo cargo) {
        this.cargo = cargo;
    }

    public void run() {
        System.out.println("Отправка груза...");
        cargo.setStatus(Status.SEND);
        new Thread(new Driver(cargo,15)).start();
        new Thread(new RecipientInc(cargo)).start();
        ext();
    }

    private void ext() {

        while (true){

            synchronized (cargo){

                if(cargo.getStatus().equals(Status.DEV)){
                    System.out.println("SI :" +" Груз был доставлен.");
                    cargo.notify();
                    break;
                }

                System.out.println("SI : " + "Статус груза : " + cargo.getStatus().getAbbr());
                cargo.notify();
                try { cargo.wait();}
                catch (InterruptedException e){ e.printStackTrace(); }
            }

            try { Thread.sleep(200); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }

    }

}
