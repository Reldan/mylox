package com.craftinginterpreters.lox;

class RuntimeError extends RuntimeException {
    final Token token;

    RuntimeError(Token token, String message) {
        super(message);
        this.token = token;
    }
}

class BreakException extends RuntimeError {
    BreakException(Token token) {
        super(token, "Break outside of a loop.");
    }
}
