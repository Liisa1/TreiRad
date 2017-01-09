/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreiRad;
import java.util.Scanner;


public class Human extends Player{
    public Scanner input = new Scanner(System.in);
    
    public Human(int player){
        super(player);
        this.player = player;
        System.out.println("Player 'Human' alive!");
    }

     @Override
    public void play(Board board){
        Try(board);
        
        board.setPosition(accept, player);
    }
    
    @Override
    public void Try(Board board){
        
        do{
            
            do{
                System.out.print("Line: ");
                accept[0] = input.nextInt();
                
                if( accept[0] > 3 ||accept[0] < 1)
                    System.out.println("Ogiltigt linje. Det är 1, 2 or 3");
                
            }while(accept[0] > 3 ||accept[0] < 1);
            
            do{
                System.out.print("Column: ");
                accept[1] = input.nextInt();
                
                if(accept[1] > 3 ||accept[1] < 1)
                    System.out.println("Ogiltigt column. Det är 1, 2 or 3");
                
            }while(accept[1] > 3 ||accept[1] < 1);
            
           accept[0]--; 
            accept[1]--;
            
            if(!checkTry(accept, board))
                System.out.println("Platsen redan upptaget. Försök igen!");
        }while( !checkTry(accept, board) );
    }
}
    

