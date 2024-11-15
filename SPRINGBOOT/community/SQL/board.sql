CREATE TABLE `board` (
	`no`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT 'PK',
	`id`	VARCHAR(255)	NOT NULL	COMMENT 'UK',
	`title`	VARCHAR(100)	NOT NULL	COMMENT '제목',
	`writer`	VARCHAR(100)	NOT NULL	COMMENT '작성자',
	`content`	TEXT	NULL	COMMENT '내용',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);
DROP TABLE IF EXISTS board;

INSERT INTO `board` (`id`, `title`, `writer`, `content`)
VALUES 
    ('board001', '첫 번째 게시글', '홍길동', '첫 번째 게시글의 내용입니다.'),
    ('board002', '두 번째 게시글', '김철수', '두 번째 게시글의 내용입니다.'),
    ('board003', '세 번째 게시글', '이영희', '세 번째 게시글의 내용입니다.'),
    ('board004', '네 번째 게시글', '박민수', '네 번째 게시글의 내용입니다.'),
    ('board005', '다섯 번째 게시글', '정현우', '다섯 번째 게시글의 내용입니다.'),
    ('board006', '여섯 번째 게시글', '장지훈', '여섯 번째 게시글의 내용입니다.'),
    ('board007', '일곱 번째 게시글', '김하나', '일곱 번째 게시글의 내용입니다.'),
    ('board008', '여덟 번째 게시글', '최수진', '여덟 번째 게시글의 내용입니다.'),
    ('board009', '아홉 번째 게시글', '윤서준', '아홉 번째 게시글의 내용입니다.'),
    ('board010', '열 번째 게시글', '박지수', '열 번째 게시글의 내용입니다.');

    INSERT INTO `board` (`id`, `title`, `writer`, `content`)
VALUES 
    ('board001', '첫 번째 게시글', '홍길동', '첫 번째 게시글의 내용입니다.'),
    ('board002', '두 번째 게시글', '김철수', '두 번째 게시글의 내용입니다.'),
    ('board003', '세 번째 게시글', '이영희', '세 번째 게시글의 내용입니다.'),
    ('board004', '네 번째 게시글', '박민수', '네 번째 게시글의 내용입니다.'),
    ('board005', '다섯 번째 게시글', '정현우', '다섯 번째 게시글의 내용입니다.'),
    ('board006', '여섯 번째 게시글', '장지훈', '여섯 번째 게시글의 내용입니다.'),
    ('board007', '일곱 번째 게시글', '김하나', '일곱 번째 게시글의 내용입니다.'),
    ('board008', '여덟 번째 게시글', '최수진', '여덟 번째 게시글의 내용입니다.'),
    ('board009', '아홉 번째 게시글', '윤서준', '아홉 번째 게시글의 내용입니다.'),
    ('board010', '열 번째 게시글', '박지수', '열 번째 게시글의 내용입니다.');

    INSERT INTO `board` (`id`, `title`, `writer`, `content`)
VALUES 
    ('board001', '첫 번째 게시글', '홍길동', '첫 번째 게시글의 내용입니다.'),
    ('board002', '두 번째 게시글', '김철수', '두 번째 게시글의 내용입니다.'),
    ('board003', '세 번째 게시글', '이영희', '세 번째 게시글의 내용입니다.'),
    ('board004', '네 번째 게시글', '박민수', '네 번째 게시글의 내용입니다.'),
    ('board005', '다섯 번째 게시글', '정현우', '다섯 번째 게시글의 내용입니다.'),
    ('board006', '여섯 번째 게시글', '장지훈', '여섯 번째 게시글의 내용입니다.'),
    ('board007', '일곱 번째 게시글', '김하나', '일곱 번째 게시글의 내용입니다.'),
    ('board008', '여덟 번째 게시글', '최수진', '여덟 번째 게시글의 내용입니다.'),
    ('board009', '아홉 번째 게시글', '윤서준', '아홉 번째 게시글의 내용입니다.'),
    ('board010', '열 번째 게시글', '박지수', '열 번째 게시글의 내용입니다.');

