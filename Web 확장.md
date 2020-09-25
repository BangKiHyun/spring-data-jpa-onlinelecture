# Web 확장

## 도메인 클래스 컨버터

- HTTP 파라미터로 넘어온 엔티티의 아이디로 엔티티 객체를 찾아서 바인딩
- HTTP 요청은 회원 `id`를 받지만 도메인 클래스 컨버터가 중간에 동작해 회원 엔티티 객체를 반환
- 도메인 클래스 컨버터도 리파지토리를 사용해서 엔티티 찾음

## 주의

- 도메인 클래스 컨버터로 엔티티를 파라미터로 받으면, 이 엔티티는 **단순 조회용으로만 사용**해야 함
- **트랜잭션이 없는 범위에서 엔티티를 조회했으므로 엔티티를 변경해도 DB에 반영되지 않음**
- 권장하지 않음

</br >

## 페이징과 정렬

- 파라미터로 `Pageable`을 받을 수 있음
- `Pageable`은 인터페이스, 실제는 `org.springframework.data.domain.PageRequest`겍체 생성

### 요청 파라미터

- `/members?page=0&size=3&sort=id,desc&sort=username,desc`
- page: 현제 페이지, 0부터 시작
- size: 한 페이지에 노출할 데이터 건수
- sort: 정렬 조건을 정의
  - 정렬 속성, 정렬 속성...(ASC/DESC), 정렬 방향을 변경하고 싶으면 `sort` 파라미터 추가(`asc`생략 가능)

</br >

## 기본값 설정

### 글로벌 설정

~~~properties
spring.data.web.pageable.default-page-size=20 /# 기본 페이지 사이즈/ spring.data.web.pageable.max-page-size=2000 /# 최대 페이지 사이즈/
~~~

### 개별 설정

`@PageableDefault` 사용

~~~java
public Page<Member> list2(@PageableDefault(size = 5, sort = "username") Pageable pageable) {
}
~~~

</br >

## Page내용 DTO로 변환

- 엔티티를 API로 노출하면 다양한 문제 발생. 꼭 DTO로 변환해서 반환해야 함
- Page는 `map()`을 지원해서 내부 데이터를 다른 것으로 변경할 수 있음

~~~java
public Page<MemberDto> list3(@PageableDefault(size = 5, sort = "username") Pageable pageable) {
        return memberRepository.findAll(pageable)
                .map(MemberDto::new);
}
~~~

