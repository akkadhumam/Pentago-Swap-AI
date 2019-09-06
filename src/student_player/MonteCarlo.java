package student_player;

import java.util.*;

import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;

public class MonteCarlo {
	private final int player;
	
	public MonteCarlo(int player) {
		this.player=player;
	}
	
	public ArrayList<PentagoMove> getAllChildren(PentagoBoardState state){
		return state.getAllLegalMoves();
	}
	
	//Scoring
	public int endSimulationScore (PentagoBoardState state) {
		while(!state.gameOver()) {
			PentagoMove move = (PentagoMove) state.getRandomMove();
			state.processMove(move);
		}
		if(state.getWinner()==player) {
		return 1;
		}
		return 0;
	}
	
	//Finding best move given based on 10,000 simulations
	public PentagoMove bestMove(PentagoBoardState state) {
		List<PentagoMove> childNodes = getAllChildren(state);
		int maxScore = Integer.MIN_VALUE;
		PentagoMove bestMove=null;
		for(PentagoMove child:childNodes) {
			PentagoBoardState tempState=(PentagoBoardState)state.clone();
			tempState.processMove(child);
			int score = 0;
			for(int i=0;i<10000;i++) {
				score = score + endSimulationScore(tempState);
			}
			if(score>maxScore) {
				maxScore = score;
				bestMove=child;
			}
			
		}
		
		return bestMove;
	}

	
}
	

