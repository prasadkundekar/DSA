class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            uf.union(a, b, values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            result[i] = uf.isConnected(x, y);
        }
        return result;
    }
}


class UnionFind {
    private Map<String, String> parent = new HashMap<>();
    private Map<String, Double> weight = new HashMap<>(); 


    public String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            weight.put(x, 1.0);
            return x;
        }
        if (!x.equals(parent.get(x))) {
            String origParent = parent.get(x);
            String root = find(origParent);
            parent.put(x, root);
            weight.put(x, weight.get(x) * weight.get(origParent)); 
        }
        return parent.get(x);
    }

    public void union(String a, String b, double val) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
            weight.put(rootA, val * weight.get(b) / weight.get(a));
        }
    }

    public double isConnected(String a, String b) {
        if (!parent.containsKey(a) || !parent.containsKey(b)) return -1.0;
        String rootA = find(a);
        String rootB = find(b);
        if (!rootA.equals(rootB)) return -1.0;
        return weight.get(a) / weight.get(b);
    }
}