package com.company.backend.businesslayer;

import com.company.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserService {

    public void getUserProject(int id) throws SQLException, IOException;
    /**
     * This method is getUserProject
     *
     * @Description: returns every user in the project has projectId = id;
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     * ${tag}
     */
    public void getProjectManager() throws SQLException, IOException;
    /**
     * This method is getProjectManager
     *
     * @Description: returns every manager of the projects
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     * ${tag}
     */
    public void login (String email, String password) throws SQLException, IOException;
    /**
     * This method is getProjectManager
     *
     * @Description: login for user
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     * ${tag}
     */
}
