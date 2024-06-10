package com.example.garon.controller;


import com.example.garon.dto.MemberDTO;
import com.example.garon.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerMember(@RequestBody MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> memberDTOList = memberService.findAll();
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id) {
        MemberDTO memberDTO = memberService.findById(id);
        if (memberDTO != null) {
            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        memberDTO.setId(id);
        memberService.update(memberDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Long id) {
        memberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
