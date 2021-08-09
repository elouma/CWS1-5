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
 * Write a minimal class Expenditure.java that represents an expenditure with the two field variables
private String description and private int value. Write a constructor and the getters
 * 
 * *****************
 * 
 */


import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


/**
  * @param Scale 			This variable scales the size of waffle chart.
  * @param space		    This variable adjust a space between each square.
  * @param origin			This variable adjust x coordinate origin and y coordinate origin.
  * @param expenditures		This variable includes expenditures.
		 */


public class Waffle extends Application{
		
		private final int Scale = 30, origin = 100, space = 4, maximum=8;
		private static Expenditure[] expenditures;
		private static int AllValues;
		
	
		/**
		 * This function creates a pie chart.
		 */
	    @Override
	    
	    public void start(Stage stage) throws Exception {
	    	int[] counts = createPercentage();	    	
	    	
	    	Group root = new Group();
	    	
	    	int k=0,
	    	count=0;
	    	
	    	for(int i=0; i<10; i++) {
	    		for(int j=0; j<10; j++) {if(counts[k] == count) {k++;
	    				count=0;}
	    		
			    	root.getChildren().add( createSquare(j,i,k) );
	    			count++;
	    		}
	    		
	    	}
	    	
	    	
	    	for(int i=0; i<maximum; i++)
	    	{
	    		root.getChildren().add( createSquare(13,1+i,i) );
	    		
	    		Text text = new Text(getXorY(14), getXorY(i+1)+Scale, (i==maximum-1)? "Others" : expenditures[i].getDescription());
	    		
	    		text.setFont(Font.font(Scale));
	    		
	    		root.getChildren().add(text);
	    	}	    	
	    	
	    	
	    	Scene scene = new Scene(root, 1100, 600); stage.setTitle("Waffle Chart");	
	    	
	    	stage.setScene(scene);
	    	
	    	stage.show();

	    }
	    
	    public int[] createPercentage() {
	    	
	    	double[] counts = new double[maximum];
	    	
	    	double sum = 0;
	    	
	    	int percentage = 0;
	    	
	    	for(int i=0; i<maximum-1; i++) {
	    		
	    		counts[i] = (double)expenditures[i].getValue()/AllValues*100;
	    		
	    		sum += counts[i];
	    		
	    		percentage += Math.floor(counts[i]);
	    		
	    	}
	    	
	    	System.out.println(sum+" , "+percentage);
	    	
	    	int addition = (int)sum - percentage;
	    	
	    	Expenditure[] expenditure = expenditures;
	    	
	    	for(int i=0; i<maximum; i++) {
	    		
	    		expenditure[i].setValue((int)((counts[i]-(int)counts[i])*100000));
	    	}
	    	Arrays.sort(expenditure, (Expenditure exp1, Expenditure exp2) 
	    			-> exp2.getValue() - exp1.getValue());
	    	
	    	for(int i=0; i<addition; i++) {
	    		
	    		for(int j=0; j<maximum; j++) {
	    			
	    			if(expenditure[i].getDescription()==expenditures[j].getDescription()) {
	    				
	    				counts[j]=Math.ceil(counts[j]);
	    				
	    				break;
	    			}
	    		}
	    	}
	    	
	    	int[] new_counts = new int[maximum];
	    	
	    	for(int i=0; i<maximum; i++) {
	    		
	    		new_counts[i] = (int)counts[i];
	    		
	    	}
	    	for(int i=0; i<maximum; i++) {
	    		
	    		System.out.println(new_counts[i]);
	    		
	    	}
	    	
	    	return new_counts;
	    }
	    
	    /**
	     * This function create a square of waffle chart.
	     * @param X		This parameter means the x coordinate point. 
	     * @param Y		This parameter means the y coordinate point.
	     * @param order	This represents the order out of 8 numbers, and if the rank is 7, it is included "Others".
	     * 
	     * @return a square of the waffle chart.
	     */
	    
	    
	    public Rectangle createSquare(int X, int Y, int order) {
	    	
	    	Rectangle rectangle = new Rectangle(getXorY(X), 
	    			getXorY(Y), Scale, Scale);
	    	
	    	
	    	Color[] colors = {
	    			
	    			Color.web("#000000"), Color.web("#0000FF"),
	    			Color.web("#FF0000"), Color.web("#FFFF00"),
	    			Color.web("#008000"), Color.web("#A52A2A"), 
	    			Color.web("#000080"), Color.web("#00BFFF"),
	    			Color.web("#ff69b4"), Color.web("#ffa500"), 
	    			Color.web("#adff2f"), Color.web("#f5deb3")
	    	};
	    	
	    	
	    	rectangle.setFill(colors[order]);
	    	
	    	return rectangle;
	    }
	    
	    
	    
	    /**
	     * This function recalculate x coordinate point or y coordinate point.
	     * 
	     * @param position 		This parameter means the x coordinate point or y coordinate point.
	     *  
	     * @return x coordinate point or y coordinate point.
	     */
	    
	    
	    public int getXorY(int location) {
	    	return origin + location * (Scale + space);
	    }

	    /**
	     * This is the main method of this class.
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
	    	
	    	
			Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) 
					-> exp2.getValue() - exp1.getValue());
	    	
			AllValues=0;
			
	    	for(Expenditure e: expenditures) AllValues+=e.getValue();
	    	
	    	
	        launch(args);
	    }
}
