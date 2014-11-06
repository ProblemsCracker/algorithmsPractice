package algorithmsPractice;

public class ParkingLot {

	/********************** inner classes ******************/
	public class ParkingSpace {
		/** regular: 0; big : 1; */
		int space;
		boolean occupied;
		/** regular : 0; reserved: 1; for special people: 2 */
		int kind;
	}
	
	public class Level {
		ParkingSpace[] spaces;
	}
	
	/********************** variables **********************/
	private Level[] levels;
	

	/********************** methods ************************/
	/** get all the occupied spaces */
	public int getOccupiedSpaces(int level) {
		
		/** sentinel */
		if(level > levels.length) return -1;
		
		ParkingSpace[] curLevel = levels[level].spaces;
		int returnValue = 0;
		
		for(int i = 0; i < curLevel.length; i++) {
			ParkingSpace curSpace = curLevel[i];
			if(curSpace.occupied) returnValue++;
		}
		
		return returnValue;
	}
	
	/** get the occupied spaces of a specific kind */
	public int getOccupiedSpaces(int level, int kind) {
		
		/** sentinel */
		if(level > levels.length) return -1;
		
		ParkingSpace[] curLevel = levels[level].spaces;
		int returnValue = 0;
		
		for(int i = 0; i < curLevel.length; i++) {
			ParkingSpace curSpace = curLevel[i];
			if(curSpace.occupied && curSpace.kind == kind) returnValue++;
		}
		
		return returnValue;
	}
	
	/** get all the available spaces */
	public int getAvailables(int level) {
		if(level > levels.length) return -1;
		
		int totalNum = levels[level].spaces.length; 
		
		return totalNum - this.getOccupiedSpaces(level);
	}
	
	/** get the available spaces of a single kind */
	public int getAvailables(int level, int kind) {
		if(level > levels.length) return -1;
		
		int totalNum = 0;
		
		ParkingSpace[] curLevel = levels[level].spaces;
		
		for(int i = 0; i < curLevel.length; i++) {
			if(curLevel[i].kind == kind) {
				totalNum ++;
			}
		}
		
		return totalNum - this.getOccupiedSpaces(level, kind);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
