public class Main{
    public static void main(String[] args){
        long start = System.nanoTime();    
        int[][] gridInput = {

            {0,0,3,5,8,0,0,9,6},
            {0,6,0,3,2,9,8,0,0},
            {9,0,8,4,6,0,0,0,3},
            {8,1,2,0,0,3,0,0,9},
            {0,0,9,0,0,2,0,8,0},
            {0,7,0,1,9,8,0,3,2},
            {0,8,0,9,0,5,7,0,4},
            {4,9,5,2,7,6,3,1,8},
            {0,0,0,8,0,4,9,0,5},

        };
        
        Sudoku sudoku = new Sudoku(gridInput);
        System.out.println("Sudoku grid to solve: \n");
        sudoku.showGrid();

        if(sudoku.BT()) {
            System.out.println("\nSudoku Grid solved with BT-Algorithm\n");
            sudoku.showGrid();
        }

        else {
            System.out.println("Couldn't solve \n");
        }

        long end = System.nanoTime() - start;
        double totalTimeInSeconds = (double) end / 1_000_000_000;
        System.out.print("\n" + totalTimeInSeconds + " s");
    }
}