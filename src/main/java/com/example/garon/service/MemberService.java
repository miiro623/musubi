package com.example.garon.service;

import com.example.garon.domain.MemberEntity;
import com.example.garon.dto.MemberDTO;
import com.example.garon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberMajor = memberRepository.findByMemberMajor(memberDTO.getMemberMajor());
        if (byMemberMajor.isPresent()) {
            MemberEntity memberEntity = byMemberMajor.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                return MemberDTO.fromEntity(memberEntity);
            }
        }
        return null;
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        return memberEntityList.stream()
                .map(MemberDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        return optionalMemberEntity.map(MemberDTO::fromEntity).orElse(null);
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberMajor(myEmail);
        return optionalMemberEntity.map(MemberDTO::fromEntity).orElse(null);
    }

    public void update(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toUpdateMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
