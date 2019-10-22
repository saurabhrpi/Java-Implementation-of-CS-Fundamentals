import java.lang.*;
import java.util.*;

public class BinaryRep{
    public void toBin(int num, StringBuilder sb)
      {
          if(num == 0 || num == 1)
          {
              sb.append(num);
              return;
          }
          toBin(num/2, sb);
          sb.append(num % 2);
      }
 }
