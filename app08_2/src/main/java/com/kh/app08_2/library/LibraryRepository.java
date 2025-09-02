package com.kh.app08_2.library;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LibraryRepository {

    private final EntityManager em;
    public void insert(LibraryEntity entity) {
        em.persist(entity);
    }

    public List<LibraryEntity> selectList() {
        String jpql = "SELECT l From LibraryEntity l WHERE l.delYn = 'N' ORDER BY l.no";
        return em.createQuery(jpql, LibraryEntity.class)
                .getResultList();
    }

    public LibraryEntity selectOne(Long no) {
        return em.find(LibraryEntity.class, no);
    }

}
