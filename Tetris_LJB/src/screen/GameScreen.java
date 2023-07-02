package screen;

import java.util.ArrayList;

import block.ControlBlock;

public class GameScreen extends ControlBlock{
	
	public boolean isRemoveRow; //제거 유무
	public int removeRowCount; //제거 할 줄 개수
	public boolean gameOver = false;
	public int gameScore; // 게임 점수
	
	public GameScreen() {
		super();
		setScreenArrayList();
	}
	
	//스크린 리스트 생성
	public void setScreenArrayList() {
//		세로줄
		screenPrintList0 = new ArrayList<String>();
		screenPrintList1 = new ArrayList<String>();
		screenPrintList2 = new ArrayList<String>();
		screenPrintList3 = new ArrayList<String>();
		screenPrintList4 = new ArrayList<String>();
		screenPrintList5 = new ArrayList<String>();
		screenPrintList6 = new ArrayList<String>();
		screenPrintList7 = new ArrayList<String>();
		screenPrintList8 = new ArrayList<String>();
		screenPrintList9 = new ArrayList<String>();
		
//		가로줄
		combineArray = new ArrayList[gameScreenWidthLine];
		combineArray[0] = screenPrintList0;
		combineArray[1] = screenPrintList1;
		combineArray[2] = screenPrintList2;
		combineArray[3] = screenPrintList3;
		combineArray[4] = screenPrintList4;
		combineArray[5] = screenPrintList5;
		combineArray[6] = screenPrintList6;
		combineArray[7] = screenPrintList7;
		combineArray[8] = screenPrintList8;
		combineArray[9] = screenPrintList9;
		
		for (int i = 0; i < gameScreenWidthLine; i++) {
//			바닥 생성
			combineArray[i].add(fullBlock);
			for (int j = 0; j < gameScreenHeightLine - 1; j++) { // 19 - 1개, 0 ~ 17
//				화면
				combineArray[i].add(blankBlock);
			}
		}
	}

//	기본 화면틀	
//	======================================= gameScreenHeightLine 
//	|| □ □ □ □ ■ □ □ □ □ □ || □ □ □ □ || 	gameScreenHeightLine - 1 // [0~3][0~3]
//	|| □ □ □ □ ■ ■ □ □ □ □ || □ □ ■ □ || 	gameScreenHeightLine - 2 
//	|| □ □ □ □ □ ■ □ □ □ □ || ■ ■ ■ □ || 	gameScreenHeightLine - 3 
//	|| □ □ □ □ □ □ □ □ □ □ || □ □ □ □ || 	gameScreenHeightLine - 4 
//	|| □ □ □ □ □ □ □ □ □ □ ||=========== 	gameScreenHeightLine - 5 
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ ||
//	|| □ □ □ □ □ □ □ □ □ □ || Score : 0
//	=======================================
	
	public void gameScreen() { // Weight = 19 - 1, Height = 10
		System.out.println("=======================================");
		for (int i = gameScreenHeightLine - 1; i > 0; i--) {
			System.out.print("||");
			System.out.print(" ");
			for (int j = 0; j < gameScreenWidthLine; j++) { // j = 0
				System.out.print(combineArray[j].get(i));
				System.out.print(" ");
				
			}
			
			System.out.print("||");
//			다음블럭 출력
			if(i >= gameScreenHeightLine - blockArray.length) {
				System.out.print(" ");
				for (int j = 0; j < 4; j++) {
//					k++;
					System.out.print(blockArray[gameScreenHeightLine - 1 - i][j]);
					System.out.print(" ");
					
				}
				System.out.print("||");
			}
			if(i == gameScreenHeightLine - 1 - blockArray.length) {
				System.out.print("===========");
			}
			
			if(i == 1) {
				System.out.print(" Score : " + this.gameScore);
			}
			
			System.out.println();
		}
		System.out.println("=======================================");
	}
//	화면에 현재 블록 설정
//	-> 블록 못넣음 = 게임오버
	public void blockFitToScreen() {
		
		centerPointTurn = 0; // 중심점 순서 초기화
		centerPointOfBlockX = gameScreenWidthLine / 2; // 블록 시작 X좌표 4 (3~6)
		centerPointOfBlockY = gameScreenHeightLine - 1 - 2; // 블록 시작 Y좌표  19 - 바닥 - 2 = 16 (16~19)
		
//		블럭의 종류에 따라 중심좌표가 바뀜
		if(screenBlockSort == "I") {
			
		}else if(screenBlockSort == "J") {
			
		}else if(screenBlockSort == "L") {
			centerPointOfBlockY = centerPointOfBlockY + 1;
			
		}else if(screenBlockSort == "T") {
			centerPointOfBlockY = centerPointOfBlockY + 1;
			
		}else if(screenBlockSort == "O") {
			centerPointOfBlockX = centerPointOfBlockX - 1;
			centerPointOfBlockY = centerPointOfBlockY + 1;
			
		}else if(screenBlockSort == "S") {
			centerPointOfBlockX = centerPointOfBlockX - 1;
			centerPointOfBlockY = centerPointOfBlockY + 1;
			
		}else if(screenBlockSort == "Z") {
			centerPointOfBlockY = centerPointOfBlockY + 1;
		}
//		게임오버 판단
		isGameOver();
		
//		화면에 현재 블록 설정
		setBlock(screenBlockSort, centerPointTurn, fullBlock);			
	}
	
//	줄 제거
	public void removeRows() {
//		줄 제거 횟수 초기화
		removeRowCount = 0;
		for (int i = gameScreenHeightLine - 1; i > 0; i--) {
			isRemoveRow = true;
			for (int j = 0; j < gameScreenWidthLine; j++) {
//				줄에 공백 유무
				if(combineArray[j].get(i).equals(blankBlock)) {
//					줄 제거 안함
					isRemoveRow = !isRemoveRow;
					break;
				}
			}
//			줄 제거 유무
			if(isRemoveRow) {
				for (int j = 0; j < gameScreenWidthLine; j++) { // j = 1
//					줄 삭제
					combineArray[j].remove(i);
//					화면에 줄 만들기
					combineArray[j].add(blankBlock);
				}
//				줄 제거 횟수
				removeRowCount++; 
				//삭제
			}
		}
//		점수 계산
		if(removeRowCount == 1) {
			gameScore = gameScore + 100;
		}else if(removeRowCount == 2) {
			gameScore = gameScore + 200;
		}else if(removeRowCount == 3) {
			gameScore = gameScore + 400;
		}else if(removeRowCount == 4) {
			gameScore = gameScore + 700;
		}
	}
	
	//게임 오버 판단
	public void isGameOver() {
		getBlockFragment(screenBlockSort, centerPointTurn, centerPointOfBlockX, centerPointOfBlockY);
		if(!blockMovable()) {
			gameOver = !gameOver;
		}
		
	}
	
	//게임오버 화면
	public void gameOverScreen() {
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("\t          게임오버");
		System.out.println("");
		System.out.println("");
		System.out.println("\t         점수 : " + gameScore);
		System.out.println("");
		System.out.println("");
		System.out.println("\t   Press AnyKey");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("=====================================");
		
	}
	
}