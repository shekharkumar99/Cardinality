// BJKST1.java
// BJKST1 distinct elements counter
// awirth for COMP90056
// Aug 2017,8

import java.util.Arrays;
import java.util.PriorityQueue;

public class BJKST1 implements Distinct{
	
	private int t;
	private int dom;
	private int ran;
	private Hash h;
	private PriorityQueue<Integer> pq;
	//private int n;
	
	public BJKST1(int n, int eps1){
		// input 1/eps .. eps1
		this.dom = n;
		this.ran = 536870912-3;
		//this.ran = n*n*n; // ideally
		h = new Hash();
		
		t = 96*eps1*eps1;	//magic number 96 from BJKST paper
		pq = new PriorityQueue<Integer>(t);
	}
	
	public void add(Object o){
		int val = Hash.h_basic(o,dom);
		val = h.h2u(val,ran);
		


		if(pq.size()<t){
			pq.add(-val);
			// while filling up the PQ, add the new value
		} else{
			int m = pq.peek();
			// if less than the largest and not already present
			if(val < -m && !pq.contains(-val)){
				pq.poll();
				pq.add(-val);
			}
		}
	}
	public double distinct(){
		// find out the largest value in the priority queue,
		// which is actually, the smallest negated
		int m = pq.peek();
		//System.out.format("m %8d t %8d ran %8d%n",(-m),t,ran);		
		
		return (double)t*(double)ran/(double)(-m);
	}
	
}
