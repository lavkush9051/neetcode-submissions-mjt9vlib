class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:prerequisites){
            indegree[i[1]]++;
            adj.get(i[0]).add(i[1]);
        }
        boolean isValid = false;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< indegree.length; i++){
            if(indegree[i]==0){
                q.add(i);
                isValid = true;
            }
        }
        if(!isValid) return new int[0];
        int processed = 0;
        int idx = numCourses-1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx] = node;
            processed++;
            idx--;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        return processed==numCourses?ans:new int[0];
    }
}
