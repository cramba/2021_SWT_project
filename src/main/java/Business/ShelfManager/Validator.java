package Business.ShelfManager;

import Business.Package.Package;
import Business.Package.Colour;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public   class Validator {

    private String errorMessage;

    public boolean checkCompatibility(ArrayList<Package> packageList) {
		// fuer jedes aktuelle Paket wird verglichen, ob in der FarbListe der neuen
		// PaketListe die Farbe enthalten ist
		for (Package pck : packageList) {
			for (Color color1 : pck.getIncompatibility()) {
				for (Package pckS : packageList) {
					if (pckS.getColour() == color1) {
						// UNVERTRÄGLICHKEIT
                        return false;
					}
					while (pckS.getPackagesAbove().size() != 0) {
						if (pckS.getColour() == color1) {
							// UNVERTRÄGLICHKEIT
                            return false;
						}
						pckS.getPackagesAbove().get(0);
					}
				}
			}
			while (pck.getPackagesAbove().size() != 0) {
				if (pck.getIncompatibility().size() != 0) {
					for (Color color : pck.getIncompatibility()) {
						for (Package pckS : packageList) {
							if (pckS.getColour() == color) {
								// UNVERTRÄGLICHKEIT
                                return false;
							}
							while (pckS.getPackagesAbove().size() != 0) {
								if (pckS.getColour() == color) {
									// UNVERTRÄGLICHKEIT
                                    return false;
								}
								pckS.getPackagesAbove().get(0);
							}
						}
					}
				}
				pck = pck.getPackagesAbove().get(0);
			}
		}

		return true;

	}
    
    public static float checkLoadCapacityOld(ArrayList<Package> packageList, float loadCapacity) throws LoadCapacityException {
        float loadWeight = 0;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        for(Package p: packageList){
            //loadWeight += p.getWeight();
        	loadWeight += calculateLoadWeight(p);
            if(loadWeight > loadCapacity) {

            	throw new LoadCapacityException();

            }
        }

        return loadWeight;
    }

    public static float checkLoadCapacity(ArrayList<Package> packageList, float loadCapacity) throws LoadCapacityException {
        float loadWeight = 0;

        for(Package p: packageList){
            do {
            	loadWeight += p.getWeight();
            	if(p.getPackagesAbove().size() != 0) {
            		p = p.getPackagesAbove().get(0);
            	}
            }while(p.getPackagesAbove().size() != 0);
            
            if(loadWeight > loadCapacity) {
            	throw new LoadCapacityException();
            }
        }

        return loadWeight;
    }

    public static float calculateLoadWeight(Package pack) {

    	float weight = 0 ;


    	if(pack.getPackagesAbove().size()== 0) {
    		return pack.getWeight();
    	}else {
    		for(int i=0; i< pack.getPackagesAbove().size(); i++) {


    			weight+= calculateLoadWeight(pack.getPackagesAbove().get(i));

    		}
    	}

		return weight + pack.getWeight();

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

    // public float checkPackageCapacity(Package pck){
    //     float load = 0;
    //     if(pck.getPackagesAbove()fef)
    // }

}
