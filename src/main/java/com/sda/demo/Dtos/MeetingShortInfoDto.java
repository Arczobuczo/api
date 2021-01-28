package com.sda.demo.Dtos;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MeetingShortInfoDto {

    private final Long id;

    private final String title;

    private final LocalDateTime sinceDate;

    private final LocalDateTime toDate;

    private final String body;

    public MeetingShortInfoDto(Long id, String title, LocalDateTime sinceDate, LocalDateTime toDate, String body) {
        this.id = id;
        this.title = title;
        this.sinceDate = sinceDate;
        this.toDate = toDate;
        this.body = body;
    }

    @Override
    public String toString() {
        return "MeetingShortInfoDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sinceDate=" + sinceDate +
                ", toDate=" + toDate +
                ", body='" + body + '\'' +
                '}';
    }
}
