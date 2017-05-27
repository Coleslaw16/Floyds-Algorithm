/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package floydsalgorithm;
import java.util.*;
import java.io.*;
/**
 *
 * @author John Stone
 */
public class FloydsAlgorithm {

    public static void main(String[] args) throws Exception {
        int[][] originalArray = readArr("input.txt");
        int[][] Floydsarray = copy(originalArray);
        //The next part is the actual Floydsarray algorithm
        for(int k=0;k<Floydsarray.length;k++)
            for(int i=0;i<Floydsarray.length;i++)
                for(int j=0;j<Floydsarray.length;j++)
                    Floydsarray[i][j] = Math.min(Floydsarray[i][j],(Floydsarray[i][k] + Floydsarray[k][j]));
        writeArr(Floydsarray,"output.txt");
    }
    
    public static int[][] readArr(String arrayFile)
    {
        try
        {
            Scanner in = new Scanner(new File(arrayFile));
            int nrows = in.nextInt();
            int mcols = in.nextInt();
            int[][] temp = new int[nrows][mcols];
            for(int i=0;i<nrows;i++)
            {
                for(int j=0;j<mcols;j++)
                {
                    temp[i][j] = in.nextInt();
                }
            }
            in.close();
            return temp;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.print("Couldn't find file ");
            return null;
        }
    }
    
    public static int[][] copy(int[][] temp)
    {
        int[][] copy1 = new int[temp.length][temp[0].length];
        for(int i=0;i<temp.length;i++)
            for(int j=0;j<temp[0].length;j++)
                copy1[i][j] = temp[i][j];
        return copy1;
    }
    
    public static void writeArr(int[][] temp, String filename)
    {
        try
        {
            PrintWriter out = new PrintWriter(filename);
            out.println(temp.length + " " + temp.length);
            for(int i=0;i<temp.length;i++)
            {
                for(int j=0;j<temp[0].length;j++)
                {
                    out.printf("%-8d",temp[i][j]);
                }
                out.println();
            } 
            out.close();
        }
        catch(IOException e)
        {
            System.out.print("That file could not be opened ");
        }
    }
}
