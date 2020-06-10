package equationsPossible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 */
public class EquationsPossible {
    public static void main(String[] args) {
        String[] equations = {"f==d", "b!=e", "d!=c", "b==c", "b!=a", "b!=f"};
        System.out.println(solution(equations));

    }

    private static boolean solution(String[] equations) {

        Map<Character, Integer> maps = new HashMap<>();
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            char signal = equation.charAt(1);
            if (a == b && signal == '!') {
                return false;
            }
            if (!maps.containsKey(a)) {
                if (signal == '=') {
                    if (!maps.containsKey(b)) {
                        int num = (int) (Math.random() * 1000) % 50;
                        maps.put(a, num);
                        maps.put(b, num);
                    } else maps.put(a, maps.get(b));
                } else {
                    if (!maps.containsKey(b)) {
                        int num1 = (int) (Math.random() * 1000) % 50;
                        int num2 = num1 + 1 + (int) (Math.random() * 1000) % 20;
                        maps.put(a, num1);
                        maps.put(b, num2);
                    } else maps.put(a, maps.get(b) + 1 + (int) (Math.random() * 1000) % 20);
                }
            } else {
                if (signal == '=') {
                    int B = maps.get(a);
                    if (maps.containsKey(b) && B != maps.get(b)) {
                        return false;
                    } else if (!maps.containsKey(b)) {
                        maps.put(b, B);
                    }
                } else {
                    int B = maps.get(a) + 1 + (int) (Math.random() * 1000) % 20;
                    if (maps.containsKey(b) && maps.get(a) == maps.get(b)) {
                        return false;
                    } else if (!maps.containsKey(b)) {
                        maps.put(b, B);
                    }
                }
            }


        }

        return true;
    }

    private boolean officialSolution(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations){
            if(str.charAt(1) == '='){
                int index1 = str.charAt(0)-'a';
                int index2 = str.charAt(3)-'a';
                union(parent,index1,index2);
            }
        }

        for (String str:equations){
            if(str.charAt(1) == '!'){
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent,index1) == find(parent,index2)){
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * 并查集-合并
     *
     * @param parent
     * @param index1
     * @param index2
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 并查集-查找-路径压缩
     *
     * @param parent
     * @param index
     * @return
     */
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
