package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.User;
import java.lang.String;
import java.util.List;

public interface UserDao extends JpaRepository<User,Long>
{
	User findByEmail(String email);
}
