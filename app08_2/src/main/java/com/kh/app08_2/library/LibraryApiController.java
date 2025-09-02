package com.kh.app08_2.library;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/library")
public class LibraryApiController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Long> insert(@RequestBody LibraryDto dto) {

        Long result = libraryService.insert(dto);

        if(result != 0) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }

    }

    @GetMapping
    public ResponseEntity<List<LibraryDto>> selectList() {

        List<LibraryDto> dtoList = libraryService.selectList();

        if( dtoList != null) {
            return ResponseEntity.ok().body(dtoList);
        } else {
            return ResponseEntity.badRequest().body(dtoList);
        }
    }

    @GetMapping("{no}")
    public ResponseEntity<LibraryDto> selectOne(@PathVariable Long no) {

        LibraryDto dto = libraryService.selectOne(no);

        if( dto != null) {
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.badRequest().body(dto);
        }
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody LibraryDto dto) {

        Long no = libraryService.update(dto);

        if(no != 0) {
            return ResponseEntity.ok().body(no);
        } else {
            return ResponseEntity.badRequest().body(no);
        }
    }

    @DeleteMapping("{no}")
    public ResponseEntity<Long> delete(@PathVariable Long no) {

        Long res_no = libraryService.delete(no);

        if(no != 0) {
            return ResponseEntity.ok().body(res_no);
        } else {
            return ResponseEntity.badRequest().body(res_no);
        }

    }
}
