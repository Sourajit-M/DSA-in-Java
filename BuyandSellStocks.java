public class BuyandSellStocks {
    public static int Stocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
         
        for(int i=0; i<prices.length; i++){
            int p = prices[i];
            if(buyPrice < p){
                int profit = p - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buyPrice = p;
            }
        }
        return maxProfit;
    }
 public static void main(String args[]){
    int price[] ={7,1,5,3,6,4};
    System.out.println(Stocks(price));
 }   
}

