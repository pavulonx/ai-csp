package cf.jrozen.ai.latinsquare;

import cf.jrozen.ai.common.Solver;

abstract class LatinSquareSolver extends Solver {
    int[] state;

    LatinSquareSolver(int size) {
        super(size);
        state = new int[size * size];
    }
}
