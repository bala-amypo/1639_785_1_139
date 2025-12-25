// // package com.example.demo.repository;
// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.entity.User;


// // @Repository
// // public interface UserRepository extends JpaRepository<User,Long>{

// // }
// package com.example.demo.repository;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;
// import com.example.demo.entity.User;

// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {

//     Optional<User> findByEmail(String email);
// }
package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
