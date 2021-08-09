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
 * Function creates Expenditure class has two variables description 
 * and value of type String and int.
 * 
*/



public class Expenditure {
	/**
	 * @param description		This parameter is the description of the Expenditure.
	 * @param value				This parameter is the value of the Expenditure.
	 */
	private String description;
	private int value;
	
	/**
	 * This constructor consists of the value description and value, which is String and int, respectively.
	 * @param description		This parameter is the description of the Expenditure.
	 * @param value				This parameter is the value of the Expenditure.
	 */
	public Expenditure(String description, int value) {
		this.description = description;
		this.value = value;
	}
	
	/**
	 * This function returns the description of Expenditure.
	 * @return the description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * This function returns the value of Expenditure.
	 * @return the value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * This function sets new value.
	 * @param value				This parameter is new value of the Expenditure.
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * This function returns the detail of Expenditure, which type is String.
	 */
	public String toString() {
		return "Description:"+description+", Value:"+value;
	}
}