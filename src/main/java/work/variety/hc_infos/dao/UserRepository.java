package work.variety.hc_infos.dao;

import org.springframework.data.repository.CrudRepository;
import work.variety.hc_infos.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByPhone(String phone);
}

