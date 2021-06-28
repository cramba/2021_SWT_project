package Business.ShelfManager;

import Business.Package.Package;
import Business.Package.Colour;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private String errorMessage;

    public boolean checkCompatibility(ArrayList<Package> packageList, ArrayList<Package> newPackageList){
        // für jedes aktuelle Paket wird verglichen, ob in der FarbListe der neuen PaketListe die Farbe enthalten ist
        for(Package pck: packageList){
            for(Package nPck: newPackageList){
                for(Color color: nPck.getIncompatibility()){
                    if(pck.getColour() == color){
                        return false;
                    }
                }
            }
        }
        
        //neue PaketListe mit den aktuellen Paketen vergleichen, falls sich immer Farbkombinationen
        //sich nicht vertragen sollten, reicht ein Vergleichsblock aus
        for(Package nPck: newPackageList){
            for(Package pck: packageList){
                for(Color color: pck.getIncompatibility()){
                    if(nPck.getColour() == color){
                        return false;
                    }
                }
            }
        }
        
        return true;

    }
    
    public float checkLoadCapacity(ArrayList<Package> packageList, float loadCapacity){
        float loadWeight = 0;
        for(Package p: packageList){
            loadWeight += p.getWeight();
        }
        
        return loadCapacity - loadWeight;
    }
    
    public boolean checkOverhang(ArrayList<Package> packageList){
        return false;
    }
    
    public float checkPackageCapacity(ArrayList<Package> packageList){
        packageList.sort((Package p1, Package p2) -> {
            if(p1.getPositionX() > p2.getPositionX()){
                return 1;
            }else if(p1.getPositionX() < p2.getPositionX()){
                return -1;
            }
            return 0;
        });
        //List<Package> sorted_list = packageList.sort();
        
        return 0.0f;
    }

}
