package mx.great.repositories;

import mx.great.models.Chatuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatUserRepository extends JpaRepository<Chatuser, Integer> {


}