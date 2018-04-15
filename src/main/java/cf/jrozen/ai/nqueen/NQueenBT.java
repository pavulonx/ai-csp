package cf.jrozen.ai.nqueen;

import cf.jrozen.ai.common.Solver;

class NQueenBT extends Solver {

    NQueenBT(int size) {
        super(size);
    }

    @Override
    protected void start() {
        enumerate(new int[size], 0);
    }

    private void enumerate(int[] board, int row) {
        entries++;
        if (row == size) {
            found();
            return;
        }
        for (int qPosInRow = 0; qPosInRow < size; qPosInRow++) {
            board[row] = qPosInRow;
            if (isConsistent(board, row))
//                next(() -> enumerate(board, row + 1));
                enumerate(board, row + 1);
        }
    }

    private boolean isConsistent(int[] board, int n) {
        boolean res = true;
        for (int i = 0; i < n && res; i++)
            res = board[i] != board[n] && (board[i] - board[n]) != (n - i) && (board[n] - board[i]) != (n - i);
        return res;
    }

}
