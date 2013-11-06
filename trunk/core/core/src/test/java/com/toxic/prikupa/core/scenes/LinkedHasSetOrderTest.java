/**
 * 
 */
package com.toxic.prikupa.core.scenes;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Strelock
 *
 */
public class LinkedHasSetOrderTest {
	
	public static class SomeObject{
		private final int value;
		public SomeObject(int val){
			this.value = val;
		}
		
		@Override
		public boolean equals(Object obj){
			super.equals(obj);
			if(!(obj instanceof SomeObject)){
				return false;
			}
			return (((SomeObject) obj).getValue()==this.getValue());
		}
		
		@Override
		public int hashCode(){
			return getValue();
		}

		public int getValue() {
			return value;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<SomeObject> set = new LinkedHashSet<LinkedHasSetOrderTest.SomeObject>();
		
		for(int i = 0 ; i<100 ; i++){
			set.add(new SomeObject(i));
		}
		
		System.out.println("ordered : ");
		for(SomeObject obj : set){
			System.out.print( obj.getValue() + " ; ");
		}
		
		set.add(new SomeObject(10));
		set.add(new SomeObject(20));
		set.add(new SomeObject(30));
		set.add(new SomeObject(40));
		set.add(new SomeObject(50));
		System.out.println();
		System.out.println("after inserting : ");
		for(SomeObject obj : set){
			System.out.print( obj.getValue() + " ; ");
		}

	}

}
