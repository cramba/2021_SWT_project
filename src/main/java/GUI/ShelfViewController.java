package GUI;

import java.util.ArrayList;
import java.util.List;

import Business.Package.Package;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class ShelfViewController extends ViewController {

    ShelfView view;
    private ArrayList<Rectangle> shelfSupports;
    private ArrayList<Rectangle> oldshelfSupportsList;
    private ArrayList<Rectangle> oldshelfFloorsList;
    int lastdistanceX = 0;
    EditShelfViewController editShelfViewController;
    private ConfigurationViewController configurationViewController;

    int posX = 0;
    int posY = 0;


    //innere Klasse - wird aufgerufen wenn ShelfSupport angeklickt wird
    private class ShelfSupportHandler implements EventHandler<MouseEvent> {
        int id;

        public ShelfSupportHandler(int id) {
            this.id = id;
        }

        @Override
        public void handle(MouseEvent t) {
            //Loeschen button erscheint... Die zeile ist so gross da ich den Loeschen button dafuer hier rein bekommen musste um damit zu arbeiten

            ((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton().setVisible(true);

            //Listener fuer Loeschbutton..
            ((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton().setOnAction((e) -> {
                Rectangle currentFloor;

                for (int i = 0; i < shelfManager.getShelf().getShelfSupports().size(); i++) {

                    if (shelfManager.getShelf().getShelfSupports().get(i).getShelfSupportID() == id) {

                        currentFloor = view.getShelfSupports().get(i);


                        view.getChildren().remove(view.getShelfSupports().get(i)); //evtl auf index aendern
                        //Loescht Shelfsupport aus der Logic
                        shelfManager.deleteShelfSupport(i);
                        //Loescht Shelfsupport rectangles aus der ArrayList
                        ((ShelfView) root).getShelfSupports().remove(i);
                        //Loescht ShelfSupport rectangles aus der View

                    }
                }

            });

        }
    }

    //innere Klasse - wird aufgerufen, wenn ShelfSupport gedragged wird
    private class ShelfSupportHandlerForDrag implements EventHandler<MouseEvent> {
        int id;

        public ShelfSupportHandlerForDrag(int id) {
            this.id = id;
        }

        @Override
        public void handle(MouseEvent e) {

            Rectangle currentFloor;
            for (int i = 0; i < shelfManager.getShelf().getShelfSupports().size(); i++) {

                if (shelfManager.getShelf().getShelfSupports().get(i).getShelfSupportID() == id) {

                    //currentFloor = view.getShelfSupports().get(i);


                    view.getShelfSupports().get(i).setX(Math.round(e.getX() + view.getShelfSupports().get(i).getTranslateX()));
                    view.getShelfSupports().get(i).setY(Math.round(e.getY() + view.getShelfSupports().get(i).getTranslateY()));

                    // setzen der Positionen der Regalst�tze in der Logik
                    shelfManager.getShelf().getShelfSupports().get(i).setPositionX((int) Math.round(e.getX() + view.getShelfSupports().get(i).getTranslateX()));
                    shelfManager.getShelf().getShelfSupports().get(i).setPositionY((int) Math.round(e.getY() + view.getShelfSupports().get(i).getTranslateY()));

                    System.out.println("Regalst�tzeX:" + (int) Math.round(e.getX() + view.getShelfSupports().get(i).getTranslateX()));
                    System.out.println("Regalst�tzeY:" + (int) Math.round(e.getY() + view.getShelfSupports().get(i).getTranslateY()));

                    if (view.getShelfSupports().get(i).getTranslateX() < view.getTranslateX()) {
                        view.getShelfSupports().get(i).setX(Math.round(view.getTranslateX()));
                        shelfManager.getShelf().getShelfSupports().get(i).setPositionX((int) Math.round(view.getTranslateX()));
                    }
                    if ((view.getShelfSupports().get(i).getTranslateX() + view.getShelfSupports().get(i).getWidth()) > (view.getTranslateX() + view.getWidth())) { //---
                        view.getShelfSupports().get(i).setX((int) Math.round(view.getWidth() - view.getShelfSupports().get(i).getWidth())); //----

                        shelfManager.getShelf().getShelfSupports().get(i).setPositionX((int) Math.round(view.getWidth() - view.getShelfSupports().get(i).getWidth()));

                    }
                    if (view.getShelfSupports().get(i).getTranslateY() + view.getShelfSupports().get(i).getHeight() > view.getTranslateY() + view.getHeight()) { //--
                        view.getShelfSupports().get(i).setY(Math.round((view.getHeight()) - view.getShelfSupports().get(i).getHeight())); //-

                        shelfManager.getShelf().getShelfSupports().get(i).setPositionY((int) Math.round((view.getHeight()) - view.getShelfSupports().get(i).getHeight()));

                    }
                    if (view.getShelfSupports().get(i).getTranslateY() < view.getTranslateY()) {
                        view.getShelfSupports().get(i).setY(Math.round(view.getParent().getTranslateY()));

                        shelfManager.getShelf().getShelfSupports().get(i).setPositionY((int) Math.round(view.getParent().getTranslateY()));
                    }
                    e.consume();
                }
            }
        }
    }

    //innere Klasse - Handler beim Anklicken eines Regalbodens
    private class ShelfFloorHandler implements EventHandler<MouseEvent> {
        int id;

        public ShelfFloorHandler(int id) {
            this.id = id;
        }

        @Override
        public void handle(MouseEvent t) {
            //Loeschen button erscheint... Die zeile ist so gross da ich den Loeschen button dafuer hier rein bekommen musste um damit zu arbeiten

            ((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfFloorButton().setVisible(true);


            //Listener fuer Loeschbutton..
            ((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfFloorButton().setOnAction((e) -> {
                Rectangle currentFloor;

                for (int i = 0; i < shelfManager.getShelf().getShelfFloors().size(); i++) {

                    if (shelfManager.getShelf().getShelfFloors().get(i).getShelfFloorID() == id) {

                        currentFloor = view.getShelfFloors().get(i);


                        view.getChildren().remove(view.getShelfFloors().get(i)); //evtl auf index �ndern
                        //Loescht Shelfflooraus der Logic
                        shelfManager.deleteShelfFloor(i);
                        //Loescht Shelfloor rectangles aus der ArrayList
                        ((ShelfView) root).getShelfFloors().remove(i);
                        //Loescht Shelffloor rectangles aus der View

                    }
                }

            });

        }
    }

    //innere Klasse - Handler beim Draggen eines Regalbodens
    private class ShelfFloorHandlerForDrag implements EventHandler<MouseEvent> {

        int id;

        public ShelfFloorHandlerForDrag(int id) {
            this.id = id;
        }

        @Override
        public void handle(MouseEvent e) {

            Rectangle currentFloor;
            for (int i = 0; i < shelfManager.getShelf().getShelfFloors().size(); i++) {

                if (shelfManager.getShelf().getShelfFloors().get(i).getShelfFloorID() == id) {


                    view.getShelfFloors().get(i).setX(Math.round(e.getX() + view.getShelfFloors().get(i).getTranslateX()));
                    view.getShelfFloors().get(i).setY(Math.round(e.getY() + view.getShelfFloors().get(i).getTranslateY()));

                    // Positionen des Regalbodens
                    shelfManager.getShelf().getShelfFloors().get(i).setPositionX((int) Math.round(e.getX() + view.getShelfFloors().get(i).getTranslateX()));
                    shelfManager.getShelf().getShelfFloors().get(i).setPositionY((int) Math.round(e.getY() + view.getShelfFloors().get(i).getTranslateY()));
                    System.out.println("x:" + (int) Math.round(e.getX() + view.getShelfFloors().get(i).getTranslateX()));
                    System.out.println("y:" + (int) Math.round(e.getY() + view.getShelfFloors().get(i).getTranslateY()));

                    if (view.getShelfFloors().get(i).getTranslateX() < view.getTranslateX()) {
                        view.getShelfFloors().get(i).setX(Math.round(view.getTranslateX()));
                        shelfManager.getShelf().getShelfFloors().get(i).setPositionX((int) Math.round(view.getTranslateX()));
                    }

                    if ((view.getShelfFloors().get(i).getTranslateX() + view.getShelfFloors().get(i).getWidth()) > (view.getTranslateX() + view.getWidth())) { //---
                        view.getShelfFloors().get(i).setX(Math.round(view.getWidth() - view.getShelfFloors().get(i).getWidth()));

                        shelfManager.getShelf().getShelfFloors().get(i).setPositionX((int) Math.round(view.getWidth() - view.getShelfFloors().get(i).getWidth()));
                    }

                    if (view.getShelfFloors().get(i).getTranslateY() + view.getShelfFloors().get(i).getHeight() > view.getTranslateY() + view.getHeight()) { //--
                        view.getShelfFloors().get(i).setY((Math.round(view.getHeight()) - view.getShelfFloors().get(i).getHeight())); //-
                        shelfManager.getShelf().getShelfFloors().get(i).setPositionY((int) Math.round((view.getHeight()) - view.getShelfFloors().get(i).getHeight()));
                    }

                    if (view.getShelfFloors().get(i).getTranslateY() < view.getTranslateY()) {
                        view.getShelfFloors().get(i).setY(Math.round(view.getParent().getTranslateY()));

                        shelfManager.getShelf().getShelfFloors().get(i).setPositionY((int) Math.round(view.getParent().getTranslateY()));
                    }
                    shelfManager.checkShelfSupports(shelfManager.getShelf().getShelfFloors().get(i), (int) view.getMaxHeight());

                    view.getShelfFloors().get(i).setX(shelfManager.getShelf().getShelfFloors().get(i).getPositionX());
                    view.getShelfFloors().get(i).setY(shelfManager.getShelf().getShelfFloors().get(i).getPositionY());
                    view.getShelfFloors().get(i).setWidth(shelfManager.getShelf().getShelfFloors().get(i).getWidth());

                    e.consume();
                }
            }
        }
    }

    private class PackageHandler implements EventHandler<MouseEvent> {
        int id;

        public PackageHandler(int id) {
            this.id = id;
        }

        @Override
        public void handle(MouseEvent t) {
            //Loeschen button erscheint... Die zeile ist so gross da ich den Loeschen button dafuer hier rein bekommen musste um damit zu arbeiten


            configurationViewController.getView().getDeleteButton().setOnAction((e) -> {

                for (int i = 0; i < shelfManager.getShelf().getAllPackages().size(); i++) {
                    if (shelfManager.getShelf().getAllPackages().get(i).getPackageID() == id) {

                        view.getChildren().remove(view.getAllPackages().get(i));
                        shelfManager.deletePackage(i);
                        view.getAllPackages().remove(i);
                    }
                }
            });
        }
    }

    private class PackageHandlerForDrag implements EventHandler<MouseEvent> {
        int i;

        public PackageHandlerForDrag(int i) {
            this.i = i;
        }

        @Override
        public void handle(MouseEvent e) {

            //for (int i = 0; i < shelfManager.getShelf().getAllPackages().size(); i++) {
                //if (shelfManager.getShelf().getAllPackages().get(i).getPackageID() == id) {



                    if((int) Math.round(e.getX() + view.getAllPackages().get(i).getTranslateX()) != posX &&(int) Math.round(e.getY() + view.getAllPackages().get(i).getTranslateY()) != posY){


                    posX = (int) Math.round(e.getX() + view.getAllPackages().get(i).getTranslateX());
                    posY = (int) Math.round(e.getY() + view.getAllPackages().get(i).getTranslateY());
                    view.getAllPackages().get(i).setX(Math.round(e.getX() + view.getAllPackages().get(i).getTranslateX()));
                    view.getAllPackages().get(i).setY(Math.round(e.getY() + view.getAllPackages().get(i).getTranslateY()));

                    // setzen der Positionen der Pakete in der Logik
                    shelfManager.getShelf().getAllPackages().get(i).setPositionX((int) Math.round(e.getX() + view.getAllPackages().get(i).getTranslateX()));
                    shelfManager.getShelf().getAllPackages().get(i).setPositionY((int) Math.round(e.getY() + view.getAllPackages().get(i).getTranslateY()));

                    System.out.println("Package X:" + view.getAllPackages().get(i).getX());
                    System.out.println("Package Y:" +  view.getAllPackages().get(i).getY());

                    view.getAllPackages().get(i).getX();

                    if (view.getAllPackages().get(i).getTranslateX() < view.getTranslateX()) {
                        view.getAllPackages().get(i).setX(Math.round(view.getTranslateX()));
                        shelfManager.getShelf().getAllPackages().get(i).setPositionX((int) Math.round(view.getTranslateX()));
                    }
                    if ((view.getAllPackages().get(i).getTranslateX() + view.getAllPackages().get(i).getWidth()) > (view.getTranslateX() + view.getWidth())) { //---
                        view.getAllPackages().get(i).setX((int) Math.round(view.getWidth() - view.getAllPackages().get(i).getWidth())); //----

                        shelfManager.getShelf().getAllPackages().get(i).setPositionX((int) Math.round(view.getWidth() - view.getAllPackages().get(i).getWidth()));

                    }
                    if (view.getAllPackages().get(i).getTranslateY() + view.getAllPackages().get(i).getHeight() > view.getTranslateY() + view.getHeight()) { //--
                        view.getAllPackages().get(i).setY(Math.round((view.getHeight()) - view.getAllPackages().get(i).getHeight())); //-

                        shelfManager.getShelf().getAllPackages().get(i).setPositionY((int) Math.round((view.getHeight()) - view.getAllPackages().get(i).getHeight()));

                    }
                    if (view.getAllPackages().get(i).getTranslateY() < view.getTranslateY()) {
                        view.getAllPackages().get(i).setY(Math.round(view.getParent().getTranslateY()));

                        shelfManager.getShelf().getAllPackages().get(i).setPositionY((int) Math.round(view.getParent().getTranslateY()));
                    }


//    		            shelfManager.addPackageToShelfFloor(shelfManager.getShelf().getAllPackages().get(i));
//    		            System.out.println("handler Methode wird ausgefuehrt");
//                        view.getAllPackages().get(i).setX(shelfManager.getShelf().getAllPackages().get(i).getPositionX());
//                        view.getAllPackages().get(i).setY(shelfManager.getShelf().getAllPackages().get(i).getPositionY());

                    ShelfFloor floor;
                    floor = shelfManager.addPackageToShelfFloor(shelfManager.getShelf().getAllPackages().get(i));
//                    if (floor != null && floor.getPackageList().contains(shelfManager.getShelf().getAllPackages().get(i))) {
//                        floor.getPackageList().remove(shelfManager.getShelf().getAllPackages().get(i));
//                    }
                    view.getAllPackages().get(i).setX(shelfManager.getShelf().getAllPackages().get(i).getPositionX());
                    view.getAllPackages().get(i).setY(shelfManager.getShelf().getAllPackages().get(i).getPositionY());


                    //System.out.println("PaketID"+id);



                    //setRectanglePositions(floor.getPackageList(), id, i);
                    //e.consume();
             }

            }


        }


//    public void setRectanglePositions(List<Package> packageList, int pckID, int index){
//        for(Package p: packageList){
//            if(p.getPackageID() == pckID){
//                view.getAllPackages().get(index).setX(p.getPositionX());
//                view.getAllPackages().get(index).setY(p.getPositionY());
//            }else {
//                setRectanglePositions(p.getPackagesAbove(), pckID, index);
//            }
//        }
//    }


    public ShelfViewController(ShelfManager shelfManager, EditShelfViewController editShelfViewController, ConfigurationViewController configurationViewController) {
        super(shelfManager);
        view = new ShelfView();
        this.editShelfViewController = editShelfViewController;
        this.configurationViewController = configurationViewController;
        shelfSupports = new ArrayList<Rectangle>();


        root = view;
        initialize();
    }


    public void initialize() {

        //Zeigt Regalstuetze in GUI an wenn sie erstellt wurde
        shelfManager.getShelfSupportProp().addListener(new ChangeListener<ShelfSupport>() {

            @Override
            public void changed(ObservableValue<? extends ShelfSupport> observable, ShelfSupport oldValue, ShelfSupport newValue) {

                //distance aus logic holen
                //int aktdistanceX = shelfManager.getShelfSupportProp().getValue().getPositionX();

                //endgueltige distance
                // int finaldistanceX;

                //Regalstuetze fuer gui erstellen mit der Gewuenschten laenge - laenge wir aus der Logic geholt
                Rectangle shelfSupportRectangle = new Rectangle(0, 0, 10, shelfManager.getShelfSupportProp().getValue().getLength());

                //distance errechnen aus jetziger eingegebener Distance und den vorherigen
                //finaldistanceX = aktdistanceX + lastdistanceX;

                // neue letzte distance setzen
                //lastdistanceX = finaldistanceX;
                //shelfManager.getShelfSupportProp().getValue().setPositionX(finaldistanceX);


                //distanceX = 100 * shelfSupports.size();

                //Finale distance fuer Regalstuetze setzen
                //shelfSupportRectangle.setLayoutX(finaldistanceX);
                shelfManager.getShelfSupportProp().getValue().setPositionX((int) shelfSupportRectangle.getLayoutX());
                shelfManager.getShelfSupportProp().getValue().setPositionY((int) shelfSupportRectangle.getLayoutY());
                System.out.println("Regalst�tzeX:" + shelfManager.getShelfSupportProp().getValue().getPositionX());
                System.out.println("Regalst�tzeY:" + shelfManager.getShelfSupportProp().getValue().getPositionY());

                //Arraylist von Shelfsupport-Rectangles = neues Rectangle hinzufuegen
                ((ShelfView) root).getShelfSupports().add(shelfSupportRectangle);

                //Rectangle soll auf Boden stehen
                AnchorPane.setBottomAnchor(shelfSupportRectangle, 0.0);

                //ShelfSupportRectangle in View einsetzen
                ((ShelfView) root).getChildren().addAll(shelfSupportRectangle);


                //MouseListener fuer alle -ShelfSupport-Rectangles im Programm- Wird einer Geklickt wird Innere Klasse ShelfSupportHandler(Ganz oben in dieser Klasse zu finden) aufgerufen
                shelfSupportRectangle.setId(shelfManager.getShelfSupportProp().getValue().getShelfSupportID() + "");
                shelfSupportRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, new ShelfSupportHandler(shelfManager.getShelfSupportProp().getValue().getShelfSupportID()));
                shelfSupportRectangle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new ShelfSupportHandlerForDrag(shelfManager.getShelfSupportProp().getValue().getShelfSupportID()));

            }

        });

//        for (int i = 0; i < ((ShelfView) root).getShelfSupports().size(); i++) {
//
//            //view.getShelfSupports().get(i).setOnMouseClicked(new ShelfSupportHandler(i));
//
//
//        	view.getShelfSupports().get(i).setId(+shelfManager.getShelf().getShelfSupports().get(i).getShelfSupportID()+"");
//            view.getShelfSupports().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, new ShelfSupportHandler(shelfManager.getShelf().getShelfSupports().get(i).getShelfSupportID()));
//            view.getShelfSupports().get(i).addEventHandler(MouseEvent.MOUSE_DRAGGED, new ShelfSupportHandlerForDrag(shelfManager.getShelf().getShelfSupports().get(i).getShelfSupportID()));
//
//
//        }
        oldshelfSupportsList = new ArrayList<Rectangle>(((ShelfView) root).getShelfSupports());

        shelfManager.getShelfFloorProp().addListener(new ChangeListener<ShelfFloor>() {

            @Override
            public void changed(ObservableValue<? extends ShelfFloor> observable, ShelfFloor oldValue, ShelfFloor newValue) {

                Rectangle shelfFloorRectangle = new Rectangle(0, 0, 100, 10);
                shelfFloorRectangle.setLayoutX(shelfManager.getShelfFloorProp().getValue().getPositionX());
                shelfFloorRectangle.setLayoutY(shelfManager.getShelfFloorProp().getValue().getPositionY());

                view.getShelfFloors().add(shelfFloorRectangle);

                ((ShelfView) root).getChildren().addAll(shelfFloorRectangle);

                shelfFloorRectangle.setId(shelfManager.getShelfFloorProp().getValue().getShelfFloorID() + "");
                shelfFloorRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, new ShelfFloorHandler(shelfManager.getShelfFloorProp().getValue().getShelfFloorID()));
                shelfFloorRectangle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new ShelfFloorHandlerForDrag(shelfManager.getShelfFloorProp().getValue().getShelfFloorID()));

            }

        });


        //packetProperty:


        shelfManager.packageProp().addListener(new ChangeListener<Package>() {

            @Override
            public void changed(ObservableValue<? extends Package> observable, Package oldValue, Package newValue) {
                // TODO Auto-generated method stub

                Rectangle packet = new Rectangle();
                Package pack = newValue;
                int width = pack.getWidth();
                int height = pack.getHeight();
                int posWidth = (width / 2) * (-1);
                int posHeight = (height / 2) * (-1);
                packet.setX(0);
                packet.setY(0);
                packet.setWidth(width);
                packet.setHeight(height);
                packet.setFill(pack.getColour());
                view.getAllPackages().add(packet);
                view.getChildren().addAll(packet);



                packet.setId(pack.getPackageID() + "");



                packet.addEventHandler(MouseEvent.MOUSE_CLICKED, new PackageHandler(pack.getPackageID()));
                //packet.addEventHandler(MouseEvent.MOUSE_DRAGGED, new PackageHandlerForDrag(pack.getPackageID()));
                packet.addEventHandler(MouseEvent.MOUSE_DRAGGED,new PackageHandlerForDrag(shelfManager.getShelf().getAllPackages().indexOf(pack)));




            }


        });


    }
}