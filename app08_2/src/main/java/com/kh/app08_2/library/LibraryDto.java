package com.kh.app08_2.library;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LibraryDto {

    private Long no;

    private String title;
    private String content;
    private Long price;
    private String writer;

    private String delYn;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static LibraryDto from(LibraryEntity entity) {

        LibraryDto dto = new LibraryDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.price = entity.getPrice();
        dto.writer = entity.getWriter();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();

        dto.delYn = entity.getDelYn();

        return dto;
    }

}
