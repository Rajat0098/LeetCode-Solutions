import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] cls : classes) {
            int a = cls[0], b = cls[1];
            double gain = ((double)(a + 1) / (b + 1)) - ((double)a / b);
            maxHeap.offer(new double[]{gain, a, b});
        }
        
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int a = (int) top[1];
            int b = (int) top[2];
            
            a++;
            b++;
            extraStudents--;
            
            gain = ((double)(a + 1) / (b + 1)) - ((double)a / b);
            maxHeap.offer(new double[]{gain, a, b});
        }
        
        double totalAverage = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int a = (int) top[1];
            int b = (int) top[2];
            totalAverage += (double)a / b;
        }
        
        return totalAverage / classes.length;
    }
}
