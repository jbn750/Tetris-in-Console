package block;

import java.util.Random;

public class BlockList {

	public String[][] blockArray; // 다음 블록의 배열
	public String screenBlockSort; // 현재 블록
	public String nextBlockSort; // 다음 블록
	
	public int getBlockSortNumber; //블록의 종류
	Random random;
	
	public BlockList() {
		super();
		createBlockList();
		random = new Random();
		// TODO Auto-generated constructor stub
	}

	public void createBlockList() {
		blockArray = new String[4][4];
	}
	
	public void I_Block() {
		// □ □ ■ □ 
		// □ □ ■ □
		// □ □ ■ □
		// □ □ ■ □
		nextBlockSort = "I";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "■";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "□";
		blockArray[1][2] = "■";
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "□";
		blockArray[2][1] = "□";
		blockArray[2][2] = "■";//centerPointOfBlock
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "■";
		blockArray[3][3] = "□";
		
	}
	
	public void J_Block() {
		// □ □ ■ □ 
		// □ □ ■ □
		// □ ■ ■ □
		// □ □ □ □
		nextBlockSort = "J";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "■";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "□";
		blockArray[1][2] = "■";
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "□";
		blockArray[2][1] = "■";
		blockArray[2][2] = "■";//centerPointOfBlock
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "□";
		blockArray[3][3] = "□";
		
	}
	
	public void L_Block() {
		// □ □ □ □ 
		// □ □ ■ □
		// ■ ■ ■ □
		// □ □ □ □
		nextBlockSort = "L";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "□";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "□";
		blockArray[1][2] = "■";
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "■";
		blockArray[2][1] = "■";//centerPointOfBlock
		blockArray[2][2] = "■";
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "□";
		blockArray[3][3] = "□";
		
	}
	
	public void T_Block() {
		// □ □ □ □ 
		// □ □ ■ □
		// □ ■ ■ □
		// □ □ ■ □
		nextBlockSort = "T";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "□";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "□";
		blockArray[1][2] = "■";//centerPointOfBlock
		blockArray[1][3] = "□";
		                      
		blockArray[2][0] = "□";
		blockArray[2][1] = "■";
		blockArray[2][2] = "■";
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "■";
		blockArray[3][3] = "□";
		
	}
	
	public void O_Block() {
		// □ □ □ □ 
		// □ ■ ■ □
		// □ ■ ■ □
		// □ □ □ □
		nextBlockSort = "O";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "□";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "■";
		blockArray[1][2] = "■";
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "□";
		blockArray[2][1] = "■";//centerPointOfBlock
		blockArray[2][2] = "■";
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "□";
		blockArray[3][3] = "□";
		
	}
	
	public void S_Block() {
		// □ ■ □ □ 
		// □ ■ ■ □
		// □ □ ■ □
		// □ □ □ □
		nextBlockSort = "S";
		blockArray[0][0] = "□";
		blockArray[0][1] = "■";
		blockArray[0][2] = "□";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "■";//centerPointOfBlock
		blockArray[1][2] = "■";
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "□";
		blockArray[2][1] = "□";
		blockArray[2][2] = "■";
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "□";
		blockArray[3][3] = "□";
		
	}
	
	public void Z_Block() {
		// □ □ ■ □ 
		// □ ■ ■ □
		// □ ■ □ □
		// □ □ □ □
		nextBlockSort = "Z";
		blockArray[0][0] = "□";
		blockArray[0][1] = "□";
		blockArray[0][2] = "■";
		blockArray[0][3] = "□";
		
		blockArray[1][0] = "□";
		blockArray[1][1] = "■";
		blockArray[1][2] = "■";//centerPointOfBlock
		blockArray[1][3] = "□";
		
		blockArray[2][0] = "□";
		blockArray[2][1] = "■";
		blockArray[2][2] = "□";
		blockArray[2][3] = "□";
		
		blockArray[3][0] = "□";
		blockArray[3][1] = "□";
		blockArray[3][2] = "□";
		blockArray[3][3] = "□";
		
	}
	
	public void setNextBlock() {
//		다음블록 무작위 생성
		getBlockSortNumber = random.nextInt(7);
		switch (getBlockSortNumber) { //I J L T O S Z
			case 0:
				I_Block();
				break;
			case 1:
				J_Block();
				break;
			case 2:
				L_Block();
				break;
			case 3:
				T_Block();
				break;
			case 4:
				O_Block();
				break;
			case 5:
				S_Block();
				break;
			case 6:
				Z_Block();
				break;
	
			default:
				break;
		}
		
	}
	
//	현재 블록 <- 다음 블록
	public void getScreenBlockSort(String nextBlockSort) {
		screenBlockSort = nextBlockSort;
	}
	
}
