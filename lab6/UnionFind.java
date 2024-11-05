public class UnionFind {

    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < parent.length; i++){
            parent[i] = -1;
        }
    }


    private void validate(int vertex) {
        if(vertex >= parent.length || vertex < 0) {
            throw new IllegalArgumentException("not a valid index");
        }
    }

    public int sizeOf(int v1) {
        return (-1) * parent[find(v1)];

    }

    public int parent(int v1) {
        return parent[v1];
    }


    public boolean connected(int v1, int v2) {
        return find(v1)  == find(v2);
    }


    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
       if(!connected(v1,v2)) {
           if(sizeOf(v1) > sizeOf(v2)){

              parent[find(v1)] -= sizeOf(v2);
              parent[find(v2)] = v1;
           }else{
               System.out.println(sizeOf(v1));
               parent[find(v2)] -= sizeOf(v1);
               parent[find(v1)] = v2;
           }
       }
    }


    public int find(int vertex) {
        validate(vertex);
        int root = vertex;
        while(parent[root] > -1){
            root = parent(root);
        }
        while(vertex != root){
            int temp = parent[vertex];
            parent[vertex] = root;
            vertex = parent[vertex];
        }
        return root;
    }

}
