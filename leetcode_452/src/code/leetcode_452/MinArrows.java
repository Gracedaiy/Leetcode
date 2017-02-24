package code.leetcode_452;
import java.util.Arrays;
import java.util.Comparator;

public class MinArrows {	
	public static void main(String[] args){
		//A basic example
		int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		System.out.println(Arrays.deepToString(points));
		MinArrows res = new MinArrows();
		int fin = res.findMinArrowShots(points);
		System.out.println(fin);
	}
	
	public int findMinArrowShots(int[][] points){
		int count = 1;
		//Ordering the array by the first element of each pair
		Arrays.sort(points, new Comparator<int[]>(){
			@Override
			public int compare(int[] x, int[] y){
				return x[0] - y[0];
			}
		});
		System.out.println(Arrays.deepToString(points));
		
		int end = points[0][1];
		for(int i = 0; i < points.length; i++){
			int begin = points[i][0];
			if(begin <= end){
			    end = Math.min(end, points[i][1]);
				continue;
			}else{
				count++;
				end = points[i][1];
			}
		}
		return count;
	}
}
