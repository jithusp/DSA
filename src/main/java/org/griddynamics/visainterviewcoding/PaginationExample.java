package org.griddynamics.visainterviewcoding;

import java.util.*;

public class PaginationExample {
    public static void main(String[] args) {
        List<Map<String, Object>> data = generateMockJsonList();

        int pageNumber = 2;
        int pageSize = 10;

        List<Map<String, Object>> pageData = paginate(data, pageNumber, pageSize);

        pageData.forEach(System.out::println);
    }

    private static List<Map<String, Object>> generateMockJsonList() {
        List<Map<String, Object>> jsonList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Map<String, Object> json = new HashMap<>();
            json.put("id", i);
            json.put("name", "Employee " + i);
            jsonList.add(json);
        }
        return jsonList;
    }

    private static List<Map<String, Object>> paginate(List<Map<String, Object>> list, int pageNumber, int pageSize) {
        int totalSize = list.size();
        int from = (pageNumber - 1) * pageSize;
        int to = Math.max(pageSize + from, totalSize);
        if (from > totalSize || from < 0) {
            return Collections.emptyList();
        } else {
            return list.subList(from, to);
        }
    }
}
