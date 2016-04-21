package Data;

/**
 * 
 * @author jmalafronte
 * Handle all the data
 */

public class TempData {

	private int numCells;
	
	public TempData()
	{
		
	}
	
	/**
	 * Sets the number of cells
	 * @param cells
	 */
	public void setNumberOfCells(int cells)
	{
		numCells = cells;
	}
	
	/**
	 * Gets the number of cells
	 * @return the number of cells
	 */
	public int getNumberOfCells()
	{
		return numCells;
	}
}
