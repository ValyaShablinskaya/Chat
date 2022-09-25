package by.it_academy.jd2.mk_jd2_92_22.taskapi.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Message {
    private LocalDateTime messageSendingDate;
    private User fromWhom;
    private User toWhom;
    private String text;
}
