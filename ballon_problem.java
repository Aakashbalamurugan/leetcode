class Solution {
    public int maxNumberOfBalloons(String text) {
    HashMap<Character, Integer> count = new HashMap<>();
       char[] arr = text.toCharArray();
       for(int i=0;i<arr.length; i++){
            if(count.containsKey(arr[i])){
                count.put(arr[i], count.get(arr[i])+1);
            }else{
                 count.put(arr[i],1);
            }
       }
    int b = count.getOrDefault('b', 0);
    int a = count.getOrDefault('a', 0);
    int l = count.getOrDefault('l', 0) / 2;
    int o = count.getOrDefault('o', 0) / 2;
    int n = count.getOrDefault('n', 0);

return Math.min(
    Math.min(b, a),
    Math.min(Math.min(l, o), n));
    }
}