package cf.jrozen.ai.latinsquare;

import java.util.concurrent.atomic.AtomicBoolean;

class LatinSquareFC extends LatinSquareSolver {

    private final AtomicBoolean[] usedRowValues;
    private final AtomicBoolean[] usedColumnValues;

    LatinSquareFC(int size) {
        super(size);
        this.usedColumnValues = new AtomicBoolean[size * size];
        this.usedRowValues = new AtomicBoolean[size * size];
        for (int i = 0; i < size * size; i++) {
            usedRowValues[i] = new AtomicBoolean(false);
            usedColumnValues[i] = new AtomicBoolean(false);
        }
    }

    @Override
    protected void start() {
        enumerate(0);
//        enumerate(size*size/2);
    }

    private void enumerate(int cell) {
        entries++;
        if (cell == size * size) {
            found();
            return;
        }
        for (int i = 0; i < size; i++) {
            AtomicBoolean isColumnReserved = getColumn(cell, i);
            AtomicBoolean  isRowReserved = getRow(cell, i);
            if (!isColumnReserved.get() && !isRowReserved.get()) {
                isColumnReserved.set(true);
                isRowReserved.set(true);

                state[cell] = i;
//                next(() -> enumerate(cell + 1));
//                next(() -> enumerate((cell + 1) % (size * size)));
                enumerate(cell + 1);

                isColumnReserved.set(false);
                isRowReserved.set(false);
            }
        }
    }

    private AtomicBoolean getColumn(int cell, int val) {
        return usedColumnValues[(cell / size) * size + val];
    }

    private AtomicBoolean getRow(int cell, int val) {
        return usedRowValues[(cell % size) * size + val];
    }

}
