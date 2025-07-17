package org.griddynamics;

public class StockBuyAndSell {
        int[] prices = {1, 2, 9, 7, 6};
          // Output: 8
// multiple transactions
        public static int getMaxProfit(int[] prices){
            int minPrice=Integer.MAX_VALUE;
            int profit=0;
            for(int price:prices){
                if(price<minPrice){
                    minPrice=price;
                }
                else{
                    profit=Math.max(profit,price-minPrice);

                }
            }

            return profit;


}
    public static void main(String[] args) {
        int[] prices = {1, 2, 9, 7, 6};
        System.out.println("Max Profit: " + getMaxProfit(prices));  // Output: 8
    }
}

