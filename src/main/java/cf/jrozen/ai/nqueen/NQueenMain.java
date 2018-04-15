package cf.jrozen.ai.nqueen;


import cf.jrozen.ai.common.Result;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static cf.jrozen.ai.common.FileUtils.printToCsv;

public class NQueenMain {
    public static void main(String[] args) {
        var range = 14;
        var results = new LinkedList<Result>();
        IntStream.range(1, range + 1).forEach(dim -> {

                    var nQBT = new NQueenBT(dim);
                    var resNQueenBT = nQBT.run();
                    System.out.println(resNQueenBT);
                    results.add(resNQueenBT);

                    var nQueenFC = new NQueenFC(dim);
                    var resNQueenFC = nQueenFC.run();
                    System.out.println(resNQueenFC);
                    results.add(resNQueenFC);
                }
        );
        printToCsv(results);
    }

}
