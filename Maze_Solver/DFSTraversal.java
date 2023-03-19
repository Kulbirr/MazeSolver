import java.nio.file.Path;
import java.util.List;

public class DFSTraversal{
    public static boolean PathTraversal(int[][] Maze, int x, int y, List<Integer> path) {
        if(Maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(Maze[y][x] == 0){
           Maze[y][x] = 2;
           int dx = -1;
           int dy = 0;
           if(PathTraversal(Maze, x+dx, y+dy, path)){
               path.add(x);
               path.add(y);
               return true;
           }
           dx = 1;
           dy = 0;
           if(PathTraversal(Maze, x+dx, y+dy, path)){
               path.add(x);
               path.add(y);
               return true;
           }
           dx = 0;
           dy = -1;
           if(PathTraversal(Maze, x+dx, y+dy, path)){
               path.add(x);
               path.add(y);
               return true;
           }
           dx = 0;
           dy = 1;
           if(PathTraversal(Maze, x+dx, y+dy, path)){
               path.add(x);
               path.add(y);
               return true;
           }
        }
        return false;
    }
}
