class TimeMap {

    class Value {
        String value;
        int timestamp;

        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Value>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!timeMap.containsKey(key)) {
            return res;
        }
        List<Value> values = timeMap.get(key);
        int l = 0;
        int r = values.size() - 1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(values.get(mid).timestamp <= timestamp) {
                res = values.get(mid).value;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return res;
    }
}
