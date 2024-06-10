package com.example.garon.repository;


import com.example.garon.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByMemberMajor(String memberMajor);
}
