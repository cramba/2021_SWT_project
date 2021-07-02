package Persistence;

import Business.Shelf.Shelf;
import Business.Package.Package;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import Business.ShelfManager.ShelfManager;
import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonHandler {
    /**
     * speichert das Regal und erstellt daraus eine JSON-Datei mit dem mitgegebenen Dateinamen
     * @param shelf das zu speichernde Regal
     * @param dateiname unter dem das Regal gespeichert werden soll
     */
    public static void saveShelfConfiguration(Shelf shelf, String dateiname) {
        JSONObject shelfSupports = new JSONObject();
        JSONArray shelfSupportArray = new JSONArray();
        shelf.getShelfSupports().forEach(
                singleShelfSupport -> {
                    JSONObject shelfSupport = new JSONObject();
                    shelfSupport.put("shelfSupportID", singleShelfSupport.getShelfSupportID());
                    shelfSupport.put("shelfLength", singleShelfSupport.getLength());
                    shelfSupport.put("positionX", singleShelfSupport.getPositionX());
                    shelfSupport.put("positionY", singleShelfSupport.getPositionY());
                    shelfSupportArray.add(shelfSupport);
                }
        );
        shelfSupports.put("shelfSupports", shelfSupportArray);

        JSONObject shelfFloors = new JSONObject();
        JSONArray shelfFloorArray = new JSONArray();
        shelf.getShelfFloors().forEach(
                singleShelfFloor -> {
                    JSONObject shelfFloor = new JSONObject();
                    shelfFloor.put("shelfFloorID", singleShelfFloor.getShelfFloorID());
                    shelfFloor.put("width", singleShelfFloor.getWidth());
                    shelfFloor.put("loadCapacity", singleShelfFloor.getLoadCapacity());
                    shelfFloor.put("positionX", singleShelfFloor.getPositionX());
                    shelfFloor.put("positionY", singleShelfFloor.getPositionY());
                    JSONArray packageListArray = new JSONArray();
                    for (Package pck : singleShelfFloor.getPackageList()) {
                        JSONObject packageObject = packageToJSONObject(pck);
                        packageListArray.add(packageObject);
                    }
                    shelfFloor.put("packageList", packageListArray);
                    shelfFloorArray.add(shelfFloor);
                }
        );
        shelfFloors.put("shelfFloors", shelfFloorArray);

        JSONObject shelfObject = new JSONObject();
        shelfObject.put("shelfSupports", shelfSupports);
        shelfObject.put("shelfFloors", shelfFloors);

        //Falls das Casten zu einem JSONArray beim parsen nicht funktionieren sollte,
        //die unteren Zeilen auskommentieren
//        JSONArray shelfArray = new JSONArray();
//        shelfArray.add(shelfSupports);
//        shelfArray.add(shelfFloors);
//        JSONObject shelfJSONObject = new JSONObject();
//        shelfJSONObject.put("shelf", shelfArray);

        try {
            //Dateipfad ist eventuell zu verändern
            FileWriter file = new FileWriter("./src/main/java/Dateien/" + dateiname + ".json");
            file.write(shelfObject.toJSONString());
            //file.write(shelfJSONObject.toJSONString());
            file.close();
            System.out.println("erfolgreich gespeichert");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * erstellt aus dem Objekt Package ein JSONObject
     * @param pck das umzuwandelnde Paket
     * @return Paket als JSONObject
     */
    public static JSONObject packageToJSONObject(Package pck) {
        JSONObject packet = new JSONObject();
        packet.put("name", pck.getName());
        packet.put("height", pck.getHeight());
        packet.put("width", pck.getWidth());
        packet.put("colour", pck.getColour().toString());
        packet.put("positionX", pck.getPositionX());
        packet.put("positionY", pck.getPositionY());
        JSONArray incompatibilityArray = new JSONArray();
        pck.getIncompatibility().forEach(
                incompatibilityColour -> {
                    incompatibilityArray.add(incompatibilityColour);
                }
        );
        packet.put("incompatibility", incompatibilityArray);

        if (pck.getPackagesAbove().size() != 0) {
            JSONArray packagesAbove = new JSONArray();
            pck.getPackagesAbove().forEach(
                    singlePackage -> {
                        JSONObject packageAbove;
                        packageAbove = packageToJSONObject(singlePackage);
                        packagesAbove.add(packageAbove);

                    }
            );
            packet.put("packagesAbove", packagesAbove);
        } else {
            packet.put("packagesAbove", null);
        }
        return packet;
    }


    /**
     * stellt aus einer JSON-Datei die Regalkonfgiration wieder her
     * @param selectedFile Datei
     * @param manager ShelfManager, wo das fertig erstellte Regal letztendlich untergebracht wird um in der Anwendung
     *                weiter damit arbeiten zu können
     */
    public static void recreateShelf(File selectedFile, ShelfManager manager){
        JSONParser parser = new JSONParser();
        Shelf shelf = new Shelf();

        try(FileReader reader = new FileReader(selectedFile)){
            Object obj = parser.parse(reader);
            JSONArray shelfArray = (JSONArray) obj;

            JSONObject shelfSupportObject = (JSONObject) shelfArray.get(0);
            shelf.setShelfSupports(parseShelfSupportObject(shelfSupportObject));

            JSONObject shelfFloorObject = (JSONObject) shelfArray.get(1);
            shelf.setShelfFloors(parseShelfFloorObject(shelfFloorObject));

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.setShelf(shelf);
    }

    /**
     * erstellt aus dem JSONObject mit dem darin befindendem JSONArray wieder eine ArrayList<ShelfSupport>
     * @param shelfSupportArrayObj
     * @return die ArrayList mit ShelfSupports
     */
    public static ArrayList<ShelfSupport> parseShelfSupportObject(JSONObject shelfSupportArrayObj){
        JSONArray shelfSupportArray = (JSONArray) shelfSupportArrayObj.get("shelfSupports");
        @SuppressWarnings("unchecked")
        Iterator<JSONObject> shelfSupportIterator = shelfSupportArray.iterator();
        ArrayList<ShelfSupport> shelfSupports = new ArrayList<>();
        while(shelfSupportIterator.hasNext()){
            ShelfSupport shelfSupport = parseSingleShelfSupportObject((JSONObject) shelfSupportIterator.next());
            shelfSupports.add(shelfSupport);
        }

        return shelfSupports;
    }

    /**
     * wandelt ein JSONObject, welches einen einzelnen ShelfSupport darstellt in ein ShelfSupport-Object zurück
     * @param shelfSupport
     * @return der fertige ShelfSupport
     */
    public static ShelfSupport parseSingleShelfSupportObject(JSONObject shelfSupport){
        int shelfSupportID = ((Number) shelfSupport.get("shelfSupportID")).intValue();
        int length = ((Number) shelfSupport.get("length")).intValue();
        int positionX = ((Number) shelfSupport.get("positionX")).intValue();
        int positionY = ((Number) shelfSupport.get("positionY")).intValue();
        return new ShelfSupport(shelfSupportID, length, positionX, positionY);
    }

    /**
     * erstellt aus dem JSON-Object eine ArrayList bestehend aus ShelfFloors
     * @param shelfFloorArrayObj JSONObject, welches ein JSONArray beinhaltet mit den Daten
     *                           von einzelnen ShelfFloors
     * @return ursprüngliche ArrayList mit den einzelnen ShelfFloors
     */
    public static ArrayList<ShelfFloor> parseShelfFloorObject(JSONObject shelfFloorArrayObj){
        JSONArray shelfFloorArray = (JSONArray) shelfFloorArrayObj.get("shelfSupports");
        @SuppressWarnings("unchecked")
        Iterator<JSONObject> shelfFloorIterator = shelfFloorArray.iterator();
        ArrayList<ShelfFloor> shelfFloors = new ArrayList<>();
        while(shelfFloorIterator.hasNext()){
            ShelfFloor shelfFloor = parseSingleShelfFloorObject((JSONObject) shelfFloorIterator.next());
            shelfFloors.add(shelfFloor);
        }

        return shelfFloors;
    }

    /**
     * wandelt ein einzelnes JSONObject eines JSONObjects ein ShelfFloor-Objekt um
     * @param shelfFloor JSONObject mit den einzelnen Merkmalen eines ShelfFloors
     * @return das wiederhergestellte ShelfFloor
     */
    public static ShelfFloor parseSingleShelfFloorObject(JSONObject shelfFloor){
        int shelfFloorID = ((Number) shelfFloor.get("shelfFloorID")).intValue();
        int width = ((Number) shelfFloor.get("width")).intValue();
        float ladCapacity = ((Double) shelfFloor.get("loadCapacity")).floatValue();
        int positionX = ((Number) shelfFloor.get("positionX")).intValue();
        int positionY = ((Number) shelfFloor.get("positionY")).intValue();

        JSONArray packageListArray = (JSONArray) shelfFloor.get("packageList");
        ArrayList<Package> packageList = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Iterator<JSONObject> packageIterator = packageListArray.iterator();
        while(packageIterator.hasNext()){
            Package pck = parsePackageObject((JSONObject) packageIterator.next());
        }

        return null;
    }

    /**
     * stellt ein Package.Object wieder her, indem es das JSONObject mit den Werten ausliest
     * @param packageObj JSONObject
     * @return Package-Object
     */
    public static Package parsePackageObject(JSONObject packageObj){
        String name = (String) packageObj.get("name");
        int height = ((Number) packageObj.get("height")).intValue();
        int width = ((Number) packageObj.get("width")).intValue();
        float weight = ((Double) packageObj.get("weight")).floatValue();
        Color colour = Color.valueOf((String) packageObj.get("colour"));
        float loadCapacity = ((Float) packageObj.get("loadCapacity")).floatValue();
        int positionX = ((Number) packageObj.get("positionX")).intValue();
        int positionY = ((Number) packageObj.get("positionY")).intValue();
        ArrayList<Color> incompatibility = parseIncompatibilityColours((JSONArray) packageObj.get("incompatibility"));
        ArrayList<Package> packagesAbove = parsePackagesAbove((JSONArray) packageObj.get("packagesAbove"));

        Package recreatedPck = new Package(name, height, width, weight, colour, loadCapacity);
        recreatedPck.setColour(colour);
        recreatedPck.setIncompatibility(incompatibility);
        recreatedPck.setPackagesAbove(packagesAbove);
        return recreatedPck;
    }

    /**
     * macht aus einem JSONArray eine ArrayList des Typs Color
     * @param colourArray JSONArray mit den Color als String
     * @return wiederhergestellte ArrayList des Typy Color
     */
    public static ArrayList<Color> parseIncompatibilityColours(JSONArray colourArray){
        ArrayList<Color> colorArrayList = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Iterator<JSONObject> colourIterator = colourArray.iterator();
        while(colourIterator.hasNext()){
            colorArrayList.add(Color.valueOf(colourIterator.next().toString()));
        }
        return colorArrayList;
    }

    /**
     * erstellt aus dem JSONArray wieder eine ArrayList des Typs Package
     * @param packagesArray JSONArray, welches die einzelnen Pakete als JSONObjects gesepichert hat
     * @return ArrayList vom Typ Package (fuer die Pakete, die sich auf dem direkt darüber befinden)
     */
    public static ArrayList<Package> parsePackagesAbove(JSONArray packagesArray){
        ArrayList<Package> packagesList = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Iterator<JSONObject> pckListIterator = packagesArray.iterator();
        while(pckListIterator.hasNext()){
            packagesList.add(parsePackageObject(pckListIterator.next()));
        }
        return packagesList;
    }
}
