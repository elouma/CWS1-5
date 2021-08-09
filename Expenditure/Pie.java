/*** 
 * 
 *  @author  Jean Emmanuel Yannick Messey-Elouma
 *  @Course   Msc Computer science
 *  @StudentID  
 *  
 *  
 *  
 * 
 * ****************** 
 * 
 * A class Pie.java to represent all expenditures in a corresponding array of type Expenditure, 
 * with a method public void start(Stage stage) throws Exception that displays the expenditures
 *  as a pie chart with the description placed next to the corresponding part of the pie chart
 * 
*/





import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * 
 * 
 * 
 * @param expenditures 		This variable includes expenditures.
 * @param AllValues			This variable is the sum of all expenditures in @param expenditures.
 * @param RADIUS			This is the radius of Pie chart.
 * @param space				This is a space between Pie chart and text.
 * @param X			This variable adjusts the x coordinate origin.
 * @param Y			This variable adjusts the y coordinate origin.
 *
 *
 *
 */

public class Pie extends Application{
		
		private static Expenditure[] expenditures;
		
		private static int AllValues;
		private final int X = 500, Y = 200, RADIUS = 100;
		private double space = 1.3;
	
		
		
		/**
		 * 
		 * 
		 * The function creates the Pie chart.
		 * 
		 * 
		 */
		
		
		@Override
	    public void start(Stage stage) throws Exception {
			
		 	Group root = new Group();
		 	
	    	
		 	Circle circle = new Circle(X, Y, RADIUS);
		 	
		 	circle.setFill(null);
		 	
		 	circle.setStroke(Color.BLACK);
		 	
		 	root.getChildren().add(circle);
		 	
		 	
		 	
		 	
		 	Line[] lines = new Line[10];
		 	
		 	int ratio=0
		 			;
		 	for(int i=0; i<8; i++) {
		 		ratio +=(i==7)? 360-ratio : Math.round(1.0*expenditures[i].getValue()/AllValues*360);
		 		
		 		lines[i] = new Line(X, Y, X+RADIUS*Math.cos(Math.toRadians(ratio)), 
		 				
		 				Y-RADIUS*Math.sin(Math.toRadians(ratio)));
		 		
		 		root.getChildren().add(lines[i]);
		 	}
		 	
		 	
		 	ratio=0;
		 	
		 	int FONTSIZE = 20;
		 	
		 	for(int i=0; i<8; i++) {
		 		
		 		int x=0;
		 		int y=0;
		 		
		 		Text SubText = new Text(0,0, expenditures[i].getDescription());
		 		
		 		System.out.println(SubText.getWrappingWidth());
		 		
		 		int angle = (int)Math.round(1.0*expenditures[i].getValue()/AllValues*360);
		 		
		 		if(ratio+angle/2 < 90 || 270 <ratio+angle) {
		 			
		 			x = (int)(X+space*RADIUS*Math.cos(Math.toRadians(ratio+angle/2)));
		 		}else {
		 			x = (int)(X+space*RADIUS*Math.cos(Math.toRadians(ratio+angle/2))) - (int)(FONTSIZE/18*9*expenditures[i].getDescription().length());
		 		}
		 		y = (int)(Y-space*RADIUS*Math.sin(Math.toRadians(ratio+angle/2)));
		 		
		 		Text text = new Text( x , y , (i==7)? "Others" : expenditures[i].getDescription());
		 		
	    		text.setFont(Font.font(FONTSIZE));
	    		
	    		root.getChildren().add(text);
	    		
	    		ratio +=(i==7)? 360-ratio : angle;
		 	}		 			 			 	
		 	
	    	Scene scene = new Scene(root, 1100, 600); stage.setTitle("Pie chart");	
	    	
	    	stage.setScene(scene);
	    	
	    	stage.show();

	    }
		
		/**
		 * This function launches this application.
		 */
		
	    public static void main(String[] args) { 
	    	
	    	expenditures = new Expenditure[]{
	    			
	    			new Expenditure("Salaries", 11000),
	    			new Expenditure("Paper", 2000),
	    			new Expenditure("Rent", 5000),
	    			new Expenditure("Most popular books on Java etc.", 10000),
	    			new Expenditure("Heating", 3000),
	    			new Expenditure("Coffee/Tea", 7000),
	    			new Expenditure("Biscuits", 8000),
	    			new Expenditure("Travel", 18000),
	    			new Expenditure("Electricity", 1000),
	    			new Expenditure("Pencils", 3000)
	    	};
	    	
			Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());
	    	
			AllValues=0;
			
	    	for(Expenditure e: expenditures) AllValues+=e.getValue();
	    	
	        launch(args);
	    }
}
