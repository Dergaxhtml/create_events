package com.sda.party.service;

import com.sda.party.model.Comment;
import com.sda.party.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
