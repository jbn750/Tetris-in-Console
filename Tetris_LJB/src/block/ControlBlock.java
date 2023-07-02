package block;

import java.util.ArrayList;

public class ControlBlock extends BlockList{
	
	//가로줄
	public ArrayList<String> screenPrintList0;
	public ArrayList<String> screenPrintList1;
	public ArrayList<String> screenPrintList2;
	public ArrayList<String> screenPrintList3;
	public ArrayList<String> screenPrintList4;
	public ArrayList<String> screenPrintList5;
	public ArrayList<String> screenPrintList6;
	public ArrayList<String> screenPrintList7;
	public ArrayList<String> screenPrintList8;
	public ArrayList<String> screenPrintList9;
	//세로줄
	public ArrayList<String>[] combineArray;
	
	public static final int gameScreenWidthLine = 10; //화면 가로길이 + 2 // + 2
	public static final int gameScreenHeightLine = 18 + 1; //화면 세로길이 + 바닥
	public int centerPointOfBlockX; //중심 X좌표
	public int centerPointOfBlockY; //중심 Y좌표
	public int centerPointTurn = 0; //중심 좌표 순서
	public final String blankBlock = "□";
	public final String fullBlock = "■";
	
	public String[] checkFullBlock = new String[4]; // 블록 확인 배열
	public boolean putBlockComplete = true; // 블록 위치 선택 완료 유무
	
	
	public void input_A() {
//		현재 자리 비움
		setBlock(screenBlockSort, centerPointTurn, blankBlock);
//		이동할 자리 확인
		getBlockFragment(screenBlockSort, centerPointTurn, centerPointOfBlockX - 1, centerPointOfBlockY);
		if(blockMovable()) { // 이동 성공
			
			centerPointOfBlockX--;
//			이동한 자리 채움
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}else { // 이동 실패
//			현재 자리 다시 채움
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}
	}

	public void input_S() {
		setBlock(screenBlockSort, centerPointTurn, blankBlock);
		
		getBlockFragment(screenBlockSort, centerPointTurn, centerPointOfBlockX, centerPointOfBlockY - 1);
		
		if(blockMovable()) {
			centerPointOfBlockY--;
		
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}else {
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
//			블록 위치 선택 완료
			putBlockComplete = !putBlockComplete;
		}
	}

	public void input_D() {
		setBlock(screenBlockSort, centerPointTurn, blankBlock);
		
		getBlockFragment(screenBlockSort, centerPointTurn, centerPointOfBlockX + 1, centerPointOfBlockY);
		
		if(blockMovable()) {
			centerPointOfBlockX++;
		
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}else {
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}
	}

