package com.dudu.HelpDeskAPI.repository;

import com.dudu.HelpDeskAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
