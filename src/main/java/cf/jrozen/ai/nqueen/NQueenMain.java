package cf.jrozen.ai.nqueen;


import cf.jrozen.ai.common.Result;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static cf.jrozen.ai.common.FileUtils.printToCsv;

public class NQueenMain {
    public static void main(String[] args) {
        int range = 14;
        LinkedList<Result> results = new LinkedList<Result>();
        IntStream.range(1, range + 1).forEach(dim -> {

                    NQueenBT nQBT = new NQueenBT(dim);
                    Result resNQueenBT = nQBT.run();
                    System.out.println(resNQueenBT);
                    results.add(resNQueenBT);

                    NQueenFC nQueenFC = new NQueenFC(dim);
                    Result resNQueenFC = nQueenFC.run();
                    System.out.println(resNQueenFC);
                    results.add(resNQueenFC);
                }
        );
        printToCsv(results);
    }

}
