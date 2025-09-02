package com.kh.app08_2.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name ="LIBRARY")
@Getter
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private String content;
    private Long price;
    private String writer;

    private String delYn;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public LibraryEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    public static LibraryEntity from(LibraryDto dto) {

        LibraryEntity entity = new LibraryEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.price = dto.getPrice();
        entity.writer = dto.getWriter();

        return entity;
    }

    public void update(LibraryDto dto) {
        title = dto.getTitle();
        content = dto.getContent();
        writer = dto.getWriter();

        updatedAt = LocalDateTime.now();
    }

    public void delete() {
        delYn = "Y";
    }
}
