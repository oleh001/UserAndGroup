package com.faust.it.spring.repository;

import com.faust.it.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    //findBy (Group.name) - IgnoreCase - OrderBy
    List<Group> findByNameContainingIgnoreCaseOrderByName(String name);

    Page<Group> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

}