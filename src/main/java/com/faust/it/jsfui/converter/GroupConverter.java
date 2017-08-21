package com.faust.it.jsfui.converter;

import com.faust.it.dao.GroupDao;
import com.faust.it.entity.Group;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Group.class)
@Component
public class GroupConverter implements Converter {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return groupDao.get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return ((Group) value).getIdGroup().toString();
    }
}
