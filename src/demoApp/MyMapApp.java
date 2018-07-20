package demoApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import javax.swing.JOptionPane;
public class MyMapApp extends Application {
    private  MapView mapView;
    @Override
    public void start(Stage stage) throws Exception {
        // create stack pane and application scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        // set title, size, and add scene to stage
        stage.setTitle("Display Map Sample");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
        // create a ArcGISMap with the a Basemap instance with an Imagery base layer
        ArcGISMap map = new ArcGISMap(Basemap.createImagery());
        // must be an ArcGIS Online or local ArcGIS Portal map.
        //map.setBasemap(new Basemap("https://www.arcgis.com/home/webmap/viewer.html?webmap=b834a68d7a484c5fb473d4ba90d35e71"));
        // set the map to be displayed in this view
        mapView = new MapView();
        mapView.setMap(map);
        // add the map view to stack pane
        stackPane.getChildren().addAll(mapView);
    }

    /**
     * Stops and releases all resources used in application.
     */
    @Override
    public void stop() {
        if (mapView != null) {
            mapView.dispose();
        }
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Opens and runs application.
     *
     * @param args arguments passed to this application
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
