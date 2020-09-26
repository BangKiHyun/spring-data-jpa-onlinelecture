package study.datajpa.repository;

public class UsernameOnlyDto {

    private final String username;

    public UsernameOnlyDto(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
