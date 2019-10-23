package indi.leo.design.tabledriven;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class App {

    public static void main(String[] args) {

    }

    //before refactoring
    public static String beforeRefactoring(String key, String params) {
        if ("a".equals(key)) {
            return "this is a and this is " + params;
        }else if ("b".equals(key)) {
            return "this is b and this is " + params;
        }else if ("c".equals(key)) {
            return "this is c and this is " + params;
        }
        throw new RuntimeException("invalid key:" + key);
    }

    //after refactoring
    static Map<String, Function<String, String>> actionMapping = new HashMap<>();
    static {
        actionMapping.put("a", param -> "this is a and this is " + param);
        actionMapping.put("b", param -> "this is b and this is " + param);
        actionMapping.put("c", param -> "this is c and this is " + param);
    }

    public static String afterRefactoring(String key, String params) {
        return Optional.ofNullable(actionMapping.get(key))
                .map(action -> action.apply(params))
                .orElseThrow(() -> new RuntimeException("invalid key:" + key));
    }
}
