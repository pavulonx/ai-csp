package cf.jrozen.ai.latinsquare;

import cf.jrozen.ai.common.Result;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static cf.jrozen.ai.common.FileUtils.printToCsv;

public class LatinSquareMain {
    public static void main(String[] args) {
        int range = 5;
        LinkedList<Result> results = new LinkedList<Result>();
        IntStream.range(1, range + 1).forEach(dim -> {

                    LatinSquareBT nLatinBT = new LatinSquareBT(dim);
                    Result resLatinBT = nLatinBT.run();
                    System.out.println(resLatinBT);
                    results.add(resLatinBT);

                    LatinSquareFC nLatinFC = new LatinSquareFC(dim);
                    Result resLatinFC = nLatinFC.run();
                    System.out.println(resLatinFC);
                    results.add(resLatinFC);
                }
        );
        printToCsv(results);
    }
}
