package com.ecommerce.admin.user;

import com.ecommerce.common.entity.Role;
import com.ecommerce.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole(){
        Role adminRole = entityManager.find(Role.class, 1);
        User userBacPH = new User("bacph@gmail.com", "123456", "Bac", "Pham");
        userBacPH.addRole(adminRole);
        User savedUser = userRepository.save(userBacPH);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRole(){
        Role editorRole = new Role(3);
        Role assistantRole = new Role(5);
        User userNganDo = new User("ngando@gmail.com", "123456", "Ngan", "Do");
        userNganDo.addRole(editorRole);
        userNganDo.addRole(assistantRole);
        User savedUser = userRepository.save(userNganDo);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers(){
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUserById(){
        User user = userRepository.findById(1).get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void testUpdateUserDetails(){
        User user = userRepository.findById(1).get();
        user.setEnabled(true);
        user.setEmail("bacph18@gmail.com");
        userRepository.save(user);
    }

    @Test
    public void updateUserRoles(){
        User userNganDo = userRepository.findById(2).get();
        Role editorRole = new Role(3);
        Role salespersonRole = new Role(2);

        userNganDo.getRoles().remove(editorRole);
        userNganDo.addRole(salespersonRole);

        userRepository.save(userNganDo);
    }

    @Test
    public void testDeleteUser(){
        userRepository.deleteById(2);
    }
}
