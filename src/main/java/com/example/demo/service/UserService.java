package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserRegistrationRq;
import com.example.demo.model.dto.UserRs;
import com.example.demo.model.dto.UserShortRs;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserRs> findAll() {
        return userRepository.findAll()
            .stream()
            .map(UserMapper::toUserRs)
            .toList();
    }

   public UserRs getUserById(final Long id) {
        return userRepository.findById(id)
            .map(UserMapper::toUserRs)
            .orElseThrow(() -> new IllegalStateException("Can't find user by id: " + id));
    }

    public UserRs postUser(final UserRegistrationRq userRegistrationRq) {
        User user = User.builder()
            .email(userRegistrationRq.getEmail())
            .password(userRegistrationRq.getPassword())
            .build();
        userRepository.save(user);
        return UserMapper.toUserRs(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserRs putUser(final UserShortRs request) {
        User user = userRepository.findById(request.getId())
            .orElseThrow(() -> new IllegalStateException("Can't find user by id: " + request.getId()));

        user.setEmail(request.getEmail());

        return UserMapper.toUserRs(user);
    }

}
