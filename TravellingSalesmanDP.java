import java.util.Arrays;

public class TravellingSalesmanDP {
    // Number of cities
    private static int n = 4; 

    // Cost matrix representing distances between cities
    private static int[][] cost = {
        {0, 10, 15, 20}, // Distances from city 0 to others
        {10, 0, 35, 25}, // Distances from city 1 to others
        {15, 35, 0, 30}, // Distances from city 2 to others
        {20, 25, 30, 0}  // Distances from city 3 to others
    };

    // Initialize dp array to store minimum cost for subproblems
    private static int[][] dp; // dp[currentCity][visitedIndex]
    private static int[][] path; // To store the path that leads to the minimum cost

    // Function to solve the TSP using Dynamic Programming
    public static int tsp(int currentCity, int visitedIndex, boolean[] visited) {
        // Base case: If all cities have been visited, return the cost to return to the starting city
        if (visitedIndex == n) { // All cities visited
            return cost[currentCity][0]; // Return to starting city
        }

        // If the result is already computed, return it from dp
        if (dp[currentCity][visitedIndex] != -1) {
            return dp[currentCity][visitedIndex];
        }

        int minCost = Integer.MAX_VALUE;

        // Try to go to every city that is not yet visited
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (!visited[nextCity]) { // If nextCity is not visited
                visited[nextCity] = true; // Mark nextCity as visited
                int newCost = cost[currentCity][nextCity] + tsp(nextCity, visitedIndex + 1, visited); // Recursive call
                if (newCost < minCost) {
                    minCost = newCost; // Update minimum cost
                    path[currentCity][visitedIndex] = nextCity; // Store the city that gives the minimum cost
                }
                visited[nextCity] = false; // Backtrack: Mark nextCity as unvisited
            }
        }

        // Memorize the computed result
        dp[currentCity][visitedIndex] = minCost;
        return minCost;
    }

    // Function to print the optimal path of cities
    public static void printOptimalPath(int startCity) {
        int currentCity = startCity;
        int visitedIndex = 1;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false); // Initially, no city is visited
        visited[0] = true; // Start from city 0

        System.out.print("Optimal Path: " + currentCity);
        while (visitedIndex < n) {
            int nextCity = path[currentCity][visitedIndex]; // Get the next city from path array
            if (nextCity == -1) { 
                break; // In case of an error, exit the loop
            }
            System.out.print(" -> " + nextCity);
            visited[nextCity] = true; // Mark the next city as visited
            currentCity = nextCity; // Move to the next city
            visitedIndex++;
        }
        System.out.println(" -> " + startCity); // Return to the starting city
    }

    public static void main(String[] args) {
        // Initialize visited array to keep track of visited cities
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false); // Initially, no city is visited
        visited[0] = true; // Start from city 0

        // Initialize dp and path arrays with -1
        dp = new int[n][n + 1];
        path = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(path[i], -1);
        }

        // Start the TSP function from city 0 with only city 0 visited
        int minTSPCost = tsp(0, 1, visited); // Start with city 0 and 1 city visited
        System.out.println("Minimum TSP cost: " + minTSPCost);

        // Print the optimal path
        printOptimalPath(0);
    }
}
