package com.shuijing.boot.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021/1/24
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameContaining(String name);

    Page<User> findByNameContaining(String name, Pageable pageable);

    @Query("select u from User u where u.birthDay = ?1")
    List<User> findByBirthDay(LocalDate birthDay);

    @Query(value = "select * from user where birth_day =:birthDay",nativeQuery = true)
    List<User> findByBirthDayNative(@Param("birthDay") String birthDay);

    @Modifying
    @Transactional
    @Query(value = "delete from User")
    int delete();
}
