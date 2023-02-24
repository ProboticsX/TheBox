package com.example.thebox.service;

import com.example.thebox.dao.MenuDao;
import com.example.thebox.entity.Menu;

import java.sql.SQLException;
import java.util.List;

public class MenuService {

    private MenuDao menuDao;
    public MenuService() {
        menuDao = new MenuDao();
    }

    public List<Menu> getMenuInfo() throws SQLException {
        return menuDao.getMenuForDisplay();
    }
}
