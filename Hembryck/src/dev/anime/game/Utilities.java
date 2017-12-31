package dev.anime.game;

import java.awt.Color;

public class Utilities {
	
	public static Color getColorPercentage(int current, int max) {
		double percentage = (double) (current / max);
		if (percentage > .6) return Color.GREEN;
		if (percentage > .2) return Color.YELLOW;
		return Color.RED;
	}
	
	public static class Pair<K, V> {
		
		private K key;
		private V value;
		
		public Pair<K, V> put(K key, V value) {
			this.key = key;
			this.value = value;
			return this;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
	}
	
	public static class Tuple<K, V1, V2> {
		
		private K key;
		private V1 value1;
		private V2 value2;
		
		public Tuple<K, V1, V2> put(K key, V1 value1, V2 value2) {
			this.key = key;
			this.value1 = value1;
			this.value2 = value2;
			return this;
		}
		
		public void setKey(K key) {
			this.key = key;
		}
		
		public void setValue1(V1 value1) {
			this.value1 = value1;
		}
		
		public void setValue2(V2 value2) {
			this.value2 = value2;
		}
		
		public K getKey() {
			return key;
		}
		
		public V1 getValue1() {
			return value1;
		}
		
		public V2 getValue2() {
			return value2;
		}
		
	}
	
}
