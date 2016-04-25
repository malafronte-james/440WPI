package Data;

/**
 * 
 * @author jmalafronte
 * Handle all the data
 */

public class TempData {

	private int numCells;
	
	private float lowThreshold,
	              hiThreshold,
	              abortVoltage,
	              cellAlarmThreshold,
	              batteryVoltage;
	
	private String generalTestInformation,
				   userData;
	
	
	public TempData()
	{
		userData = "";
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
	
	/**
	 * Sets the min threshold
	 * @param f the minimum threshold
	 */
	public void setLowThreshold(float f)
	{
		lowThreshold = f;
	}
	
	/**
	 * Gets the min threshold
	 * @return min threshold
	 */
	public float getLowThreshold()
	{
		return lowThreshold;
	}
	
	/**
	 * Sets the max threshold
	 * @param f the maximum threshold
	 */
	public void setHiThreshold(float f)
	{
		hiThreshold = f;
	}
	
	/**
	 * Gets the max threshold
	 * @return max threshold
	 */
	public float getHiThreshold()
	{
		return hiThreshold;
	}

	/**
	 * @return the abortVoltage
	 */
	public float getAbortVoltage() {
		return abortVoltage;
	}

	/**
	 * @param abortVoltage the abortVoltage to set
	 */
	public void setAbortVoltage(float abortVoltage) {
		this.abortVoltage = abortVoltage;
	}

	/**
	 * @return the cellAlarmThreshold
	 */
	public float getCellAlarmThreshold() {
		return cellAlarmThreshold;
	}

	/**
	 * @param cellAlarmThreshold the cellAlarmThreshold to set
	 */
	public void setCellAlarmThreshold(float cellAlarmThreshold) {
		this.cellAlarmThreshold = cellAlarmThreshold;
	}

	/**
	 * @return the batteryVoltage
	 */
	public float getBatteryVoltage() {
		return batteryVoltage;
	}

	/**
	 * @param batteryVoltage the batteryVoltage to set
	 */
	public void setBatteryVoltage(float batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	/**
	 * @return the generalTestInformation
	 */
	public String getGeneralTestInformation() {
		return generalTestInformation;
	}

	/**
	 * @param generalTestInformation the generalTestInformation to set
	 */
	public void setGeneralTestInformation(String generalTestInformation) {
		this.generalTestInformation = generalTestInformation;
	}

	/**
	 * @return the userData
	 */
	public String getUserData() {
		return userData;
	}

	/**
	 * @param userData the userData to set
	 */
	public void setUserData(String userData) {
		this.userData = userData;
	}
}
