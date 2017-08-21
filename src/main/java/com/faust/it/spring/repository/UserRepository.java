package com.faust.it.spring.repository;


import com.faust.it.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //findBy (User.NickName) - IgnoreCase - OrderBy
    List<User> findByNickNameContainingIgnoreCaseOrderByNickName(String nickName);

    Page<User> findByNickNameContainingIgnoreCaseOrderByNickName(String nickName, Pageable pageable);

}