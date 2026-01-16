class Solution {
    int mod = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;

        for(int i = 0; i < hFences.length; i++){
            h[i+1] = hFences[i];
        }

        for(int i = 0; i < vFences.length; i++){
            v[i+1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < h.length; i++){
            for(int j=i+1; j<h.length;j++){
                set.add(h[j] - h[i]);
            }
        }

        int maxSide = 0;
        for(int i = 0; i < v.length; i++){
            for(int j=i+1; j<v.length;j++){
                int gap = v[j]-v[i];
                if(set.contains(gap)){
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if(maxSide == 0){
            return -1;
        }
        long area = (1L*maxSide*maxSide) % mod;
        return (int)area;
    }
}