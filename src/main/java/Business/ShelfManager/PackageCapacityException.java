package Business.ShelfManager;

public class PackageCapacityException extends Exception {

    String error;

    public PackageCapacityException() {

        error = " Die PacketKapazitaet wurde ueberschritten";
    }

    public String getError() {

        return error;
    }
    
}
