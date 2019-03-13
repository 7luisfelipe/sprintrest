package br.com.lf.sprint.util;

public enum Messages {
    USER_NOT_FOUND_PT("Usuário não encontrado"),
    USER_NOT_FOUND_EN("User not found");

    private final String message;

    Messages(String option) {
        this.message = option;
    }

    public String getMessage() {
        return message;
    }
}
