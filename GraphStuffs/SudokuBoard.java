/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sourav Kumar Paul
 */
public class SudokuBoard {
    
    public SudokuBoard(Graph graph) throws IOException
    {
       
        BufferedReader br = null;
        String line = null;
        String lineEl[];
        
        try{
            br = new BufferedReader(new FileReader("C:\\Users\\Sourav Kumar Paul\\Documents\\GraphStuffs\\src\\graphstuffs\\Sudoku.txt"));
            while((line = br.readLine()) != null)
            {
                lineEl = line.split(" ");
                graph.addEdge(Integer.parseInt(lineEl[0]), Integer.parseInt(lineEl[1]));
            }
            
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
    }
    
   
    
   
}
