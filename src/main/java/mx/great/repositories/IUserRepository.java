package mx.great.repositories;

import mx.great.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
}
