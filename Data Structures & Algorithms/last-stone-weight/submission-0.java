class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        while(list.size() > 1) {
            Collections.sort(list);
            int x = list.remove(list.size() - 1);
            int y = list.remove(list.size() - 1);
            list.add(x - y);
        }
        return list.get(0);
    }
}
