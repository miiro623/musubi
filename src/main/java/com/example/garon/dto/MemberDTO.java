package com.example.garon.dto;
import com.example.garon.domain.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String memberMajor;
    private String memberPassword;
    private String memberName;

    public static MemberDTO fromEntity(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberMajor(memberEntity.getMemberMajor());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }
}
