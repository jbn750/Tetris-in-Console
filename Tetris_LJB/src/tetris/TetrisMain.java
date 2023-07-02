package tetris;

import java.util.Scanner;

import screen.GameScreen;

public class TetrisMain {

	public static String rankingName[] = {"손진원", "이현수", ""};
	public static int rankingScore[] = {0, 17000, 0};
	
	public Scanner keyboard;
	public String inputStr; // 입력문자
	
//	메뉴 화면
	public void tetris() {
//		rankingName[0] = "손진원";
		while(true) {
			firstScreen();
			inputStr = keyboard.nextLine();
			
			if(inputStr.equalsIgnoreCase("start")) {
				runTetris();
			} else if(inputStr.equalsIgnoreCase("esc")) {
				closeTetrisScreen();
				return ;
			} else if(inputStr.contentEquals("score")) {
				getRanking();
			}
		}
	}
	
	public TetrisMain() {
		super();
		keyboard = new Scanner(System.in);
		// TODO Auto-generated constructor stub
	}

//	시작 화면
	public void firstScreen() { 
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("	   Console창을 크기에 맞게");
		System.out.println("		조절해주세요");
		System.out.println("");
		System.out.println("");
		System.out.println("		게임시작");
		System.out.println("		Start 입력");
		System.out.println("");
		System.out.println("		게임종료");
		System.out.println("		Esc 입력");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("=====================================");
		
	}
	
//	게임 종료 화면
	public void closeTetrisScreen() { 
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("		게임종료");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("=====================================");
	}
	
//	게임 작동
	public void runTetris() {
		GameScreen gameScreen = new GameScreen();
//		다음 블록 설정
		gameScreen.setNextBlock();
		while(true) {
//			1.블록 가져옴
//			현재 블록 <- 다음 블록
			gameScreen.getScreenBlockSort(gameScreen.nextBlockSort);
//			화면에 현재 블록 설정
//				-> 블록 못넣음 = 게임오버
			gameScreen.blockFitToScreen();
//			다음 블록 설정
			gameScreen.setNextBlock();
			
			//2.블록못넣음 = 게임오버 -> 게임화면(0)
			if(gameScreen.gameOver) {
				break;
			}

//			블록 위치 선택 완료시 까지 반복
			do {
				try {
					gameScreen.putBlockComplete = false;
//					게임 화면 출력
					gameScreen.gameScreen();
//					사용자입력
					inputStr = keyboard.nextLine();
					if(inputStr.equalsIgnoreCase("A")) {
//						왼쪽 이동
						gameScreen.input_A();
					}else if(inputStr.equalsIgnoreCase("S")) {
//						아래이동
						gameScreen.input_S();
					}else if(inputStr.equalsIgnoreCase("D")) {
//						오른쪽이동
						gameScreen.input_D();
					}else if(inputStr.equalsIgnoreCase("W")) {
//						시계방향회전
						gameScreen.input_W();
					}else if(inputStr.isEmpty()) {
//						아래로 드랍
						gameScreen.input_Enter();
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					gameScreen.setBlock(gameScreen.screenBlockSort, gameScreen.centerPointTurn, gameScreen.fullBlock);
				} catch ( IndexOutOfBoundsException e ) {
					gameScreen.setBlock(gameScreen.screenBlockSort, gameScreen.centerPointTurn, gameScreen.fullBlock);
				}
			} while (!gameScreen.putBlockComplete);
//			줄 제거
			gameScreen.removeRows();
		}
//		게임오버 화면
		gameScreen.gameOverScreen();
		inputStr = keyboard.nextLine();
			
	}
	
	public void getRanking() {
		System.out.println("1등 " + rankingName + " " + rankingScore);
	}
}