package com.study.javaalgorithm.programmers.level2.위장;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};

		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		Map<String, List<String>> clotheGroup = new HashMap<>();
		List<String> temp;

		for (String[] clothe : clothes) {
			String key = clothe[1];
			if (clotheGroup.containsKey(key)) {
				clotheGroup.get(key).add(clothe[0]);
			} else {
				temp = new ArrayList<>();
				temp.add(clothe[0]);
				clotheGroup.put(key, temp);
			}
		}

		int result = 1;
		for (String key : clotheGroup.keySet()) {
			result = result * (clotheGroup.get(key).size() + 1);
		}

		return result - 1;
	}

}
