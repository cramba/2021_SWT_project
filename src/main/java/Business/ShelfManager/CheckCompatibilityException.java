package Business.ShelfManager;

public class CheckCompatibilityException extends Exception {

	String error;

	public CheckCompatibilityException() {
		 error = " Kompatibilitaet stimmt nicht ueberein";


	}

	public String getError() {

		return error;
	}

}
