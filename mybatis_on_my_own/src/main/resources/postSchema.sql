create database codingon default character set utf8 default collate utf8_general_ci;
use codingon;

-- posts 테이블 생성
create table posts (
                       id int auto_increment primary key,
                       title varchar(20) not null,
                       content varchar(100) not null,
                       writer varchar(10) not null,
                       created_at timestamp default current_timestamp
);

-- 더미 데이터 삽입
insert into posts (writer, title, content) values
                                        ('제인도', '집에가고 싶습니다.', 'ㅈㄱㄴ'),
                                        ('제인스미스', '제목1234','본문2134'),
                                        ('밥존슨', '제목 5678','본문 54678');

select * from posts;