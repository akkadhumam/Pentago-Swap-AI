package student_player;

import java.util.ArrayList;

import boardgame.Board;
import boardgame.Move;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoBoardState.Piece;
import pentago_swap.PentagoBoardState.Quadrant;
import pentago_swap.PentagoMove;



public class AlphaBeta {
	public PentagoMove move;
	public int score;

	public void setMove(PentagoMove move) {
		this.move=move;
	}
	public void setScore(int score) {
		this.score=score;	
}
    
  
    public PentagoMove miniMax(PentagoBoardState boardState,int myPlayer) {
    	
    	int currentPlayer = myPlayer;
    	int alpha = Integer.MIN_VALUE;
    	int beta = Integer.MAX_VALUE;
    	int maxScore;
    	ArrayList<PentagoMove> possibleMoves = boardState.getAllLegalMoves();
    	PentagoMove nullMove = null;
    AlphaBeta bestMove = new AlphaBeta();
    	bestMove.setMove(nullMove);
    	
    	
    
        if (currentPlayer==myPlayer) {
        		maxScore= (Integer.MIN_VALUE);
         	} 
        else{
        		
        		maxScore=  (Integer.MAX_VALUE);
        		}
        
        
        //If game is over
    	if(boardState.getWinner()!=Board.NOBODY) { 
    		
    		bestMove.setScore(maxScore);
    		
    		if (boardState.getWinner()==myPlayer) {
    			maxScore=500 ;
    			bestMove.setScore(maxScore);	
    			
    		}
    		else if (boardState.getWinner()==Board.DRAW){
    			maxScore= 0;
    			bestMove.setScore(maxScore);
    		}
    		else {
    			maxScore =-500;
    			bestMove.setScore(maxScore);
    		}
    	}
    	
    else {
       
        for(PentagoMove move: possibleMoves) {
         	
        	PentagoBoardState tempState= (PentagoBoardState) boardState.clone();
        	
        	tempState.processMove(move);
        	int curr=currentPlayer;
        	
        	//switch current player
        	if(currentPlayer==0){
        		currentPlayer=1;
        		
        		}
         else {
        	 	currentPlayer=0;
        	 	
        	 }
         	
        
         	
        	if(curr==myPlayer) {
         		
        		if(score>alpha) {
         			alpha=score;
         			bestMove.setMove(move);
         			bestMove.setScore(score);
         		}
         	}
         	
        	else {
         		if(score<beta) {
         			beta=score;
         			bestMove.setMove(move);
         			bestMove.setScore(score);
         		}
         	}
        		
         	 if (alpha >= beta) {
         		 break; 
         	 }
        }
         }
   
    	if(currentPlayer==myPlayer) {
    		bestMove.setScore(alpha);
    		}
    	else {
    		bestMove.setScore(beta);
    	}
    		
         return bestMove.move;
    
    }
    
    
}


