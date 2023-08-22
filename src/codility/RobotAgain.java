package codility;

import java.util.LinkedList;
import java.util.Queue;

public class RobotAgain {

    int[] dx = {0, 0, 1, -1}; // Directions: right, left, down, up
    int[] dy = {1, -1, 0, 0};
    char[] moves = {'>', '<', 'v', '^'};

    public String solution(String[] room, int subtask) {
        int rows = room.length;
        int cols = room[0].length();
        char[][] map = new char[rows][cols];
        int startX = -1, startY = -1;

        for (int i = 0; i < rows; i++) {
            map[i] = room[i].toCharArray();
            if (room[i].contains("*")) {
                startX = i;
                startY = room[i].indexOf("*");
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        StringBuilder commands = new StringBuilder();

        if (subtask == 1) {
            dfsCleanSubTask1(startX, startY, rows, cols, map, visited, commands);
        } else if (subtask == 2) {
            dfsCleanSubTask2(startX, startY, rows, cols, map, visited, commands);
        } else if (subtask == 3) {
            dfsCleanSubTask3(startX, startY, rows, cols, map, visited, commands);
        }  else if (subtask == 4) {
            dfsCleanSubTask4(startX, startY, rows, cols, map, visited, commands);
        } else if (subtask == 5) {
            dfsCleanSubtask5(startX, startY, rows, cols, map, visited, commands);
        }

        return commands.toString();
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    private void dfsCleanSubTask1(int x, int y, int rows, int cols, char[][] map, boolean[][] visited, StringBuilder commands) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValid(newX, newY, rows, cols) && !visited[newX][newY] && map[newX][newY] != '#') {
                commands.append(moves[i]);
                dfsCleanSubTask1(newX, newY, rows, cols, map, visited, commands);
            }
        }
    }

    private void dfsCleanSubTask2(int x, int y, int rows, int cols, char[][] map, boolean[][] visited, StringBuilder commands) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
             x = curr[0];
             y = curr[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY, rows, cols) && !visited[newX][newY] && map[newX][newY] == '.') {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    commands.append(moves[i]);
                }
            }
        }
    }

    private void dfsCleanSubTask3(int x, int y, int rows, int cols, char[][] map, boolean[][] visited, StringBuilder commands) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // If the neighbor is within the room boundaries, and it is an empty space
            // that has not been visited yet, we clean it.
            if (isValid(newX, newY, rows, cols) && map[newX][newY] == '.' && !visited[newX][newY] && map[newX][newY] != '#') {
                commands.append(moves[i]);
                dfsCleanSubTask3(newX, newY, rows, cols, map, visited, commands);
            }
        }
    }
    private boolean isSurroundedByObstacles(int x, int y, int rows, int cols, char[][] map) {
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (!isValid(newX, newY, rows, cols) || map[newX][newY] != '#') {
                return false;
            }
        }
        return true;
    }

    private void dfsCleanSubTask4(int x, int y, int rows, int cols, char[][] map, boolean[][] visited, StringBuilder commands) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // If the neighbor is within the room boundaries, it is an empty space,
            // not surrounded by obstacles, and has not been visited yet, we clean it.
            if (isValid(newX, newY, rows, cols) && map[newX][newY] == '.' && !visited[newX][newY] && !isSurroundedByObstacles(newX, newY, rows, cols, map)) {
                commands.append(moves[i]);
                dfsCleanSubTask4(newX, newY, rows, cols, map, visited, commands);
            }
        }
    }

    private void dfsCleanSubtask5(int x, int y, int rows, int cols, char[][] map, boolean[][] visited, StringBuilder commands) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // If the neighbor is within the room boundaries and it has not been visited yet.
            if (isValid(newX, newY, rows, cols) && !visited[newX][newY]) {
                if (map[newX][newY] == '.') {
                    commands.append(moves[i]); // Clean the dirt if present.
                } else if (map[newX][newY] == '#') {
                    continue; // Skip obstacles, but keep exploring.
                }
                dfsCleanSubtask5(newX, newY, rows, cols, map, visited, commands);
            }
        }
    }

    public static void main(String[] args) {
    RobotAgain solution = new RobotAgain();

        // Example usage:
        String[] room = {
                "#######",
                "#*    #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#######"
        };
        String[] roomAg = {
                "#######",
                "#.....#",
                "#..*..#",
                "#.....#",
                "#.....#",
                "#######"
        };

       String[] room1 = {
               "#######",
               "#.....#",
               "#..*..#",
               "#.....#",
               "#.....#",
               "#######"
       };

       String[] room2 = {
               "########",
               "#.*.#..#",
               "#......#",
               "#...#..#",
               "########"
       };

       String[] room3 = {
               "########",
               "#.##...#",
               "#......#",
               "#.#..#.#",
               "#*..##.#",
               "########"
       };

       String[] room4 = {
               "########",
               "###....#",
               "###..#.#",
               "#....*.#",
               "#...##.#",
               "########"
       };
        int subtask = 2;
        String commands = solution.solution(roomAg, subtask);
        System.out.println(commands);


    }
}
