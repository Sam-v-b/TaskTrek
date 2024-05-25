package com.sam.TaskTrek.service;

import com.sam.TaskTrek.dto.LoginDto;
import com.sam.TaskTrek.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
