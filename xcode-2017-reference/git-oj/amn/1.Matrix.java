// Rotate Image 
// clockwise by 90 degrees
1. reverse up to down AND swap the symmetry

// clockwise by 180 degrees
1. reverse up to down AND reverse left to right
2. reverse left to right AND reverse up to down

// clockwise by 270 degrees
1. reverse left to right AND swap the symmetry


// clockwise by 90 degrees
public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
        return;
    }
    
    int r = matrix.length;
    int c = matrix[0].length;
    
    // reverse up to down - one linear loop
    for (int first = 0, last = r - 1; first < last; first++, last--) {
        int[] temp = matrix[first];
        matrix[first] = matrix[last];
        matrix[last] = temp;
    } 
    // reverse left to right - double for loops

    // swap the symmetry - diagonal
    for (int i = 0; i < r; i++) {
        for (int j = i + 1; j < c; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}