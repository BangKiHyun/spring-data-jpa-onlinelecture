package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

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

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getUsername();
        this.teamName = member.getTeam().getName();
    }
}
