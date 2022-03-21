package mx.great.repositories;

import mx.great.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMessageRepository extends JpaRepository<Message, Integer> {
}
