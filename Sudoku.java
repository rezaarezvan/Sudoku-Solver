public class Sudoku {
    private static final int EMPTY = 0;
    private static final int SIZE = 9;
    private int[][] grid = new int[SIZE][SIZE];

    public Sudoku(int[][] grid) {
        copy(this.grid, grid);
    }

    private void copy(int[][] grid1, int[][] grid2){
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                grid1[i][j] = grid2[i][j];
            }
        }
    }

    private boolean isInRow(int row, int target) {
        for(int i = 0; i < SIZE; i++) {
            if(grid[row][i] == target) {
                return true;
            }
        }
        return false;        
    }

    private boolean isInCol(int col, int target) {
        for(int i = 0; i < SIZE; i++) {
            if(grid[i][col] == target) {
                return true;
            }
        }
        return false;        
    }

    private boolean isInBox(int row, int col, int target) {
        int r = row - (row % 3);
        int c = col - (col % 3);

        for(int i = r; i < (r + 3); i++) {
            for(int j = c; j < (c + 3); j++) {
                if(grid[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOk(int row, int col, int target) {
        return !isInRow(row, target) && !isInCol(col, target) && !isInBox(row, col, target);
    }

    public boolean BT() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) { 
                if(grid[row][col] == EMPTY) {
                    for(int target = 1; target <= SIZE; target++) {
                        if(isOk(row, col, target)) {
                            grid[row][col] = target;
                            if(BT()) { return true; } 
                            else { grid[row][col] = EMPTY; }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void showGrid() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
    }

}
