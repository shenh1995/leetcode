package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L332 {
	/*
	 * 图的问题，把每张机票当作图的边，先建立图，建立图的时候使用PriorityQueue，从而能按照字母顺序从小建立，然后dfs进行遍历
	 * 
	 */
	public void dfs(String departure, Map<String, PriorityQueue<String>> graph, List<String> result) {
		/*
		 * 深度优先搜索，搜索到一个城市只是arrival city的时候(即没有出度的时候，把这个city记入到list中去，因为它肯定是最后达到的城市
		 * 然后依次向前类推)
		 */
		PriorityQueue<String> arrivals = graph.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), graph, result);
		}
		result.add(0, departure);
	}
	
	public List<String> findItinerary(String [][] tickets) {
		List<String> result = new ArrayList<String>();
		Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
		for(String [] iter : tickets) {
			//putIfAbsent与put的区别是如果，如果存在重复的key，那么putIfAbsent不会放入值，而put会覆盖
			graph.putIfAbsent(iter[0], new PriorityQueue<String>());
			graph.get(iter[0]).add(iter[1]);
		}
		dfs("JFK", graph, result);
		return result;
	}
}
