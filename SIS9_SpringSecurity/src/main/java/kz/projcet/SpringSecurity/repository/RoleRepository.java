package kz.projcet.SpringSecurity.repository;

import kz.projcet.SpringSecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
