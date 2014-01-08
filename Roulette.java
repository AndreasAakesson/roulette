package roulette;

/**
 *
 * @author Andreas, s188900
 */
import java.util.*;

public class Roulette 
{    
    private static final int MAX = 10000000;
    private static final int BLACK = 0, RED = 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        long start = System.currentTimeMillis();
        int[][] info = roulette(MAX);
        long end = System.currentTimeMillis();
        long diff = end-start;
        System.out.println(diff + " ms");
        
        System.out.println("Black: " + info[1][BLACK]);
        System.out.println("Red: " + info[1][RED]);
        
        for(int i = 1; i < info[0].length; i++)
        {
            System.out.println(i + ": " + info[0][i]);
        }
    }
    /**
     * 
     * @param n Antall runder.
     * @return første element = sekvenser, andre = færge-trekk.
     */
    private static int[][] roulette(int n)
    {
        Random r = new Random();
        int count = 0;
        int colors[] = new int[2];
        int color = r.nextInt(2);
        int seq = 1;
        int seqs[] = new int[1];
        
        while(count < n)
        {
            count++;
            colors[color]++;
            int prevColor = color;
            color = r.nextInt(2);
            
            if(color == prevColor)
                seq++;
            else
            {
                if(seq >= seqs.length)
                {
                    int tmp[] = new int[seq+1];
                    System.arraycopy(seqs, 0, tmp, 0, seqs.length);
                    seqs = tmp;
                }
                seqs[seq]++;
                seq = 1;
            }
        }   
        return new int[][] { seqs, colors };
    }
}
