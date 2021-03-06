/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

import java.io.IOException;

/**
 *
 * @author ronaldofs
 */
public class TSPMetaheuristic
{

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  static int sumgraph(Integer[][] graph)
  {
    int n = graph.length;
    int j;
    int sum = 0;
    for(int i = 0; i < n-1; i++)
    {
      j = i+1;
      sum += graph[i][j];
    }
    sum += graph[n-1][0];
    return sum;
  }
  public static void main(String[] args) throws IOException
  {
    MyFileReader fr;
    Printer P;
    P = new Printer();
    fr = new MyFileReader();
    TSP tsp = new TSP();
    Metaheuristic M = new Metaheuristic();
    Integer[] tabuSol;
    Integer[][] graph;
    graph = fr.readFile("test/test.tsp");
    long start = System.nanoTime();
    Integer[] initialCycle = tsp.findInitialSolution(graph);
    tabuSol = M.buscaTabu(5, graph, initialCycle.clone());
    long end = System.nanoTime();
    double time = end - start;
    time /= 1000000;
    //P.printGraph(graph);
    
    //P.printCycle(initialCycle);
    System.out.println("size1: "+tsp.cycleSize(graph, initialCycle));
    //P.printCycle(tabuSol);
    System.out.println("size: "+ tsp.cycleSize(graph, tabuSol));
    System.out.println("time: " + time);

  }

}
