package at.ikic.tradingPlatform.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import at.ikic.tradingPlatform.Entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID>{
    User findByMail(String mail);

}
