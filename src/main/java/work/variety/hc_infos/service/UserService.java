package work.variety.hc_infos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import work.variety.hc_infos.dao.UserRepository;
import work.variety.hc_infos.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User create(String password, String weixinId, String phone, int buildingNo, int unitNo, int roomNo) {
        User user = new User(weixinId, phone, buildingNo, unitNo, roomNo);
//        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return null;
        return user;
    }

}
