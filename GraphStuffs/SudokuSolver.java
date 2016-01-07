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
public class SudokuSolver {

    private boolean colorNumber[];
    private int nodeValue[];

    public SudokuSolver() {
        colorNumber = new boolean[9];
        nodeValue = new int[81];
        for(int i=0; i<81; i++)
            nodeValue[i] = -1;

    }
    
    private void questionValue(int pos, int value) {
        nodeValue[pos-1] = value - 1;
    }
    
    private void solveSudoku(Graph graph)
    {
        for(int v = 0; v < graph.vertices() && nodeValue[v] == -1; v++)
        {
            for(Object j : graph.adj(v))
                if(nodeValue[(int)j] != -1)
                    colorNumber[nodeValue[(int)j]] = true;
            
            for(int i = 0; i<9; i++)
                if(colorNumber[i] == false)
                {
                    nodeValue[v] = i;
                    System.out.println("yes");
                    break;
                }
            for(int i=0; i<9; i++)
                colorNumber[i] = false;
        }
    }
    
    public void showSolved()
    {
        for(int i =0; i<=72; i+=9)
        {
            for(int j = 0; j<9; j++)
                System.out.print(nodeValue[j+i]+1 + " ");
            System.out.println();
        }
        
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(81);
        SudokuBoard board = new SudokuBoard(graph);
        SudokuSolver solve = new SudokuSolver();

        String line = null;
        String lineSplit[] = new String[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Sourav Kumar Paul\\Documents\\GraphStuffs\\src\\graphstuffs\\SudokuQuestion.txt"));
            while ((line = reader.readLine()) != null) {
                lineSplit = line.split(" ");
                solve.questionValue(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]));
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        solve.solveSudoku(graph);
        solve.showSolved();

    }

    

}
