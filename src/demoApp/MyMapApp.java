package demoApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.Viewpoint;
import javax.swing.JOptionPane;
public class MyMapApp extends Application {
    private  MapView mapView;
    @Override
    public void start(Stage stage) throws Exception {
        // create stack pane and application scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        // set title, size, and add scene to stage
        stage.setTitle("National Geographic: Newfoundland");
        stage.setWidth(900);
        stage.setHeight(900);
        stage.setScene(scene);
        stage.show();
        // create a ArcGISMap with the a Basemap instance with a National Geographic base layer
        ArcGISMap map = new ArcGISMap(Basemap.createNationalGeographic());
        // set the map to be displayed in this view
        mapView = new MapView();
        mapView.setMap(map);
        // set the viewpoint - this must be done after the setMap call above
        Viewpoint viewPoint = new Viewpoint(49.1, -55.8, 4100000);
        mapView.setViewpoint(viewPoint);

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
