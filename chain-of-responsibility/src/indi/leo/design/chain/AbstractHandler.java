package indi.leo.design.chain;

abstract public class AbstractHandler {

    protected AbstractHandler nextHandler;

    public final AbstractHandler withNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this;
    }

    abstract public boolean canHandle(Request request);

    abstract public Object doHandle(Request request);

    public final Object handleRequest(Request request) {
        return canHandle(request) ? doHandle(request) :
                nextHandler != null ? nextHandler.handleRequest(request) : null;
    }

}
