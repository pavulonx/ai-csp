package cf.jrozen.ai.common;

public abstract class Solver {
    protected final int size;
    protected long entries = 0;
    private long solutions = 0;
    private Long firstFoundNanos = null;
    private boolean fndFirst = true;

    protected Solver(int size) {
        this.size = size;

    }

    protected abstract void start();

    protected void next(Runnable r){
        if (!fndFirst && firstFoundNanos != null)
            r.run();
    }

    public Result run() {
        var start = System.nanoTime();
        start();
        var end = System.nanoTime();
        if (firstFoundNanos == null)
            firstFoundNanos = end;
        return new Result(end - start,  firstFoundNanos - start, size, solutions, entries, getClass().getSimpleName());
    }

    protected void found() {
        solutions++;
        if (firstFoundNanos == null) {
            firstFoundNanos = System.nanoTime();
        }
    }
}
