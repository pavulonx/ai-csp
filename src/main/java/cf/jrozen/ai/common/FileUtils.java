package cf.jrozen.ai.common;

import java.io.PrintWriter;
import java.util.List;

public class FileUtils {

    public static void printToCsv(List<Result> res) {
        res.sort(Result::compareTo);
        final var callerName = Thread.currentThread().getStackTrace()[2].getClassName().split("\\.")[3];
        try (PrintWriter writer = new PrintWriter("/home/rozen/airesults/" + callerName + "_results" + ".csv", "UTF-8")) {
            writer.println(Result.csvHeader());
            res.stream().map(Result::toCsvRow).forEach(writer::println);
        } catch (Exception ignored) {
        }
    }
}
