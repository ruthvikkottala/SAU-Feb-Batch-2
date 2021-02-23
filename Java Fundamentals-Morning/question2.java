package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class question2 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
	
	
	
		FileInputStream	fis = new FileInputStream("output.txt");
		ObjectInputStream ois;
	
		
			ois = new ObjectInputStream(fis);
			Save ob;
		
			ob = (Save)ois.readObject();
			HashMap<Integer, Integer> result2=sortValues(ob.result1);
		
//		for (Integer i : result2.keySet()) {
//			  System.out.println("key: " + i + " value: " + result2.get(i));
			FileWriter csvWriter= new FileWriter("result2.csv");
			csvWriter.append("Rank");
			csvWriter.append(",");
			csvWriter.append("Rollno");
			csvWriter.append(",");
			csvWriter.append("Totalmarks");
			csvWriter.append("\n");
			ArrayList<Integer> keyList=new ArrayList<Integer>(result2.keySet());
			Collections.reverse(keyList);
			int startFlag=1,loopFlag=0,rank=1;
			if(keyList.size()<5) startFlag=0;
			for(Integer i : keyList) 
			{
				if(loopFlag==5) return;
				ArrayList<String> pushList=new ArrayList<String>();
				pushList.add(String.valueOf(rank));
				pushList.add(String.valueOf(i));
				pushList.add(String.valueOf(result2.get(i)));
				csvWriter.append(String.join(",",pushList ));
				csvWriter.append("\n");
				rank+=1;
				if(startFlag==1) loopFlag+=1;
			}
			csvWriter.close();
		ois.close();
		}
	
	
	private static HashMap sortValues(HashMap map)   
	{   
	List list = new LinkedList(map.entrySet());  
	//Custom Comparator  
	Collections.sort(list, new Comparator()   
	{  
	public int compare(Object o1, Object o2)   
	{  
	return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());  
	}  
	});  
	//copying the sorted list in HashMap to preserve the iteration order  
	HashMap sortedHashMap = new LinkedHashMap();  
	for (Iterator it = list.iterator(); it.hasNext();)   
	{  
	 Map.Entry entry = (Map.Entry) it.next();  
	sortedHashMap.put(entry.getKey(), entry.getValue());  
	}   
	return sortedHashMap;  
	} 
}

