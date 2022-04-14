package com.study.javaalgorithm.programmers.level2.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	public List<String> solution(String[] orders, int[] course) {
		List<String> newMenuList = new ArrayList<>();

		Map<String, Integer> ranking = new HashMap<>();
		Set<String> menusByOrder = new HashSet<>();
		for (int size : course) {
			int max = 0;
			for (String order : orders) {
				if (order.length() < size) {
					continue;
				}
				// System.out.println("==== {" + order + " / size = " + size + "} ====");
				menusByOrder.clear();
				for (int i = 0; i < order.length(); i++) {
					combineMenu(menusByOrder, order, i, size, "");
				}
				for (String menu : menusByOrder) {
					// System.out.println("menu ! " + menu);
					int count = ranking.containsKey(menu) ? ranking.get(menu) + 1 : 1;
					ranking.put(menu, count);

					max = Math.max(count, max);
				}
			}
			// ranking.keySet()
			// 	.forEach(key -> System.out.println("key: " + key + " / count: " + ranking.get(key)));

			final int finalMax = max;

			if (finalMax != 1) {
				newMenuList.addAll(ranking.keySet()
					.stream()
					.filter(key -> finalMax == ranking.get(key))
					.collect(Collectors.toList()));
			}

			ranking.clear();
		}

		Collections.sort(newMenuList);
		return newMenuList;
	}

	public void combineMenu(Set<String> distinctMenu, String order, int index, int setMenuSize, String menu) {
		if (setMenuSize == menu.length()) {
			char[] chars = menu.toCharArray();
			Arrays.sort(chars);
			distinctMenu.add(String.join("", String.join(",", new String(chars))));
			return;
		}
		if (index == order.length() - 1) {
			return;
		}
		for (int i = index; i < order.length(); i++) {
			if (menu.contains(String.valueOf(order.charAt(i)))) {
				continue;
			}
			// System.out.println("menu: " + String.join(",", menu) + " / i = " + i);
			combineMenu(distinctMenu, order, index, setMenuSize, menu + order.charAt(i));
		}
	}
}