	public void input_W() {
		setBlock(screenBlockSort, centerPointTurn, blankBlock);
		
		if(screenBlockSort == "Z" || screenBlockSort == "S") {
//			Z블럭과 S블럭은 중심점 순서가 두종류
			if(centerPointTurn == 0) {
				getBlockFragment(screenBlockSort, centerPointTurn + 2, centerPointOfBlockX, centerPointOfBlockY + 1);
			}else if(centerPointTurn == 2) {
				getBlockFragment(screenBlockSort, centerPointTurn - 2, centerPointOfBlockX, centerPointOfBlockY - 1);
				
			}
		} else {
			if(centerPointTurn == 0) {
				getBlockFragment(screenBlockSort, centerPointTurn + 1, centerPointOfBlockX - 1, centerPointOfBlockY);
				
			}else if(centerPointTurn == 1) {
				getBlockFragment(screenBlockSort, centerPointTurn + 1, centerPointOfBlockX, centerPointOfBlockY + 1);
				
			}else if(centerPointTurn == 2) {
				getBlockFragment(screenBlockSort, centerPointTurn + 1, centerPointOfBlockX + 1, centerPointOfBlockY);
				
			}else if(centerPointTurn == 3) {
				getBlockFragment(screenBlockSort, centerPointTurn - 3, centerPointOfBlockX, centerPointOfBlockY - 1);
			}
		}
		
		if(blockMovable()) {
			centerPointTurn++;
			if(screenBlockSort == "Z" || screenBlockSort == "S") {
				centerPointTurn++;
			}
//			중심점 순서에 따른 위치 이동
			if(centerPointTurn == 1) {
				centerPointOfBlockX--;
				
			}else if(centerPointTurn == 2) {
				centerPointOfBlockY++;
				
			}else if(centerPointTurn == 3) {
				centerPointOfBlockX++;
				
			}else if(centerPointTurn == 4) {
				centerPointOfBlockY--;
				centerPointTurn = 0;
			}
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
			
		}else {
			setBlock(screenBlockSort, centerPointTurn, fullBlock);
		}
	}
	
//	아래로 드랍
	public void input_Enter() {
		while(!putBlockComplete) {
			input_S();
		}
	}
	
//	블록 채우기
	public void setBlock(String screenBlockSort, int centerPointTurn, String block) {
		if(screenBlockSort == "I") { 
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 2, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}else if(centerPointTurn == 1) {
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 2].set(centerPointOfBlockY, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 2, block);
				
			}else if(centerPointTurn == 3) {
				combineArray[centerPointOfBlockX - 2].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
			
			}
		}else if(screenBlockSort == "J") { 
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 2, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX -1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 2].set(centerPointOfBlockY, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 2, block);
				
			}else if(centerPointTurn == 3) {
				combineArray[centerPointOfBlockX - 2].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}
		}else if(screenBlockSort == "L") {
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX -2].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 2, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 2].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}else if(centerPointTurn == 3) {
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 2, block);
				
			}
		}else if(screenBlockSort == "T") {
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}else if(centerPointTurn == 3) {
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}
		}else if(screenBlockSort == "O") {
			combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
			combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY + 1, block);
			combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
			combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
			
		}else if(screenBlockSort == "S") {
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY - 1, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY -1, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				
			}
		}else if(screenBlockSort == "Z") {
			if(centerPointTurn == 0) {
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY + 1, block);
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY - 1, block);
				
			}else if(centerPointTurn == 2) {
				combineArray[centerPointOfBlockX - 1].set(centerPointOfBlockY, block);
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY, block);//centerPointOfBlock
				combineArray[centerPointOfBlockX].set(centerPointOfBlockY - 1, block);
				combineArray[centerPointOfBlockX + 1].set(centerPointOfBlockY - 1, block);
				
			}
		}
	}
	
//	블록의 자리 저장
	public void getBlockFragment(String screenBlockSort, int centerPointTurn,
						int centerPointOfBlockX, int centerPointOfBlockY) {
		if(screenBlockSort == "I") {
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 2);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}else if(centerPointTurn == 1) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 2].get(centerPointOfBlockY);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 2);
				
			}else if(centerPointTurn == 3) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 2].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
			
			}
		}else if(screenBlockSort == "J") { 
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 2);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[2] = combineArray[centerPointOfBlockX -1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 2].get(centerPointOfBlockY);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[1] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 2);
				
			}else if(centerPointTurn == 3) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 2].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}
		}else if(screenBlockSort == "L") {
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX -2].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 2);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[1] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 2].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}else if(centerPointTurn == 3) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 2);
				
			}
		}else if(screenBlockSort == "T") {
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);//centerPointOfBlock
				
			}else if(centerPointTurn == 1) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);//centerPointOfBlock
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}else if(centerPointTurn == 3) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}
		}else if(screenBlockSort == "O") {
			checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
			checkFullBlock[1] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY + 1);
			checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
			checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
			
		}else if(screenBlockSort == "S") {
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY - 1);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY -1);
				checkFullBlock[3] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				
			}
		}else if(screenBlockSort == "Z") {
			if(centerPointTurn == 0) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY + 1);
				checkFullBlock[1] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[3] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY - 1);
				
			}else if(centerPointTurn == 2) {
				checkFullBlock[0] = combineArray[centerPointOfBlockX - 1].get(centerPointOfBlockY);
				checkFullBlock[1] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY);//centerPointOfBlock
				checkFullBlock[2] = combineArray[centerPointOfBlockX].get(centerPointOfBlockY - 1);
				checkFullBlock[3] = combineArray[centerPointOfBlockX + 1].get(centerPointOfBlockY - 1);
				
			}
		}
	}
	
//	블록이 이동이 가능한지
	public boolean blockMovable() {//I J L T O S Z
		
		for (int i = 0; i < 4; i++) {
//			블록이 이미 존재할 때
			if(checkFullBlock[i].equalsIgnoreCase(fullBlock) == true) {
				return false;
			}
		}
//		이동할 자리 확인 후 문제 없을 시
		return true;
	}
	
}
