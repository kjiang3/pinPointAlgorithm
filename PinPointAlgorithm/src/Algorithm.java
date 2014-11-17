import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Created by Mike Alquist on 10/14/2014.
 */
public class parser{

   public static void checkSurroundings(HashMap<Character, Character> surroundings, char[][] room, int x, int y){

       surroundings.remove('N');
       surroundings.remove('W');
       surroundings.remove('S');
       surroundings.remove('E');
       surroundings.put('N', room[y-1][x]);
       surroundings.put('W', room[y][x-1]);
       surroundings.put('S', room[y+1][x]);
       surroundings.put('E', room[y][x+1]);

   }

    public static char checkLocation(char[][] room, int x, int y){
        return room[y][x];
    }

    public static void bestPath(char[][] room, int x, int y){

        room[y][x] = 'S';

        if (checkLocation(room, x+1, y) == ' '){
            bestPath(room, x+1, y);
            if (room[y][x+1] == 'p'){
                room[y][x] = 'p';
            }
        } else if (checkLocation(room, x+1, y) == 'c'){
            room[y][x] = 'p';
        }
        if (checkLocation(room, x, y+1) == ' '){
            bestPath(room, x, y+1);
            if (room[y+1][x] == 'p'){
                room[y][x] = 'p';
            }
        } else if (checkLocation(room, x, y+1) == 'c'){
            room[y][x] = 'p';
        }
        if (checkLocation(room, x-1, y) == ' '){
            bestPath(room, x-1, y);
            if (room[y][x-1] == 'p'){
                room[y][x] = 'p';
            }
        } else if (checkLocation(room, x-1, y) == 'c'){
            room[y][x] = 'p';
        }
        if (checkLocation(room, x, y-1) == ' '){
            bestPath(room, x, y-1);
            if (room[y-1][x] == 'p'){
                room[y][x] = 'p';
            }
        } else if (checkLocation(room, x, y-1) == 'c'){
            room[y][x] = 'p';
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(room[i][j] + "   ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

    }

   public static void main(String args[]){

      //Test different scenarios with this array
       char [][] array = new char[][]{
           { 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
           { 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
           { 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x'},
           { 'x', ' ', 'x', 'x', 'c', ' ', 'x', 'x', ' ', 'x'},
           { 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x'},
           { 'x', 's', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x'},
           { 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x'},
           { 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', ' ', 'x'},
           { 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
           { 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
       };

       int length = 10;
       int height = 10;
       int studentLocationX = 0;
       int studentLocationY = 0;
       int destinationX = 0;
       int destinationY = 0;

       for (int i = 0; i < height; i++){
           for (int j = 0; j < length; j++){
               if (array[i][j] == 's'){
                   studentLocationX = j;
                   studentLocationY = i;
               } else if (array[i][j] == 'c'){
                   destinationX = j;
                   destinationY = i;
               }
           }
       }

       bestPath(array, studentLocationX, studentLocationY);

       for (int i = 0; i < height; i++){
           for (int j = 0; j < length; j++){
               System.out.print(array[i][j] + "   ");
           }
           System.out.print("\n");
       }

   }

}
