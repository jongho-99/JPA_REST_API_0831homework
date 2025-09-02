package com.kh.app08_2.library;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public Long insert(LibraryDto dto) {

        LibraryEntity entity = LibraryEntity.from(dto);

        libraryRepository.insert(entity);

        return entity.getNo();
    }

    public List<LibraryDto> selectList() {
        List<LibraryEntity> entityList =  libraryRepository.selectList();

        return entityList.stream().map(LibraryDto::from).toList();
    }

    public LibraryDto selectOne(Long no) {
        LibraryEntity entity = libraryRepository.selectOne(no);
        if(entity.getDelYn() == "Y") {
            throw new IllegalStateException();
        }
        return LibraryDto.from(entity);
    }

    public Long update(LibraryDto dto) {

        LibraryEntity entity = libraryRepository.selectOne(dto.getNo());
        entity.update(dto);

        return entity.getNo();
    }

    public Long delete(Long no) {

        LibraryEntity entity = libraryRepository.selectOne(no);
        entity.delete();

        return entity.getNo();
    }
}
