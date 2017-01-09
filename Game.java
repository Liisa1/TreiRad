/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreiRad;

import static java.time.Clock.system;
import java.util.Scanner;
/**
 *
 * @author liisa
 */
public class Game {
    
  private Board board;
    private int turn=1, who=1;
    private Player Lisa;
    private Player Max;
    public Scanner input = new Scanner(System.in);
    private Computer Computerplayer;
    private Computer computer;

    
    public Game(){   
        board = new Board();
        startPlayers();
        boolean go =true;
       
        while (true) {
            go = Play() ;
            if (go==false) {
                board.clearBoard();
            }        
        }                    
    }       
    
    
    public void startPlayers(){
        System.out.println("Ange namnet av spelare 1 ?");
        if(choosePlayer() == 1)
            this.Lisa = new Human(1);
        else
            this.Lisa  = new Computer(1);
        
        System.out.println("----------------");
        System.out.println("Ange namnet av spelare 2 ?");
        
        if(choosePlayer() == 1)
            this.Max = new Human(2);
        else
            this.Max = new Computer(2);
        
    }
    
    public int choosePlayer(){
        int accept=0;
        
        do{
            System.out.println("1. Human");
            System.out.println("2. Dator\n");
            System.out.print("Vem ska spela: ");
            accept = input.nextInt();
            
            if(accept != 1 && accept != 2)
                System.out.println("input är ogiltig  ! Försök igen");
        }while(accept != 1 && accept != 2);
        
        return accept;
    }
    
    public boolean Play(){
        board.showBoard();
        if(won() == 0 ){
            System.out.println("-------------------");
            System.out.println("\nTurn "+turn);
            System.out.println("Now turn of Player " + who() );
            
            if(who()==1)
                Lisa.play(board);
            else
                Max.play(board);
           
             if(board.fullBoard()){
                System.out.println("Full Board. Draw!");
                return false;
            
             }
           who++;
            turn++;

            return true;
            } 
            else{
            if(won() == -1 )
                System.out.println("Lisa har vunnit!");
            else
                System.out.println("Max har vunnit!");
            return false;
          
            }
            
    }     
    
    public int who(){
        if(who%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int won(){
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
        
        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
    
}
                    
               
        
      
    

    

