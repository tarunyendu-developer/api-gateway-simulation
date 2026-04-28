package com.gateway.service;

import com.gateway.dto.UserDTO;
import com.gateway.entity.User;
import com.gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //  Entity → DTO
    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    //  DTO → Entity
    private User mapToEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //  Get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    //  Get by ID
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }

    //  Create user
    public UserDTO createUser(UserDTO dto) {
        User user = mapToEntity(dto);
        return mapToDTO(userRepository.save(user));
    }

    //  Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}