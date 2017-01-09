/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreiRad;

public abstract class Player {
    String name;
    protected Player(String name){
    this.name=name;
    }
    
    public String getName(){
            return name;
        } 
    protected int[] accept = new int[2];
    protected int player;

    
    public Player(int player){
        this.player = player;
        
        
    }
    
    public abstract void play(Board board);
    
    public abstract void Try(Board board);

    public boolean checkTry(int[] accept, Board board){
        if(board.getPosition(accept) == 0)
            return true;
        else
            return false;
            
    }
    
}
