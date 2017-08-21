package com.faust.it.dao.impl;


import com.faust.it.dao.UserDao;
import com.faust.it.entity.User;
import com.faust.it.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAll(Sort sort) {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return userRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public List<User> search(String... searchString) {
        return userRepository.findByNickNameContainingIgnoreCaseOrderByNickName(searchString[0]);
    }

    @Override
    public Page<User> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return userRepository.findByNickNameContainingIgnoreCaseOrderByNickName(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public User get(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
