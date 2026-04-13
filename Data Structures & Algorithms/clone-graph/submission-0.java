/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node[] vis = new Node[101];
        Node cloneRoot = getCloned(node, vis);
        return cloneRoot;
    }
    public Node getCloned(Node node, Node[] vis){
        if(vis[node.val]!=null){
            return vis[node.val];
        }
        Node clonedNode = new Node(node.val);
        vis[node.val] = clonedNode;
        for(Node nbr:node.neighbors){
            Node nbrs = getCloned(nbr, vis);
            clonedNode.neighbors.add(nbrs);
        }
        return clonedNode;
    }
}