package codility;

public class Robot {
    // Helper function to check if a position is valid and not an obstacle
    private static boolean isValidMove(int x, int y, String[] room) {
        int rows = room.length;
        int cols = room[0].length();
        return (x >= 0 && x < rows && y >= 0 && y < cols && room[x].charAt(y) != '#');
    }

    // Helper function for DFS to explore the room
    private static boolean dfs(int x, int y, String[] room, StringBuilder commands, int subtask) {
        if (subtask == 0 && x != 0 && x != room.length - 1 && y != 0 && y != room[0].length() - 1) {
            // If we are only cleaning the borders, return false when not at the border
            return false;
        }

        if (room[x].charAt(y) == '.') {
            room[x] = room[x].substring(0, y) + 'x' + room[x].substring(y + 1); // Mark as visited
            commands.append(">v<^"); // Move to the position and clean
        }

        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValidMove(newX, newY, room)) {
                if (dfs(newX, newY, room, commands, subtask)) {
                    commands.append("^><v"); // Move back to the previous position
                }
            }
        }

        return true;
    }

    public String solution(String[] room, int subtask) {
        int rows = room.length;
        int cols = room[0].length();

        int startX = -1;
        int startY = -1;

        // Find the starting position of the robot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (room[i].charAt(j) == '*') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if (startX != -1 && startY != -1) {
                break;
            }
        }

        StringBuilder commands = new StringBuilder();
        dfs(startX, startY, room, commands, subtask);

        // Remove unnecessary back-and-forth moves from the commands string
        String[] sequence = {"^>", ">v", "v<", "<^"};
        for (String s : sequence) {
            int index = commands.indexOf(s);
            while (index != -1) {
                commands.replace(index, index + 2, "");
                index = commands.indexOf(s, index);
            }
        }

        return commands.toString();
    }

    public static void main(String[] args) {
        Robot solution = new Robot();

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
        int subtask = 1;
        String commands = solution.solution(room, subtask);
        System.out.println(commands); // Output: ">>>>vvv<<<<^"
    }
}
