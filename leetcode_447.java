public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int resault = 0;
        
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                int distance = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                map.put(distance, map.getOrDefault(distance, 0)+1);
            }
            for(Integer val:map.values()){
                resault += val*(val-1);
            }
            map.clear();
        }
        return resault;
    }
}