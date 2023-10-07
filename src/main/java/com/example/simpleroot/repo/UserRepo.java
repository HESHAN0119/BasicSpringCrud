package com.example.simpleroot.repo;

import com.example.simpleroot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE id = ?1",nativeQuery = true)
    User getUserByUserId(String userid);

    @Query(value = "SELECT * FROM user WHERE id=?1 and address=?2", nativeQuery = true)
    User getUserByIdAndAddress(String id , String address);

    //For Update we have to use @Modifying before type the @Query

}
