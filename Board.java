/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreiRad;

public class Board {
    private int[][] Board= new int[3][3];
   
    
    public Board(){
        clearBoard();
    }
    
    public void clearBoard(){
        for(int Line=0 ; Line<3 ; Line++)
            for(int column=0 ; column<3 ; column++)
                Board[Line][column]=0;
    }
    
    public void showBoard(){
        System.out.println();
        for(int Line=0 ; Line<3 ; Line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(Board[Line][column]==-1){
                    System.out.print(" X ");
                }
                if(Board[Line][column]==1){
                    System.out.print(" O ");
                }
                if(Board[Line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosition(int[] accept){
        return Board[accept[0]][accept[1]];
    }
    
    public void setPosition(int[] accept, int player){
        if(player == 1)
            Board[accept[0]][accept[1]] = -1;
        else
            Board[accept[0]][accept[1]] = 1;
    }

    public int checkLines(){
        for(int Line=0 ; Line<3 ; Line++){

            if( (Board[Line][0] + Board[Line][1] + Board[Line][2]) == -3)
                return -1;
            if( (Board[Line][0] + Board[Line][1] + Board[Line][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (Board[0][column] + Board[1][column] + Board[2][column]) == -3)
                return -1;
            if( (Board[0][column] + Board[1][column] + Board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == -3)
            return -1;
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == 3)
            return 1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == -3)
            return -1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == 3)
            return 1;
        
        return 0;
    }

    public boolean fullBoard(){
        for(int Line=0 ; Line<3 ; Line++)
            for(int column=0 ; column<3 ; column++)
                if( Board[Line][column]==0 )
                    return false;
        return true;
    }
}
    

