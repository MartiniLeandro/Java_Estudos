package com.projectWithTest.demo.repositories;

import com.projectWithTest.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);

    @Query("select u from User u where u.firstName =?1 and u.lastName =?2")
    User findByJPQL(String firstName, String lastName);

    @Query("select u from User u where u.firstName =:firstName and u.lastName =:lastName")
    User findByJPQLNamedParams(@Param("firstName") String firstName,@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM users WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    User findBySQL(String firstName, String lastName);

    @Query(value = "SELECT * FROM users WHERE first_name =:firstName AND last_name =:lastName", nativeQuery = true)
    User findBySQLNamedParams(@Param("firstName") String firstName,@Param("lastName") String lastName);

}
