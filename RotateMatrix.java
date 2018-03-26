public class rotateMatrix{
    //array NxN
    public boolean rotate(int[][] matrix)
    {
      int layer;
      int first;
      int offset;
      int swap;
      int n = matrix.length;
      for(layer=0; i < n/2 ; layer++)
      {
          first = layer;
          last = n - layer - 1; //index position
          for(i = first; i < last; i++)
          {
                offset = i - first;
                swap = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first]; // top <- left 
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset]= matrix[i][last];
                matrix[i][last] = swap; // right <- top
          }
      }
    }
}
