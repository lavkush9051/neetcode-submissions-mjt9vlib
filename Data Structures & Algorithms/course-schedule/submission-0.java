class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pre: prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
    
        int processed = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            processed++;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        return processed == numCourses;
    }
}
