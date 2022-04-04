package com.study.javaalgorithm.programmers.level3.자물쇠와열쇠;

import java.util.List;

public class Solution {
	public boolean solution(int[][] key, int[][] lock) {
		// 확장락 크기 = 락크기 + (키크기 - 1) * 2
		int extensionSize = lock.length + (key.length - 1) * 2;
		int[][] extensionLock = new int[extensionSize][extensionSize];

		// 확장자물쇠에 기존자물쇠 초기화
		for (int x = 0; x < extensionLock.length; x++) {
			for (int y = 0; y < extensionLock.length; y++) {
				extensionLock[x][y] = -1; // 밖의 값은 -1로 초기화
			}
		}

		boolean containLockHole = false;
		for (int i = key.length - 1; i < (key.length - 1) + (lock.length); i++) {
			for (int j = key.length - 1; j < (key.length - 1) + (lock.length); j++) {
				extensionLock[i][j] = lock[i - (key.length - 1)][j - (key.length - 1)];

				if (lock[i - (key.length - 1)][j - (key.length - 1)] == 0) {
					containLockHole = true;
				}
			}
		}

		if (!containLockHole) {
			return true;
		}

		// printLock(extensionLock);

		for (int i = 0; i < 4; i++) {
			// printLock(key);
			for (int x = 0; x <= extensionSize - key.length; x++) {
				for (int y = 0; y <= extensionSize - key.length; y++) {
					if (canOpenLock(extensionLock, key, x, y)) {
						return true;
					}
				}
			}
			key = rotate90(key);
		}

		return false;
	}

	private boolean canOpenLock(int[][] extensionLock, int[][] key, int x, int y) {
		// 준규가 찾아줌
		// 자물쇠 자체에 0 이 없어야 함. 확장자물쇠를 copy 하여 copy 에 0 이 있는지 확인하는 부분 필요했음.
		int[][] copyExtensionLock = new int[extensionLock.length][extensionLock.length];
		for (int i = 0; i < extensionLock.length; i++) {
			for (int j = 0; j < extensionLock.length; j++) {
				copyExtensionLock[i][j] = extensionLock[i][j];
			}
		}

		// System.out.println("(x, y) : " + x + ", " + y);
		for (int i = x; i < x + key.length; i++) {
			for (int j = y; j < y + key.length; j++) {
				boolean isFitHole = (copyExtensionLock[i][j] == 0 && key[i - x][j - y] == 1) ||
					(copyExtensionLock[i][j] == 1 && key[i- x][j - y] == 0);
				if (isFitHole) {
					copyExtensionLock[i][j] = 1;
				} else if (copyExtensionLock[i][j] == 1 && key[i - x][j - y] == 1) { // 준규가 찾아줌
					copyExtensionLock[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < copyExtensionLock.length; i++) {
			for (int j = 0; j < copyExtensionLock.length; j++) {
				if (copyExtensionLock[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private int[][] rotate90(int[][] key) {
		int[][] rotationKey = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				rotationKey[i][j] = key[key.length - 1 - j][i];
			}
		}
		return rotationKey;
	}

	private void printLock(int[][] lock) {
		for (int x = 0; x < lock.length; x++) {
			for (int y = 0; y < lock.length; y++) {
				System.out.printf("%3d", lock[x][y]);
			}
			System.out.println();
		}

		System.out.println("============================================================");
	}
}

