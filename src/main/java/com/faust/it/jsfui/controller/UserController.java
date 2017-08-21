package com.faust.it.jsfui.controller;

import com.faust.it.dao.UserDao;
import com.faust.it.entity.Group;
import com.faust.it.entity.User;
import com.faust.it.jsfui.enums.SearchType;
import com.faust.it.jsfui.model.LazyDataTable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
@Component
@Getter
@Setter
@Log
public class UserController extends AbstractController<User> {

    public static final String USER_SEARCH_COLUMN = "nickName";

    //Default count page size
    public static final int DEFAULT_PAGE_SIZE = 10;

    //For DataTabel
    private int rowsCount = DEFAULT_PAGE_SIZE;

    //Latest search
    private SearchType searchType;

    @Autowired
    private UserDao userDao;

    //Activity group
    private User selectedUser = new User();

    //Pair FSF
    private LazyDataTable<User> lazyModel;

    private Page<User> userPages;

    //Input serch text
    private String searchUserName;
    private String searchGroupName;

    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable(this);
    }

    //    @Transactional
    public void save() {
        userDao.save(selectedUser);
        selectedUser = new User();
    }

    @Override
    public Page<User> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        if (sortField == null) {
            sortField = USER_SEARCH_COLUMN;
        }

        if (searchType == null) {
            userPages = userDao.getAll(pageNumber, pageSize, sortField, sortDirection);
        } else {

            switch (searchType) {
                case SEARCH_USER_NAME:
                    userPages = userDao.search(pageNumber, pageSize, sortField, sortDirection, searchUserName);
                    break;
                case ALL:
                    userPages = userDao.getAll(pageNumber, pageSize, sortField, sortDirection);
                    break;
            }
        }
        return userPages;
    }

    @Override
    public void addAction() {
        selectedUser = new User();
    }

    @Override
    public void editAction() {
    }

    @Override
    public void deleteAction() {
        userDao.delete(selectedUser);
    }

    public List<User> getAll() {
        return userDao.getAll(new Sort(Sort.Direction.ASC, "nickName"));
    }

    public void searchAction() {
        searchType = SearchType.SEARCH_USER_NAME;
    }

    public char getFirstChar(Group group) {
        return group.getName().charAt(0);
    }
}
