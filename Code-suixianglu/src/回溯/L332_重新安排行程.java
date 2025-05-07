package 回溯;

import java.lang.invoke.VarHandle;
import java.util.*;

/**
 * @author: yangjiabin
 * @date: 2025/5/4 15:58
 * @desc:
 */
public class L332_重新安排行程 {
    class Solution {
        TreeMap<String, Deque<String>> treeMap = new TreeMap<>();
        List<String> tem = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        boolean done = false;
        public List<String> findItinerary(List<List<String>> tickets) {
//            for (int i = 0; i <= tickets.size() - 1; i++) {
//                String chufa = tickets.get(i).get(0);
//                String dest = tickets.get(i).get(1);
//                Deque<String> strings = treeMap.computeIfAbsent(chufa, k -> new LinkedList<>());
//                if (strings.isEmpty()) strings.add(dest);
//                else {
//                    List<String> list = (List<String>) strings;
//                    int len = list.size() - 1;
//                    for (int j = 0; j <= len; j++) {
//                        if (dest.compareTo(list.get(0)) < 0){
//                            list.add(j, dest);
//                        } else if (j == len) {
//                            list.add(j + 1, dest);
//                        }
//                    }
//                }
//            }
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                treeMap.putIfAbsent(from, new LinkedList<>());
                treeMap.get(from).add(to);
            }
            for (String key : treeMap.keySet()) {
                Collections.sort((List<String>) treeMap.get(key)); // 提前按字典序排序
            }
            ans.add("JFK");
            recur(0, tickets.size(), "JFK");
            return ans;
        }

        public void recur(int usedNum, int totalNum, String cur){
            if (done) return;

            if (usedNum == totalNum) {
                ans.addAll(tem);
                done = true;
                return;
            }

            Deque<String> choice = treeMap.get(cur);
            if (choice.isEmpty()) return;
            int len = choice.size() - 1;
            for (int i = 0; i <= len; i++) {
                String ticket = choice.pollFirst();
                tem.add(ticket);
                recur(usedNum + 1, totalNum, ticket);
                tem.remove(tem.size() - 1);
                choice.addFirst(ticket);
            }
        }
    }

    public static void main(String[] args) {
        L332_重新安排行程 l332_重新安排行程 = new L332_重新安排行程();
        Solution solution = l332_重新安排行程.new Solution();
        List<List<String>> tickets = new ArrayList<>();
        // 2. 添加每一对数据
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "AAA")));
        tickets.add(new ArrayList<>(Arrays.asList("AAA", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "BBB")));
        tickets.add(new ArrayList<>(Arrays.asList("BBB", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "CCC")));
        tickets.add(new ArrayList<>(Arrays.asList("CCC", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "DDD")));
        tickets.add(new ArrayList<>(Arrays.asList("DDD", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "EEE")));
        tickets.add(new ArrayList<>(Arrays.asList("EEE", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "FFF")));
        tickets.add(new ArrayList<>(Arrays.asList("FFF", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "GGG")));
        tickets.add(new ArrayList<>(Arrays.asList("GGG", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "HHH")));
        tickets.add(new ArrayList<>(Arrays.asList("HHH", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "III")));
        tickets.add(new ArrayList<>(Arrays.asList("III", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "JJJ")));
        tickets.add(new ArrayList<>(Arrays.asList("JJJ", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "KKK")));
        tickets.add(new ArrayList<>(Arrays.asList("KKK", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "LLL")));
        tickets.add(new ArrayList<>(Arrays.asList("LLL", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "MMM")));
        tickets.add(new ArrayList<>(Arrays.asList("MMM", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "NNN")));
        tickets.add(new ArrayList<>(Arrays.asList("NNN", "ATL")));

        solution.findItinerary(tickets);
    }


    class SolutionGPT {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            // 1. 构建图结构，并按字典序排序目的地
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                graph.putIfAbsent(from, new PriorityQueue<>());
                graph.get(from).offer(to);
            }

            // 2. 使用 Hierholzer 算法查找欧拉路径
            dfs("JFK");
            return result;
        }

        private void dfs(String airport) {
            PriorityQueue<String> destinations = graph.get(airport);
            while (destinations != null && !destinations.isEmpty()) {
                dfs(destinations.poll());
            }
            result.addFirst(airport); // 后序遍历，逆序插入头部
        }
    }
}
