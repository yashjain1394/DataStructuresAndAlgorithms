package section_39_dynamicProgramming;

public class DynamicProgrammingIntroduction {
	/*
	 * The first requirement of DP is overlapping subproblems.
	 * We store the solution of subproblems
	 * 
	 * 1	1	2	3	1	2	3	3
	 * 10	10	20	30	10	20	30	30
	 * 
	 * 
	 * 		10	20	30
	 * 0	1	2	3	4	5	6	7
	 * 
	 * The process of storing the answers of subproblems is called Memoization.
	 * Merge sort is non overlapping subproblem i.e. unique subproblem. Hence it is not a candidate for dynamic programming.
	 * 
	 * 
	 * The second requirement for DP is Optimized substructure.
	 * 
	 * 1	1	2	3	1	2	3	3
	 * 
	 * 
	 * ABCD is a graph and we want to find the highest/lowest cost path to go from A to D.
	 * 
	 * 
	 * Top-down: Recursively
	 * 
	 * Bottom-up: Iteratively
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
