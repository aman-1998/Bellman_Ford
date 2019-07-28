import java.util.*;
import java.lang.*;

class bel
{
	int bellman_ford(int[][] cost,int n,int s)
	{
		int i,j,k;
		int[] dis=new int[n+1];
		for(i=1;i<=n;i++)
			dis[i]=999;
		dis[s]=0;
		for(i=1;i<=n-1;i++)
		{
			for(j=1;j<=n;j++)
			{
				for(k=1;k<=n;k++)
				{
					if(cost[j][k]!=0 && cost[j][k]!=999)
					{
						if(dis[j]+cost[j][k]<dis[k])
							dis[k]=dis[j]+cost[j][k];
					}
				}
			}
		}
		for(j=1;j<=n;j++)
		{
			for(k=1;k<=n;k++)
			{
				if(cost[j][k]!=0 && cost[j][k]!=999)
				{
					if(dis[j]+cost[j][k]<dis[k])
						return 0;
				}
			}
		}
		for(i=1;i<=n;i++)
			System.out.println("The shortest distance from "+s+" to "+i+" is "+dis[i]);
		return 1;
	}
	public static void main(String args[])
	{
		int i,j;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of vertices: ");
		int n=in.nextInt();
		int[][] cost=new int[n+1][n+1];
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print("Enter cost["+i+"]["+j+"] : ");
				cost[i][j]=in.nextInt();
			}
		}
		System.out.print("Directed weight Matrix: \n");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(cost[i][j]==999)
					System.out.print((char)8734+" ");
				else
					System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("Enter the source vertex: ");
		int s=in.nextInt();
		bel x=new bel();
		int check=x.bellman_ford(cost,n,s);
		if(check==0)
			System.out.println("\nThe graph has negative weight cycle");
	}
}