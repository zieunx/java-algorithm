package com.study.javaalgorithm.programmers.level2.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	List<String> newMenuList = new ArrayList<>();

	Map<String, Integer> ranking = new HashMap<>();
	Set<String> menusByOrder = new HashSet<>();
	int max = 0;

	public List<String> solution(String[] orders, int[] course) {
		// List<String> newMenuList = new ArrayList<>();
		//
		// Map<String, Integer> ranking = new HashMap<>();
		// Set<String> menusByOrder = new HashSet<>();
		//
		for (int size : course) {
			max = 0;
			for (String order : orders) {
				if (order.length() < size) {
					continue;
				}
				menusByOrder.clear();

				combineMenu(menusByOrder, order, 0, size, "");

				for (String menu : menusByOrder) {
					// System.out.println("menu ! " + menu);
					int count = ranking.containsKey(menu) ? ranking.get(menu) + 1 : 1;
					ranking.put(menu, count);

					max = Math.max(count, max);
				}
			}

			if (max != 1) {
				for (String newMenu : ranking.keySet()) {
					if (max == ranking.get(newMenu)) {
						newMenuList.add(newMenu);
					}
				}
			}

			ranking.clear();
		}

		Collections.sort(newMenuList);
		return newMenuList;
	}

	public void combineMenu(Set<String> menusByOrder, String order, int index, int setMenuSize, String menu) {
		if (setMenuSize == menu.length()) {
			char[] chars = menu.toCharArray();
			Arrays.sort(chars);
			menusByOrder.add(new String(chars));
			return;
		}
		for (int i = index; i < order.length(); i++) {
			if (menu.contains(String.valueOf(order.charAt(i)))) {
				continue;
			}
			// System.out.println("menu: " + menu + " / i = " + i);
			combineMenu(menusByOrder, order, index, setMenuSize, menu + order.charAt(i));
		}
	}
}
