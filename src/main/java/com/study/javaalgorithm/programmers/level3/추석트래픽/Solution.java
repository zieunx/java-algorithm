package com.study.javaalgorithm.programmers.level3.추석트래픽;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Local;

public class Solution {

	public static void main(String[] args) {
		String[] lines = {
			"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"
		};
		// 응답날짜 응답시간 처리시간(0.xxxs)

		System.out.println(solution(lines));
	}


	public static int solution(String[] lines) {
		int answer = 0;
		List<Line> lineList = new ArrayList<>();
		LocalDateTime minDateTime = null;
		LocalDateTime maxDateTime = null;

		for (int i = 0; i < lines.length; i = i + 1) {
			Line line = Line.ofLine(lines[i]);
			lineList.add(line);

			if (i == 0) {
				minDateTime = line.getStart();
				maxDateTime = line.getEnd();
			} else if (line.getStart().isBefore(minDateTime)) {
				minDateTime = line.getStart();
			} else if (line.getEnd().isAfter(maxDateTime)) {
				maxDateTime = line.getEnd();
			}
		}
		for (Line currentLine : lineList) {
			int currentCount = 0;
			LocalDateTime rangeStart = currentLine.getEnd();
			LocalDateTime rangeEnd = currentLine.getEnd().plusSeconds(1);

			for (Line compare : lineList) {
				if (lineList.indexOf(currentLine) == lineList.indexOf(compare)) {
					continue;
				}
				if ((rangeStart.isAfter(compare.getStart()) && rangeEnd.isBefore(compare.getStart())) ||
					((rangeStart.isBefore(compare.getStart()) || rangeStart.isEqual(compare.getStart())) && rangeEnd.isAfter(compare.getEnd())) ||
					(rangeStart.isAfter(compare.getStart()) && (rangeEnd.isEqual(compare.getEnd()) || rangeEnd.isAfter(compare.getEnd())))) {
					currentCount = currentCount + 1;
				}
			}

			answer = Math.max(answer, currentCount);
		}

		return answer;
	}

	static class Line {
		LocalDateTime start;
		LocalDateTime end;

		public Line(LocalDateTime start, LocalDateTime end) {
			System.out.println("new Line (start = " + start + ", end = " + end + ")");
			this.start = start;
			this.end = end;
		}

		public static Line ofLine(String line) {
			String[] splitLine = line.split(" ");
			String[] dates = splitLine[0].split("-");
			String[] times = splitLine[1].split(":");
			int second = Integer.parseInt(times[2].split("\\.")[0]);
			int mills = Integer.parseInt(times[2].split("\\.")[1]) * 1000000;
			String during = splitLine[2].split("s")[0];

			LocalDateTime endDateTime = LocalDateTime.of(
				LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])),
				LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]), second, mills)
			);
			LocalDateTime startDateTime = endDateTime.minusNanos((long) (Double.parseDouble(during) * 1000) * 1000000);

			return new Line(startDateTime, endDateTime);
		}

		public LocalDateTime getStart() {
			return start;
		}

		public LocalDateTime getEnd() {
			return end;
		}
	}
}
