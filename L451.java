package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L451 {
	
	public String frequencySort(String s) {    
	HashMap<Character,Integer> hashmap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int len=s.length();
    //构建<关键字，出现次数>Map
    for(int i=0;i<len;i++){
        char ch = s.charAt(i);
        if(!hashmap.containsKey(ch)){
            hashmap.put(ch,1);
        }
        else{
            hashmap.put(ch,hashmap.get(ch)+1);
        }
    }
    //按照Value的降序排列
    List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(hashmap.entrySet());
    Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
        public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
            return -o1.getValue().compareTo(o2.getValue());
        }
    });
    //输出
    for(Map.Entry<Character,Integer> mapping:list){
        for(int i=0;i<mapping.getValue();i++){
            sb.append(mapping.getKey());
        }
    }
    return sb.toString();
    }

	 public static void main(String[] args) {
		System.out.println(new L451().frequencySort("BabBbBbBbbABBABBbAabbbABBaBbBabaabBbbBAAaaAbbAABaAbBBaAaaaaBABbaBbAAbBBbbABBaaBBbabAbBBAAbAbaaaBrBBaAaabAbbBbABabABaBabBBBBBaAbAaABaaaAAaAgAaAaBAbaBaBaBbbbBbABBBBaaaBbbbAbbbBaBBaAbBBbbaaaaaBbbaaAAbAABBABBaAAABBbbBbBbbBbaABBAAbBAbabbbabwBbbBArABaBBbabBaBabABABaabBBABBAabBAAaabbbbBAababAaBaaAaBbBbBAAbaBabBbabaBaaBbaabABAbbBbaBAbabABbbaAaBbAAAbBbaabBBAbbbABbaabAAAaaaBaBaaaBBABbBAbAAbaABaabbbbBBAabbbBABBbaABBAAAabaAbaBAbbaBaBbAbaAAbBaBAbAabBBbBsBabbbAaBbabAAaABAaBAAAbbaBaAbABABBBAbABABbbbBaaBaBAbABAbaaAbBbAABBbAbbAaBbabaBbABAAbAABbbAabAaAaBbBBbAAbBbaaaBAbABBbBBaCabBBabBAaBbBaAbbBAbbBaBAabBAababAaAbaAaabBBBABabaabBAAAabBAAAbBAbAaaaAbAaBaAbbAaABABBbBBAABAabaAAbBaBbAAaabbABBBABaBAabAbAAbBbAabAbaBbAbBAABAABAAAbBaaaaBabbaBABBaABbAabBaBAbAbbABAbaAAbaAAaBaabaBbBBbBABAABBABBaabBBbBBABAAaAAbbBbABBBbAabAbABbAAAbbAbABbbAbBAbabbbBBBBbAAabaabBABABaaAbaBBBBbbABbBbBABBaAbAaBBABBBabAABBBBBbBBabBaaBbaaBaBbaBbbAABbbAaaBBBbabaabBABABBBGabbBAbaBabAaAAabbbBaabBBbABBabBabbBbAbbAaBbAaAabBabBBbaBLaAbbAaaBaabAAab"));
	}

}
