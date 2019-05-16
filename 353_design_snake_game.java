class SnakeGame {

    Queue<Position> snamePosition;
    Position currentHead;

    int w;
    int h;
    int[][] f;
    int index = 0;

    class Position {
        int x;
        int y;

        Position(int row, int col) {
            x = row;
            y = col;
        }

        // 'Object' to override the contains function
        public boolean equals(Object p) {
            Position position = (Position)p;
            return position.x == x && position.y == y;
        }
    }


    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snamePosition = new LinkedList<>();
        currentHead = new Position(0,0);
        snamePosition.offer(new Position(0,0));
        w = width;
        h = height;
        f = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction) {
            case "U":
                currentHead.x -= 1;
                if (currentHead.x < 0) {
                    return -1;
                }
                break;
            case "L":
                currentHead.y -= 1;
                if (currentHead.y < 0) {
                    return -1;
                }
                break;
            case "R":
                currentHead.y += 1;
                if (currentHead.y >= w) {
                    return -1;
                }
                break;
            case "D":
                currentHead.x += 1;
                if (currentHead.x >= h) {
                    return -1;
                }
                break;
        }
        return moveForward();
    }

    private int moveForward() {
        Position newHead = new Position(currentHead[0], currentHead[1]);
        if (index < f.length && f[index][0] == currentHead.x && f[index][1] == currentHead.y) {
            if (snamePosition.contains(newHead)) {
                return -1;
            }
            index++;
        } else {
            snamePosition.poll();
            if (snamePosition.contains(newHead)) {
                return -1;
            }
        }
        snamePosition.offer(newHead);
        return snamePosition.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
