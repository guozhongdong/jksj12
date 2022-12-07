package com.gzd.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
 * 那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
 * 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *  
 *
 * 提示：
 *
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 *
 * 遍历一遍直接map存储，
 * 在遍历一遍，累加和
 *
 */
public class GetImportance_690 {

    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {

        int ans = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id,employee);
        }

        // 需要关注层
        int levelSize = employees.size();
        Deque<Integer> queue = new ArrayDeque<>();
        // 先找根节点，将它放到队列中
        for (int i = 0; i < levelSize ; i++) {
            if (employees.get(i).id == id){
                queue.add(id);
            }
        }
        while (!queue.isEmpty()){
            // 员工数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer zid = queue.poll();
                Employee cur = map.get(zid);
                ans += cur.importance;
                if (cur.subordinates != null && !cur.subordinates.isEmpty()){
                    queue.addAll(cur.subordinates);
                }

            }

        }
        return ans;
    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
