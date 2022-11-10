package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("Permission")
                .accessBy("rule_1")
                .accessBy("rule_2")
                .accessBy("rule_3")
                .build();
        System.out.println(permission);
    }
}
