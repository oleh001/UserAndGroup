package com.faust.it.jsfui.controller;

import com.faust.it.dao.GroupDao;
import com.faust.it.entity.Group;
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
public class GroupController extends AbstractController<Group> {

    public static final String GROUP_SEARCH_COLUMN="name";

    //Default count page size
    public static final int DEFAULT_PAGE_SIZE = 10;

    //For DataTabel
    private int rowsCount = DEFAULT_PAGE_SIZE;

    //Latest search
    private SearchType searchType;

    @Autowired
    private GroupDao groupDao;

    //Activity group
    private Group selectedGroup=new Group();

    //Pair FSF
    private LazyDataTable<Group> lazyModel;

    private Page<Group> groupPages;

    //Input serch text
    private String searchGroupName;

    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable(this);
    }

//    @Transactional
    public void save() {
        groupDao.save(selectedGroup);
        selectedGroup = new Group();
    }

    @Override
    public Page<Group> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        if (sortField == null) {
            sortField = GROUP_SEARCH_COLUMN;
        }

        if (searchType == null) {
            groupPages = groupDao.getAll(pageNumber, pageSize, sortField, sortDirection);
        } else {

            switch (searchType) {
                case SEARCH_GROUP_NAME:
                    groupPages = groupDao.search(pageNumber, pageSize, sortField, sortDirection, searchGroupName);
                    break;
                case ALL:
                    groupPages = groupDao.getAll(pageNumber, pageSize, sortField, sortDirection);
                    break;
            }
        }
        return groupPages;
    }

    @Override
    public void addAction() {
        selectedGroup = new Group();
    }

    @Override
    public void editAction() {
    }

    @Override
    public void deleteAction() {
        groupDao.delete(selectedGroup);
    }

    public List<Group> getAll() {
        return groupDao.getAll(new Sort(Sort.Direction.ASC, "name"));
    }

    public void searchAction() {
        searchType = SearchType.SEARCH_GROUP_NAME;
    }
}
