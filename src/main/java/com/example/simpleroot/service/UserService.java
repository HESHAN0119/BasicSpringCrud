package com.example.simpleroot.service;

import com.example.simpleroot.dto.UserDTO;
import com.example.simpleroot.entity.User;
import com.example.simpleroot.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));

        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;

    }

    //get details using user id
    // SELECT * FROM user WHERE id=1
    public UserDTO getUserByUserID(String useId){
       User user= userRepo.getUserByUserId(useId);
       return modelMapper.map(user, UserDTO.class);

    }

    //get Details using id and address
    //SELECT * FROM user WHERE id=1 and address="Gamapaha
    public UserDTO getUserByIdAndAddress(String userId, String address){
        User user=userRepo.getUserByIdAndAddress(userId,address);
        return modelMapper.map(user, UserDTO.class);
    }
}
