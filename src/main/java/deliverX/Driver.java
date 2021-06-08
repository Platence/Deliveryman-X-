package deliverX;

import WareHouseCargo.Cargo;
import enums.Status;
import infoPackage.maps.Maps;

public class Driver implements Runnable{

    private int distance;
    private final Cargo cargo;
    private Maps maps;

    public Driver(Cargo cargo,int sizeDistance) {
        this.cargo = cargo;
        maps = new Maps(sizeDistance);
    }

    public void run() {
        external();
    }

    private void external(){
        while (true){
            try { Thread.sleep(150); }
            catch (InterruptedException e) { e.printStackTrace();}

            synchronized (cargo){

                maps.printInfo(this);

                if(cargo.getStatus().equals(Status.SEND)){
                    cargo.setStatus(Status.MOVE);
                    System.out.println("DR :"+" Груз получен,выезжаю");
                    continue;
                }

                if(distance==15){
                    System.out.println("DR : " + "Прибыл в место назначения ");
                    cargo.setStatus(Status.DEV);
                    maps.printInfo(this);
                    cargo.notify();
                    break;
                }

                if(cargo.getStatus().equals(Status.MOVE)){
                    System.out.println("DR :" + " Пройдено " + getDistance() +
                                       " км." + " status : " + cargo.getStatus().getAbbr());
                }

                distance++;
                cargo.notify();
                try {cargo.wait(); }
                catch (InterruptedException e) { e.printStackTrace();}

            }
        }
    }

    public int getDistance() {
        return distance;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
