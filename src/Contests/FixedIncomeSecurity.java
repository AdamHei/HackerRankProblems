package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FixedIncomeSecurity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfPortfolios = Integer.parseInt(br.readLine().trim());
        int[] minIncAvail = toIntArray(br.readLine().split(" "));
        int minimumTradeSize = minIncAvail[0];
        int increment = minIncAvail[1];
        int availableUnits = minIncAvail[2];

        Map<Integer, List<String>> orderToIds = populateMap(br, numOfPortfolios);
        int totalOrder = totalOrder(orderToIds);

        Map<String, Integer> finalIdAndAllocation = new HashMap<>();

        List<String> tempIds;
        Set<Integer> orderSet = orderToIds.keySet();
        List<Integer> orders = new ArrayList<>();
        orders.addAll(orderSet);
        Collections.sort(orders);
        for (int orderAmount: orders){
            tempIds = orderToIds.get(orderAmount);
            Collections.sort(tempIds);
            for (String id: tempIds){
                double proportionalAllocation = orderAmount * availableUnits / totalOrder;
                if (proportionalAllocation < minimumTradeSize){
                    if (proportionalAllocation > minimumTradeSize / 2){
                        //TODO Allocate within mintradesize rules
                        finalIdAndAllocation.put(id, 0);
                    }
                    else{
                        finalIdAndAllocation.put(id, 0);
                    }
                }
                else{
                    if (proportionalAllocation >= orderAmount){
                        if (isTradeableAmount(minimumTradeSize, increment, orderAmount)){
                            finalIdAndAllocation.put(id, orderAmount);
                        }
                        else{
                            finalIdAndAllocation.put(id, 0);
                        }
                    }
                    else if (proportionalAllocation < minimumTradeSize){
                        finalIdAndAllocation.put(id, 0);
                    }
                    else{
                        int potentialAllocation = minimumTradeSize;
                        while (potentialAllocation <= proportionalAllocation){
                            potentialAllocation += increment;
                        }
                        potentialAllocation -= increment;
                        if (isTradeableAmount(minimumTradeSize, increment, orderAmount = potentialAllocation)){
                            finalIdAndAllocation.put(id, potentialAllocation);
                        }
                        else{
                            finalIdAndAllocation.put(id, 0);
                        }
                    }
                }
                //Could be orderAmount or what we just allocated
                totalOrder -= orderAmount;
//                totalOrder -= finalIdAndAllocation.get(id);
                availableUnits -= finalIdAndAllocation.get(id);
            }
        }

        List<String> ids = new ArrayList<>(finalIdAndAllocation.keySet());
        Collections.sort(ids);
        for (String id: ids){
            System.out.println(id + " " + finalIdAndAllocation.get(id));
        }
    }

    private static boolean isTradeableAmount(int minOrderSize, int increment, int amount){
        int temp = minOrderSize;
        while (temp <= amount){
            if (temp == amount){
                return true;
            }
            temp+=increment;
        }
        return false;
    }

    private static int totalOrder(Map<Integer, List<String>> map){
        int total = 0;
        for (int amount: map.keySet()){
            for (String s: map.get(amount)){
                total += amount;
            }
        }
        return total;
    }

    private static Map<Integer, List<String>> populateMap(BufferedReader br, int numOfPortfolios) throws IOException {
        Map<Integer, List<String>> orderToIds = new HashMap<>();
        for (int i = 0; i < numOfPortfolios; i++){
            String[] idAndOrder = br.readLine().split(" ");
            int order = Integer.parseInt(idAndOrder[1]);
            String id = idAndOrder[0];
            List<String> ids;
            if (orderToIds.get(order) != null){
                ids = orderToIds.get(order);
                ids.add(id);
                orderToIds.put(order, ids);
            }
            else{
                ids = new ArrayList<>();
                ids.add(id);
                orderToIds.put(order, ids);
            }
        }
        br.close();
        return orderToIds;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}