package study.datajpa.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String name;
    private String teamName;

    public MemberDto(final Long id, final String name, final String teamName) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
    }
}
