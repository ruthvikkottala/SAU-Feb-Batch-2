package com.rv;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Question2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String inp="";
		inp=new String(Files.readAllBytes(Paths.get("C:\\Users\\dell\\eclipse-workspace\\Multithreading\\input.txt")));
//	    System.out.println(inp);
		
		String[] arr=inp.split("\\.");
		int count=0;
		long start=System.currentTimeMillis();
		for(String s:arr) {
			count+=countWords(s.trim());
		}
		long elapsed=System.currentTimeMillis()-start;
		System.out.println("Number of words : "+count);
	  System.out.println("Without Multithreading : "+elapsed+"milliseconds");
	  int len=arr.length;
	
	  ThreadCount t1=new ThreadCount(arr,0,len/8);
	  ThreadCount t2=new ThreadCount(arr,len/8,2*(len/8));
	  ThreadCount t3=new ThreadCount(arr,2*(len/8),3*(len/8));
	  ThreadCount t4=new ThreadCount(arr,3*(len/8),4*(len/8));
	  ThreadCount t5=new ThreadCount(arr,4*(len/8),5*(len/8));
	  ThreadCount t6=new ThreadCount(arr,5*(len/8),6*(len/8));
	  ThreadCount t7=new ThreadCount(arr,6*(len/8),7*(len/8));
	  ThreadCount t8=new ThreadCount(arr,7*(len/8),len);
	  long start1=System.currentTimeMillis();
	  t1.start();
	  t2.start();
	  t3.start();
	  t4.start();
	  t5.start();
	  t6.start();
	  t7.start();
	  t8.start();
	  t1.join();
	  t2.join();
	  t3.join();
	  t4.join();
	  t5.join();
	  t6.join();
	  t7.join();
	  t8.join();
	  
	  long elapsed1=System.currentTimeMillis()-start1;
	  System.out.println("Number of words : "+(t1.count+t2.count+t3.count+t4.count+t5.count+t6.count+t7.count+t8.count));
	  System.out.println("With Mutltithreading : "+elapsed1+"milliseconds");


}
//
public static int countWords(String ip) {
	return ip.split("\\s+").length;
}
	

}

class ThreadCount extends Thread{
	int count=0,start,end;
	String[] arr;
	ThreadCount(String[] arr,int start,int end){
		this.start=start;
		this.end=end;
		this.arr=arr;
	}
	public void run() {
		String[] arr1=Arrays.copyOfRange(arr, start,end ); 
		for(String s:arr1) {
			count+=Question2.countWords(s.trim());
		}
		
	 }
	
}

