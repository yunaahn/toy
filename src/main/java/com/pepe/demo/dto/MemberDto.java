package com.pepe.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class MemberDto {

    @NotBlank(message = "필수 입력 사항입니다.")
    @Size(min = 5, max = 15, message = "5자 이상 15자 이하로 가능합니다.")
    private String Id;

    @NotBlank(message = "필수 입력 사항입니다.")
    @Size(min = 2, max = 15)
    private String Name;

    @NotBlank(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
    private String Email;
    
    @NotBlank(message = "필수 입력 사항입니다.")
    private String Password;
    
    private int AdminYn;

    private boolean passwordNotMatch;
}
