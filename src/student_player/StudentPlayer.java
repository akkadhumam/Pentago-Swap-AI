package student_player;

import boardgame.Move;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("XXXXXX);
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move chooseMove(PentagoBoardState boardState) {
        // You probably will make separate functions in MyTools.
        // For example, maybe you'll need to load some pre-processed best opening
        // strategies...
    			
    			//Use MonteCarlo to find best opening move
    			//(Based on 10,000 simulations for each possible opener)
    			if(boardState.getTurnNumber()==1) {
    			MonteCarlo tree=new MonteCarlo(boardState.getTurnPlayer());
    			return tree.bestMove(boardState);
    		}
    			//After finding best possible opening move with MonteCarlo,
    			//Proceed with MiniMax
    			else {
    				AlphaBeta move = new AlphaBeta();
    				return move.miniMax(boardState, boardState.getTurnPlayer());
    			}
    }		
}