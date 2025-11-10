package com.craftinginterpreters.lox;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    final Environment enclosing;
    final Object Undefined = new Object();
    private final Map<String, Object> values = new HashMap<>();

    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    void define(String name) {
        values.put(name, Undefined);
    }

    void define(String name, Object value) {
        values.put(name, value);
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            Object result = values.get(name.lexeme);
            if  (result == Undefined) {
                throw new RuntimeError(name,  "Accessing undefined value.");
            }
            return result;
        }

        if  (enclosing != null) return enclosing.get(name);

        throw new RuntimeError(name,  "Undefined variable '" + name.lexeme + "'.");
    }

    public void assign(Token name, Object value) {
        if  (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        if  (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name,  "Undefined variable '" + name.lexeme + "'.");
    }
}
