package com.sda.party.repository;

import com.sda.party.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByEventIdOrderByDateDesc(int eventId);
}
