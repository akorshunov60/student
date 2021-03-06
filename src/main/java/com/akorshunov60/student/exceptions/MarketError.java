package com.akorshunov60.student.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс для создания сообщений об ошибках
 */
@Data
@NoArgsConstructor
public class MarketError {

    private List<String> messages;
    private Date timestamp;

    public MarketError(String message) {
        this(List.of(message));
    }

    public MarketError(String... messages) {
        this(List.of(messages));
    }

    /**
     * Основной конструктор для создания сообщений об ошибках
     */
    public MarketError(List<String> messages) {
        this.messages = new ArrayList<>(messages);
        this.timestamp = new Date();
    }
}
