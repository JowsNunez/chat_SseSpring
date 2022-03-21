package mx.great.repositories;

import mx.great.models.Typechat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypechatRepository extends JpaRepository<Typechat, Integer> {
}