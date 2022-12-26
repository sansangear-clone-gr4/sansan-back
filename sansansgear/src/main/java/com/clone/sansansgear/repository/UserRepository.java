package com.clone.sansansgear.repository;

import com.clone.sansansgear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
