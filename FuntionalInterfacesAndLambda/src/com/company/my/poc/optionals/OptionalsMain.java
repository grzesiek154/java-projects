package com.company.my.poc.optionals;

import java.util.Optional;

public class OptionalsMain {

    public static void main(String[] args) {

        Object value = Optional.ofNullable("Hello")
                .orElseGet(()-> "default value");
        Object value2 = Optional.ofNullable("Hello")
                .orElseGet(()-> "default value");
        Optional.ofNullable(null)
                .ifPresent(email -> System.out.println("sending ,message to " + email));
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("sending ,message to " + email),
                        () -> {
                            System.out.println("cannot send email");
                        });

        System.out.println(value);
    }

}
