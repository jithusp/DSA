public class StockGreedy {

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If today's price > yesterday's price, take the profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        StockGreedy s = new StockGreedy();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Greedy): " + s.maxProfit(prices)); // Output: 7
    }
}
