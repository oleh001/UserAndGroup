package com.faust.it.jsfui.converter;

import com.faust.it.dao.UserDao;
import com.faust.it.entity.User;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = User.class)
@Component
public class UserConverter implements Converter {

    @Autowired
    private UserDao userDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return userDao.get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return ((User) value).getIdUser().toString();
    }
}
