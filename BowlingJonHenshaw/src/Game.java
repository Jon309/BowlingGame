public class Game {
	
	private int roll = 0;
	private int[] rolls = new int[21];
	
	public void rolls(String scoreCard) {
		for (int i=0; i< scoreCard.length(); i++) {
			if(scoreCard.charAt(i) == 'X') {
				rolls[roll++] = 10;
			}
			else if(scoreCard.charAt(i) == '/') {
				int diff = 10 - rolls[roll - 1];
				rolls[roll++] = diff;
			}
			else if(scoreCard.charAt(i) == '-') {
			}
			else {
				rolls[roll++] = scoreCard.charAt(i) - '0';
			}
		}
	}

	public int score() {
		int score = 0;
		int cursor = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(cursor)) { 
				score += 10 + rolls[cursor+1] + rolls[cursor+2];
				cursor ++;
			} else 
			if (isSpare(cursor)) { 
				score += 10 + rolls[cursor+2];
				cursor += 2;
			} else {
			score += rolls[cursor] + rolls[cursor+1];
			cursor += 2;
			}
		}
		return score;
	}
	
	private boolean isStrike(int cursor) {
		return rolls[cursor] == 10;
	}

	private boolean isSpare(int cursor) {
		return rolls[cursor] + rolls[cursor+1] == 10;
	}
	
}
