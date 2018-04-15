package cf.jrozen.ai.latinsquare;

import java.util.Arrays;

class LatinSquareBT extends LatinSquareSolver {

    LatinSquareBT(final int size) {
        super(size);
        Arrays.fill(state, -1);
    }

    @Override
    protected void start() {
        enumerate(0);
    }

    private void enumerate(int cell) {
        if (cell == size * size) {
            found();
            return;
        }
        for (byte i = 0; i < size; i++) {
            if (isValid(i, cell) & entries++ > -1) {
                state[cell] = i;
//                next(() -> enumerate(cell + 1));
                enumerate(cell + 1);
                state[cell] = -1;
            }
        }
    }

    private boolean isValid(int newValue, int cell) {
        int row = cell % size;
        int column = cell / size;

        for (int i = column * size; i < (column + 1) * size; i++) {
            if (state[i] == newValue) {
                return false; // check same column
            }
        }

        for (int i = row; i < size * size; i += size) {
            if (state[i] == newValue) {
                return false; // check same row
            }
        }

        return true;
    }

}
