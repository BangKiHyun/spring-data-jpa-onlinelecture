package study.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {
    //v1
    //String getUsername();

    //v2
    @Value("#{target.username + ' ' + target.age}")
    String getUsername();
}
