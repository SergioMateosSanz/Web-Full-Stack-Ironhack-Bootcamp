package com.ironhack.EnterpriseJavaDevelopment48.service.impl.implementations;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.PostDTO;
import com.ironhack.EnterpriseJavaDevelopment48.model.Author;
import com.ironhack.EnterpriseJavaDevelopment48.model.Post;
import com.ironhack.EnterpriseJavaDevelopment48.repository.AuthorRepository;
import com.ironhack.EnterpriseJavaDevelopment48.repository.PostRepository;
import com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public PostDTO getById(int id) {

        Optional<Post> optionalPost = postRepository.findById(id);

        if (!optionalPost.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource with id " + id + " not found");
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setId(optionalPost.get().getId());
        postDTO.setTitle(optionalPost.get().getTitle());
        postDTO.setPost(optionalPost.get().getPost());
        postDTO.setAuthorName(optionalPost.get().getAuthor().getName());

        return postDTO;
    }

    @Override
    public PostDTO store(PostDTO postDTO) {

        List<Author> authorList = authorRepository.findByName(postDTO.getAuthorName());

        if ((authorList.isEmpty()) || (postDTO.getTitle() == null) || (postDTO.getPost() == null) ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource not processable");
        }

        Post postDatabase = new Post();
        postDatabase.setTitle(postDTO.getTitle());
        postDatabase.setPost(postDTO.getPost());
        postDatabase.setAuthor(authorList.get(0));
        postRepository.save(postDatabase);
        postDTO.setId(postDatabase.getId());

        return postDTO;
    }

    @Override
    public void delete(int id) {

        Post databasePost = postRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));
        postRepository.delete(databasePost);
    }

    @Override
    public void update(int id, PostDTO postDTO) {

        Post databasePost = postRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));

        if (postDTO.getAuthorName() != null){
            List<Author> authorList = authorRepository.findByName(postDTO.getAuthorName());

            if ((authorList.isEmpty()) || (postDTO.getTitle() == null) || (postDTO.getPost() == null)) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource not processable");
            }
            databasePost.setAuthor(authorList.get(0));
        }

        if (postDTO.getTitle() != null) {
            databasePost.setTitle(postDTO.getTitle());
        }
        if (postDTO.getPost() != null) {
            databasePost.setPost(postDTO.getPost());
        }
        postRepository.save(databasePost);
    }
}
