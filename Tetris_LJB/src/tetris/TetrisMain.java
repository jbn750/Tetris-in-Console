package tetris;

import java.util.Scanner;

import screen.GameScreen;

public class TetrisMain {

	public static String rankingName[] = {"손진원", "이현수", ""};
	public static int rankingScore[] = {53100, 15700, 0};
	
	public String userName;
	public int userScore;
	public String tempRankingName = "";
	public int tempRankingScore = 0;
	public boolean isRenewable = false; // 점수 갱신 유무
	
	public Scanner keyboard;
	public String inputStr; // 입력문자
	
	public TetrisMain() {
		super();
		keyboard = new Scanner(System.in);
		// TODO Auto-generated constructor stub
	}
	
//	메뉴 화면
	public void tetris() {
		while(true) {
			firstScreen();
			inputStr = keyboard.nextLine();
//			게임 시작
			if(inputStr.equalsIgnoreCase("start")) {
				runTetris();
//			명예의 전당
			} else if(inputStr.contentEquals("score")) {
				getRanking();
				inputStr = keyboard.nextLine();
//			게임 종료
			} else if(inputStr.equalsIgnoreCase("esc")) {
				closeTetrisScreen();
				return ;
			}
		}
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
		System.out.println("		게임시작");
		System.out.println("		Start 입력");
		System.out.println("");
		System.out.println("		명예의 전당");
		System.out.println("		Score 입력");
		System.out.println("");
		System.out.println("		게임종료");
		System.out.println("		Esc 입력");
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
	
//	명예의 전당 화면
	public void getRanking() {
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < rankingName.length; i++) {
			System.out.print("\t " + (i + 1) + "등 " + rankingName[i] + " " + rankingScore[i]);
			System.out.println();
			System.out.println();
		}
		System.out.println("");
		System.out.println("");
		System.out.println("\t   Press AnyKey");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("=====================================");
	}
	
//	사용자 이름 입력 화면
	public void setUserName() { 
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("	        사용자 이름 입력");
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
//		사용자 이름 입력
		setUserName();
		userName = keyboard.nextLine();
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
		//점수 정렬
		userScore = gameScreen.gameScore;
		rankingSort();
		
//		게임오버 화면
		gameScreen.gameOverScreen(isRenewable);
		inputStr = keyboard.nextLine();
	}
	
//	순위 정렬
	public void rankingSort() {
		if(userScore > rankingScore[2]) {
			this.rankingScore[2] = userScore;
			this.rankingName[2] = userName;
			isRenewable = true;
			
			if(rankingScore[2] > rankingScore[1]) {
				tempRankingName = rankingName[1];
				rankingName[1] = rankingName[2];
				rankingName[2] = tempRankingName;
				
				tempRankingScore = rankingScore[1];
				rankingScore[1] = rankingScore[2];
				rankingScore[2] = tempRankingScore;
				
				if(rankingScore[1] > rankingScore[0]) {
					tempRankingName = rankingName[0];
					rankingName[0] = rankingName[1];
					rankingName[1] = tempRankingName;
					
					tempRankingScore = rankingScore[0];
					rankingScore[0] = rankingScore[1];
					rankingScore[1] = tempRankingScore;
				}
			}
		}
	}
	
}