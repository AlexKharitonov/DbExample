package ak.teaching.dbexample.service;

import ak.teaching.dbexample.dto.UserDto;
import ak.teaching.dbexample.repository.UserRepository;
import ak.teaching.dbexample.repository.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id);

        return new UserDto(user.getId(), user.getName(), user.getLastName());
    }

    public Integer saveUser(UserDto userDto) {
        User user = new User(-1L, userDto.getName(), userDto.getLastName());

        return userRepository.save(user);
    }
}
