package Misc;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dateRange = br.readLine().split(",");
        trimmer(dateRange);

        //Parse Dates
        MyDate beginning = dateBuilder(dateRange[0]);
        MyDate end = dateBuilder(dateRange[1]);

        Map<MyDate, Map<String, Integer>> clusteredEngagements = new HashMap<>();

        br.readLine();
        String engagement = br.readLine();
        while (engagement != null && !engagement.equals("")){
            String[] entry = engagement.split(",");
            trimmer(entry);

            //Construct myDate
            MyDate myDate = dateBuilder(entry[0]);

            //If within bounds and > 0, add to list
            if (myDate.withinBounds(beginning, end)){
                int numEngagements = Integer.parseInt(entry[2]);
                String engagementType = entry[1];

                Map<String, Integer> typeToOccurrences = clusteredEngagements.containsKey(myDate) ?
                        clusteredEngagements.get(myDate) :
                        new HashMap<>();

                int occurrences = typeToOccurrences.containsKey(engagementType) ?
                        typeToOccurrences.get(engagementType) :
                        0;

                occurrences += numEngagements;
                typeToOccurrences.put(engagementType, occurrences);
                clusteredEngagements.put(myDate, typeToOccurrences);
            }
            engagement = br.readLine();
        }


        //Sort list
        List<MyDate> dates = new ArrayList<>();
        dates.addAll(clusteredEngagements.keySet());

        Collections.sort(dates);

        for (int i = dates.size() - 1; i >= 0; i--) {
            MyDate date = dates.get(i);
            System.out.print(date.toString() + ", ");

            Map<String, Integer> typeToOccurrences = clusteredEngagements.get(date);

            List<String> types = new ArrayList<>();
            types.addAll(typeToOccurrences.keySet());
            Collections.sort(types);

            for (int j = 0; j < types.size(); j++) {
                String type = types.get(j);
                System.out.print(type + ", " + typeToOccurrences.get(type));
                if (j < types.size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static MyDate dateBuilder(String d){
        String[] arr = d.split("-");
        String mon = arr[1];
        int month;
        if (mon.indexOf('0') == 0){
            month = Integer.parseInt(mon.substring(mon.indexOf('0') + 1));
        }
        else {
            month = Integer.parseInt(mon);
        }

        int year = Integer.parseInt(arr[0]);
        return new MyDate(month, year);
    }

    private static class MyDate implements Comparable<MyDate> {
        int month, year;

        MyDate(int m, int y){
            month = m;
            year = y;
        }

        boolean withinBounds(MyDate begin, MyDate end){
            return compareTo(end) <= 0 && compareTo(begin) >= 0;
        }

        @Override
        public int compareTo(MyDate o) {
            if (year == o.year){
                if (month < o.month) return -1;
                if (month > o.month) return 1;
                return 0;
            }
            return year < o.year ? -1 : 1;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyDate other = (MyDate) o;
            return month == other.month && year == other.year;
        }

        @Override
        public int hashCode(){
            return month * 400 + year * 100;
        }

        @Override
        public String toString(){
            return String.valueOf(year) + '-' + (month < 10 ? "0" + month : month);
        }
    }

    private static void trimmer(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
    }
}
