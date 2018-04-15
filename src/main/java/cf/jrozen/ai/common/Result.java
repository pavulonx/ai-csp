package cf.jrozen.ai.common;

import java.util.Comparator;

public class Result implements Comparable<Result> {
    private final long execTimeNanos;
    private final long firstFoundNanos;
    private final int dim;
    private final long solutions;
    private final long entries;
    private final String problemName;

    Result(long execTimeNanos, long firstFoundNanos, int dim, long solutions, long entries, String problemName) {
        this.execTimeNanos = execTimeNanos;
        this.firstFoundNanos = firstFoundNanos;
        this.dim = dim;
        this.solutions = solutions;
        this.entries = entries;
        this.problemName = problemName;
    }

    @Override
    public String toString() {
        return String.format("%s: {\n" +
                        "\tExecution time: [%d ms (%d ns)]\n" +
                        "\tFirst solution found after time: [%d ms (%d ns)]\n" +
                        "\tProblem dimension: [%d]\n" +
                        "\tSolutions found: [%d]\n" +
                        "\tEntries: [%d]\n" +
                        "}\n",
                problemName,
                execTimeNanos / 1_000_000, execTimeNanos,
                firstFoundNanos / 1_000_000, firstFoundNanos,
                dim, solutions, entries
        );
    }

    public String toCsvRow() {
        return String.format("%s,%d,%d,%d,%d,%d", problemName, dim, execTimeNanos, firstFoundNanos, solutions, entries);
    }

    public static String csvHeader() {
        return "name,dim,exec_time_nanos,first_found_time_nanos,solutions,entries";
    }

    @Override
    public int compareTo(Result that) {
        return Comparator.comparing(Result::problemName).thenComparing(Result::dim).compare(this, that);
    }

    private int dim() {
        return dim;
    }

    private String problemName() {
        return problemName;
    }
}
