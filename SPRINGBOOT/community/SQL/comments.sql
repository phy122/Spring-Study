CREATE TABLE `comments` (
	`no`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT 'PK',
	`id`	VARCHAR(255)	NOT NULL	COMMENT 'UK',
	`board_no`	BIGINT	NOT NULL	COMMENT '외래키',
	`writer`	VARCHAR(100)	NOT NULL	COMMENT '작성자',
	`content`	TEXT	NULL	COMMENT '내용',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);
INSERT INTO `comments` (`no`, `id`, `board_no`, `writer`, `content`, `created_at`, `updated_at`) VALUES
(1, 'user1', 101, '홍길동', '첫 번째 댓글 내용입니다.', '2024-11-13 10:00:00', '2024-11-13 10:00:00'),
(2, 'user2', 101, '김철수', '두 번째 댓글입니다. 유익한 내용이네요.', '2024-11-13 10:30:00', '2024-11-13 10:30:00'),
(3, 'user3', 102, '이영희', '세 번째 댓글입니다. 감사합니다.', '2024-11-13 11:00:00', '2024-11-13 11:00:00'),
(4, 'user4', 103, '박수진', '네 번째 댓글, 좋은 정보입니다.', '2024-11-13 11:30:00', '2024-11-13 11:30:00'),
(5, 'user5', 101, '최민준', '다섯 번째 댓글입니다. 많이 배웠어요.', '2024-11-13 12:00:00', '2024-11-13 12:00:00');

-- 기존 테이블 삭제
DROP TABLE IF EXISTS comments;
