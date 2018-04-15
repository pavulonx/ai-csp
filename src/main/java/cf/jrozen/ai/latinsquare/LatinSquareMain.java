package cf.jrozen.ai.latinsquare;

import cf.jrozen.ai.common.Result;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static cf.jrozen.ai.common.FileUtils.printToCsv;

public class LatinSquareMain {
    public static void main(String[] args) {
        var range = 500;
        var results = new LinkedList<Result>();
        IntStream.range(1, range + 1).forEach(dim -> {

                    var nLatinBT = new LatinSquareBT(dim);
                    var resLatinBT = nLatinBT.run();
                    System.out.println(resLatinBT);
                    results.add(resLatinBT);

                    var nLatinFC = new LatinSquareFC(dim);
                    var resLatinFC = nLatinFC.run();
                    System.out.println(resLatinFC);
                    results.add(resLatinFC);
                }
        );
        printToCsv(results);
    }
}
