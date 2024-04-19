package kz.projcet.SpringSecurity;

import kz.projcet.SpringSecurity.entity.Role;
import kz.projcet.SpringSecurity.entity.User;
import kz.projcet.SpringSecurity.repository.RoleRepository;
import kz.projcet.SpringSecurity.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

//    @Test
//    public void testAssignRoleToUser() {
//        Integer userId = 4;
//        Integer roleId = 3;
//        User user = repo.findById(userId).get();
//        user.addRole(new Role(roleId));
//
//        User updatedUser = repo.save(user);
//        assertThat(updatedUser.getRoles()).hasSize(1);
//
//    }

    @Test
    public void testAssignRoleToUser() {
        Integer userId = 2;
        User user = repo.findById(userId).get();
        user.addRole(new Role(1));
        user.addRole(new Role(2));


        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(2);

    }

}
