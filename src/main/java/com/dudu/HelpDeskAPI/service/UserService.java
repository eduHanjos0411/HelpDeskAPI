package com.dudu.HelpDeskAPI.service;

import com.dudu.HelpDeskAPI.dto.user.UserRequest;
import com.dudu.HelpDeskAPI.dto.user.UserResponse;
import com.dudu.HelpDeskAPI.model.User;
import com.dudu.HelpDeskAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createNewUser(UserRequest dataToCreate) {
        User newUser = new User();
        newUser.setNome(dataToCreate.nome());
        newUser.setEmail(dataToCreate.email());
        newUser.setSenha(dataToCreate.senha());
        userRepository.save(newUser);

        return new UserResponse(dataToCreate.nome(), dataToCreate.email());
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponse::fromEntity).toList();
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(user.getNome(), user.getEmail());
    }

    public UserResponse updateUser(Long id, UserRequest dataToUpdate) {
        User userFound = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userFound.setNome(dataToUpdate.nome());
        userFound.setEmail(dataToUpdate.email());
        userFound.setSenha(dataToUpdate.senha());
        userRepository.save(userFound);

        return new UserResponse(dataToUpdate.nome(), dataToUpdate.email());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
