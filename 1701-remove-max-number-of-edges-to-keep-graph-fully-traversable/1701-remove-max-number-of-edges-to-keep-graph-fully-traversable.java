class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
      int answer=0;
      DSU Alice=new DSU(n);
      DSU Bob=new DSU(n);
      for(int[]edge:edges){
        int type=edge[0];
        int u=edge[1];
        int v=edge[2];
        if(type==3){
            if(Alice.find_ulp(u)!=Alice.find_ulp(v)||Bob.find_ulp(u)!=Bob.find_ulp(v)){
                Alice.merge(u,v);
                Bob.merge(u,v);
            }else{
                answer++;
            }
        }
    }
    for(int[]edge:edges){
        int type=edge[0];
        int u=edge[1];
        int v=edge[2];
        if(type==2){
            if(Bob.find_ulp(u)!=Bob.find_ulp(v)){
                Bob.merge(u,v);
            }else{
                answer++;
            }
        }else if(type==1){
             if(Alice.find_ulp(u)!=Alice.find_ulp(v)){
                Alice.merge(u,v);
            }else{
                answer++;
            }
        }
      }
      int ulp=Alice.find_ulp(1);
      for(int i=1;i<n+1;i++){
        if(Alice.find_ulp(i)!=ulp){
            return -1;
        }
      }
        ulp=Bob.find_ulp(1);
      for(int i=1;i<n+1;i++){
        if(Bob.find_ulp(i)!=ulp){
            return -1;
        }
      }
        return answer;
    }
}
class DSU{
private int[]parent;
private int[]size;
    public DSU(int n) {
       parent= new int[n+1];
       size= new int[n+1];
        for (int i = 0; i <= n; i++) {
           parent[i]=i;
           size[i]=1;
        }
    }
    public int find_ulp(int u){
        if(u==parent[u])
        return u;
        return parent[u]=find_ulp(parent[u]);
    }
    public void merge(int u,int v){
        int parentu=find_ulp(u);
        int parentv=find_ulp(v);
        if(parentu==parentv){
            return;
        }
        if(size[parentu]>size[parentv]){
            parent[parentv]=parentu;
            size[parentu]+=size[parentv];
        }else {
            parent[parentu]=parentv;
            size[parentv]+=size[parentu];
        }

        


    }
}