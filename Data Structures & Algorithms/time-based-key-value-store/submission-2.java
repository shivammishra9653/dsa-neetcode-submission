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
        Value v = new Value(value, timestamp);
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(v);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!timeMap.containsKey(key)) {
            return res;
        }
        int maxTime = 0;
        for(Value v : timeMap.get(key)) {
            int currTime = v.timestamp;
            if(currTime <= timestamp && currTime >= maxTime) {
                res = v.value;
                maxTime = currTime;
            }
        }
        return res;
    }
}
