package com.example.dz_3_3.repository;

import com.example.dz_3_3.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findAvatarByStudentId(Long studentId);
}
