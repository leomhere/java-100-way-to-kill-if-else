package indi.leo.design.chain;

public class App {

    public static void main(String[] args) {
        AbstractHandler handler = new AHandler()
                .withNextHandler(
                        new BHandler()
                                .withNextHandler(new CHandler())
                );
        System.out.println(handler.handleRequest(new Request()));
    }
}
