package com.shop.mall.services;

import com.shop.mall.entities.User;
import com.shop.mall.repositories.UserRepository;
import com.shop.mall.services.exceptions.DatabaseException;
import com.shop.mall.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        if (list.isEmpty()){
            throw new EntityNotFoundException("Users not found!");
        }
        return list;
    }

    public User findById(Long id){
         Optional<User> user = repository.findById(id);
         return user.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResouceNotFoundException(e.getMessage());
        }
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResouceNotFoundException("Resource not found!");
        }
        repository.deleteById(id);
    }

}
