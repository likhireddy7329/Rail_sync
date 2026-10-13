import java.util.*;
import java.util.concurrent.*;

public class AlgorithmSmokeTest {
    public static void main(String[] args) throws Exception {
        check(Algorithms.kmp("vijayawada station", "station") == 11, "KMP");
        check(Algorithms.rabinKarp("abcabc", "bc").equals(List.of(1,4)), "Rabin-Karp");
        check(Arrays.equals(Algorithms.zFunction("aaaa"), new int[]{0,3,2,1}), "Z-function");
        check(Algorithms.ahoCorasick("delay alert delayed", List.of("delay","alert")).get("delay").equals(List.of(0,12)), "Aho-Corasick");
        check(Algorithms.levenshtein("guntur", "guntar") == 1, "Levenshtein");
        check(Algorithms.damerauLevenshtein("ab", "ba") == 1, "Damerau-Levenshtein");
        check(Arrays.equals(Algorithms.suffixArray("banana"), new int[]{5,3,1,0,4,2}), "suffix array");
        check(Arrays.equals(Algorithms.suffixArray("mississippi"), naiveSuffixArray("mississippi")), "suffix array mississippi");
        check(Arrays.equals(Algorithms.suffixArray("aaaa"), naiveSuffixArray("aaaa")), "suffix array repeated chars");
        check(Arrays.equals(Algorithms.suffixArray("abcab"), naiveSuffixArray("abcab")), "suffix array overlapping pattern");
        check(Algorithms.distinctSubstringCount("ababa") == 9, "suffix automaton distinct substrings");
        check(Algorithms.matrixChainCost(new int[]{30,35,15,5,10,20,25}) == 15125, "matrix-chain DP");
        check(Math.abs(Algorithms.optimalBstCost(new double[]{0.5,0.5})-1.5)<1e-9, "optimal BST");
        int[][] cap={{0,3,2},{0,0,2},{0,0,0}};
        check(Algorithms.maxFlow(cap,0,2)==4, "Edmonds-Karp");
        check(Algorithms.dinicMaxFlow(cap,0,2)==4, "Dinic");
        check(Algorithms.maxBipartiteMatching(new boolean[][]{{true,false},{true,true}})==2, "matching");
        check(Algorithms.solveSat(2,new int[][]{{1,2},{-1,2}})!=null, "SAT satisfiable");
        check(Algorithms.solveSat(1,new int[][]{{1},{-1}})==null, "SAT unsatisfiable");
        check(Algorithms.threeSatToClique(new int[][]{{1,-2,3},{-1,2,3}}).vertices().size()==6, "3-SAT to clique reduction");
        check(Algorithms.millerRabin(17), "Miller-Rabin prime");
        check(!Algorithms.millerRabin(21), "Miller-Rabin composite");
        int[] data={4,2,7,1,6};
        check(Arrays.equals(Algorithms.parallelInclusiveScan(data,3),new int[]{4,6,13,14,20}), "parallel scan");
        check(Algorithms.parallelReduceSum(data,3)==20, "parallel reduce");
        check(Algorithms.brentWorkEstimate(1000,4)==253, "Brent estimate");
        System.out.println("PASS: 22 algorithm checks succeeded.");
    }
    private static int[] naiveSuffixArray(String s){Integer[]idx=new Integer[s.length()];for(int i=0;i<idx.length;i++)idx[i]=i;Arrays.sort(idx,Comparator.comparing(s::substring));return Arrays.stream(idx).mapToInt(Integer::intValue).toArray();}
    private static void check(boolean condition,String name){if(!condition)throw new AssertionError(name+" failed");}
}
