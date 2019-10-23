package indi.leo.design.chain;

import java.util.Random;

public class AHandler extends AbstractHandler {

    private Random random = new Random();

    @Override
    public boolean canHandle(Request request) {
        return random.nextBoolean();
    }

    @Override
    public Object doHandle(Request request) {
        return "this is AHandler";
    }
}
