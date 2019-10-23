package indi.leo.design.chain;

public class App {

    public static void main(String[] args) {
        //before refactoring
        AHandler aHandler = new AHandler();
        BHandler bHandler = new BHandler();
        CHandler cHandler = new CHandler();
        Request request = new Request();
        if (aHandler.canHandle(request)) {
            System.out.println(aHandler.doHandle(request));
        }else if (bHandler.canHandle(request)) {
            System.out.println(bHandler.doHandle(request));
        }else if (cHandler.canHandle(request)) {
            System.out.println(cHandler.doHandle(request));
        }
        //after refactoring
        AbstractHandler handler = new AHandler()
                .withNextHandler(
                        new BHandler()
                                .withNextHandler(new CHandler())
                );
        System.out.println(handler.handleRequest(request));
    }
}
