package com.example.springauthorsproject.repository;

import com.example.springauthorsproject.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {
    List<Work> findByAuthorId(Long authorId);
}
