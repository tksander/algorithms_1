public class QuickUnionUF
{
    private int[] id;
    
    // intialize id of each object to itself
    public QuickUnionUF(int N)
    {
       
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }
    
    // chases parent pointers until reaches root
    private int root(int i)
    {
        while (i != id[i]) i = id[i];
        return i;
    }
    
    // check if p and q have same root
    public boolean connected(int p, int q)
    {
        return root(p) == root (q);
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
