/**
 * 
 * 
 *  @author  Jean Emmanuel Yannick Messey-Elouma
 *  @Course   Msc Computer science
 *  @StudentID  
 *  
 * 
 * ******************          
 *  
 * Using the javafx.scene.shape.Polygon class, write a class Upload.java
 * that displays an upload icon.
 * 
 * *****************
 * 
 */


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;








public class Upload extends Application{
	
	
	/**
	 * The function create Scene, which describes the Upload image.
	 * 
	 * 
	 * @param Scale 		This parameter scales the size of description.
	 * @param Y		        This parameter transfer y coordinate origin.
	 * @param X		        This parameter transfer x coordinate origin.
	 * 
	 */
	
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	Group root = new Group();	
    	
    	int Scale = 1;
    	
    	int X=300;
    			
    	int Y=20;
    	
        root.getChildren().add(createBottom(Scale, X, Y, Color.BLACK));
        root.getChildren().add(createArrow(Scale, X, Y, Color.BLACK)); 
        
        
        Scene scene = new Scene(root, 600, 400); 
        stage.setTitle("Upload");
    	stage.setScene(scene);
    	stage.show();
    }
    
    /**
     * A function which creates the Polyline of the arrow.
     * 
     * @param color			This parameter changes the colour of the polyline.
     * @param Scale 		This parameter scales the size of description.
	 * @param Y		        This parameter transfer y coordinate origin.
	 * @param X		        This parameter transfer x coordinate origin.
     * 
     * 
     * @return polygon of the arrow.
     */
    
    
    
    public Polygon createArrow( int Scale, int X, int Y, Color color) {
    	
    	double[] points = {X + Scale*0, Y + Scale * 0,  		X + Scale * 75, Y+ Scale * 50,  	
    			 X+ Scale * 25, Y + Scale * 50, X + Scale * 25, Y + Scale * 210,  
				   X - Scale *25, Y + Scale * 210, X - Scale * 25, Y + Scale * 50,  	
				   X - Scale * 75, Y + Scale * 50,  X + 0, Y + Scale * 0};
    	
    	Polygon polygon = new Polygon(points);
    	
    	polygon.setStroke(color);
    	
        polygon.setFill(color);
        
    	return polygon;
    }
    
    /**
     * This function creates the polyline of the bottom.
     * 
     * @param color			This parameter changes the colour of the polyline.
     * @param Scale 		This parameter scales the size of description.
	 * @param Y		        This parameter transfer y coordinate origin.
	 * @param X		        This parameter transfer x coordinate origin.
     * 
     * @return a polyline of the bottom.
     * 
     */
    
    
    public Polyline createBottom(int Scale, int X, int Y, Color color) {
    	
    	double[] points = {X + Scale * 140, Y + Scale *260,  
    			X + Scale * 140, Y + Scale *100, 
    			X + Scale * 190, 
    			Y+ Scale * 100,  
    			X + Scale *190, Y + Scale *320,  
				X - Scale * 190,Y + Scale * 320, 	
				X-Scale * 190, Y + Scale *100,	
				X - Scale * 140, Y + Scale *100,	
				X - Scale * 140, Y+ Scale * 260,
				X+Scale * 140, Y+ Scale *260};
    	
    	Polyline polygon = new Polyline(points);
    	
    	polygon.setStroke(color);
    	
        polygon.setFill(color);
        
    	return polygon;
    }

    /**
     * The function which launches the application.
     * 
     */
    
    public static void main(String[] args) { 
    	
    	
        launch(args);
    }
}




/**
 * 
 * 
 * ************* END OF CODE*****************.
 * 
 *
 */
