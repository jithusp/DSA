package org.griddynamics.august1;

public class StockBacktracking {

    public int maxProfit(int[] prices) {

        return backtrack(prices, 0, false, 0);
    }

    private int backtrack(int[] prices, int day, boolean holding, int profit) {
        if (day == prices.length) {
            return profit;
        }

        // Skip the current day
        int max = backtrack(prices, day + 1, holding, profit);

        if (holding) {
            // Option to sell
            int sell = backtrack(prices, day + 1, false, profit + prices[day]);
            max = Math.max(max, sell);
        } else {
            // Option to buy
            int buy = backtrack(prices, day + 1, true, profit - prices[day]);
            max = Math.max(max, buy);
        }

        return max;
    }

    public static void main(String[] args) {
        StockBacktracking s = new StockBacktracking();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Backtracking): " + s.maxProfit(prices)); // Output: 7
    }
}
