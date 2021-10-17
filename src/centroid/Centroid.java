/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Abhinav Vijayvargiya
 */
public class Centroid {
    static ArrayList<Integer> adj[];
    static int subtree[];

    public Centroid(int v) {
        adj=new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        subtree=new int[v];
    }
    static void dfs(int node,int parent)
    {
        subtree[node]=1;
        int ans=0;
        //System.out.println(node+" "+parent);
        for(int i=0;i<adj[node].size();i++)
        {
            if(adj[node].get(i)!=parent)
            {
                dfs(adj[node].get(i),node);
                subtree[node]=subtree[node]+subtree[adj[node].get(i)];
               
            }
        }
          
    }
    
    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        int t=fs.nextInt();
        while(t-->0)
        {
            int n=fs.nextInt();
            Centroid g=new Centroid(n);
            for(int i=0;i<n-1;i++)
            {
                int a=fs.nextInt();
                int b=fs.nextInt();
                a--;
                b--;
                adj[a].add(b);
                adj[b].add(a);
            }
           
            for(int i=0;i<n;i++)
            {
                System.out.println(adj[i]+" ");
            }
            dfs(0,-1);
            for(int i=0;i<n;i++)
            {
                System.out.print(subtree[i]+" ");
            }
            System.out.println("");
            
        }
    }
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
                
		public String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
			
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}

    
}
