package cf.jrozen.ai.nqueen;

import cf.jrozen.ai.common.Solver;

class NQueenFC extends Solver {

    NQueenFC(int size) {
        super(size);
    }

    @Override
    protected void start() {
        enumerate(new boolean[size * size], new boolean[size], 0);
    }

    private void enumerate(boolean[] subBoard, boolean[] usedRows, int depth) {
        entries++;
        if (depth == size) {
            found();
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!usedRows[i] && !subBoard[i]) {
                boolean[] newSubBoard = placeQueen(subBoard, depth, i);
                usedRows[i] = true;
//                next(() -> enumerate(newSubBoard, usedRows, depth + 1));
                enumerate(newSubBoard, usedRows, depth + 1);
                usedRows[i] = false;
            }
        }
    }

    private boolean[] placeQueen(boolean[] subBoard, int depth, int row) {
        int x, y;
        boolean[] usedFields = new boolean[size * (size - depth - 1)];
        System.arraycopy(subBoard, size, usedFields, 0, (size - depth - 1) * size);

        x = -1;
        y = row;
        while (--y >= 0 && ++x < size - depth - 1) {
            usedFields[x * size + y] = true; // diagonal up
        }

        x = -1;
        y = row;
        while (++y < size && ++x < size - depth - 1) {
            usedFields[x * size + y] = true; // diagonal down
        }

        return usedFields;
    }

}
