import java.util.List;
import java.util.LinkedList;

//Unweighted directed graph
public class GraphImplementation implements Graph {
	private int vertices;
	private int[][] adjMatrix; //matrix
	public GraphImplementation(int vertices){
		this.vertices = vertices;
		adjMatrix = new int[vertices][vertices];
	}
	public void addEdge(int v1, int v2){
		//unweighted
		adjMatrix[v1][v2] = 1;
	}
	public List<Integer> topologicalSort(){
		int[] incident = new int[vertices];
		List<Integer> list = new LinkedList<>();
		for(int i=0; i<vertices; i++){ 
			for(int j=0; j <vertices;j++){
			incident[j] += adjMatrix[i][j];
			}
		}
		int[] temp;
		for(int x=0; x<vertices; x++)
			for(int y=0; y<vertices; y++)
				if(incident[y] ==0)
				{
					temp = neighbors(y);
					for(int z=0; z<temp.length; z++)
						incident[temp[z]] -= 1;
					list.add(y);
					incident[y] = -1;
				}
				return list;
	}
	public int[] neighbors(int vertex){
		int count =0;
		for(int i=0; i<vertices; i++){
			if(adjMatrix[vertex][i]>0)
				count++;
		}
		int[]neighbor = new int[count];
		int index = 0;
		for(int j=0; j<vertices;j++){
			if(adjMatrix[vertex][j]>0)
				neighbor[index++]=j;
		}
		return neighbor;

	}
}