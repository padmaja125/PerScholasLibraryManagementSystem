package com.project.perscholaslms;

import com.project.perscholaslms.common.Constants;
import com.project.perscholaslms.models.User;
import com.project.perscholaslms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }

    private void initDatabaseEntities() {

        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User("Mr. Admin", "admin", "admin", Constants.ROLE_ADMIN));
            userService.addNew(new User("Mr. Librarian", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
            userService.addNew(new User("Mr. User", "user", "user", Constants.ROLE_USER));
        }

    }
}