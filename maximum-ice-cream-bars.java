class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int value =0;
        for(int i=0;i<costs.length; i++){
            value += costs[i];
            if(value > coins){
                return i;
            }
        }
        return costs.length;
    }
}