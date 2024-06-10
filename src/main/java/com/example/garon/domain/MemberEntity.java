package com.example.garon.domain;



import com.example.garon.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberMajor;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO)
    {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberMajor(memberDTO.getMemberMajor());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        return memberEntity;
    }
    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO)
    {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberMajor(memberDTO.getMemberMajor());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        return memberEntity;
    }
}
