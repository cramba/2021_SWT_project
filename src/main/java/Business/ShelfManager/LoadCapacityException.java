package Business.ShelfManager;

public class LoadCapacityException extends Exception {

	String error;

	public LoadCapacityException() {
		 error = " Die Ladekapazitaet wurde ueberschritten";
	}

	public String getError() {

		return error;
	}

}
