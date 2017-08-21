package com.faust.it.dao.impl;


import com.faust.it.dao.GroupDao;
import com.faust.it.entity.Group;
import com.faust.it.spring.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupService implements GroupDao {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getAll(Sort sort) {
        return groupRepository.findAll();
    }

    @Override
    public Page<Group> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return groupRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public List<Group> search(String... searchString) {
        return groupRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Group> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return groupRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Group get(long id) {
        return groupRepository.getOne(id);
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }
}
