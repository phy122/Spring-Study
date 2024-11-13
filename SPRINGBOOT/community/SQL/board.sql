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
INSERT INTO `board` (`no`, `id`, `title`, `writer`, `content`, `created_at`, `updated_at`) VALUES
(1, 'id001', '첫 번째 글', '작성자1', '첫 번째 글의 내용입니다.', NOW(), NOW()),
(2, 'id002', '두 번째 글', '작성자2', '두 번째 글의 내용입니다.', NOW(), NOW()),
(3, 'id003', '세 번째 글', '작성자3', '세 번째 글의 내용입니다.', NOW(), NOW()),
(4, 'id004', '네 번째 글', '작성자4', '네 번째 글의 내용입니다.', NOW(), NOW()),
(5, 'id005', '다섯 번째 글', '작성자5', '다섯 번째 글의 내용입니다.', NOW(), NOW()),
(6, 'id006', '여섯 번째 글', '작성자6', '여섯 번째 글의 내용입니다.', NOW(), NOW()),
(7, 'id007', '일곱 번째 글', '작성자7', '일곱 번째 글의 내용입니다.', NOW(), NOW()),
(8, 'id008', '여덟 번째 글', '작성자8', '여덟 번째 글의 내용입니다.', NOW(), NOW()),
(9, 'id009', '아홉 번째 글', '작성자9', '아홉 번째 글의 내용입니다.', NOW(), NOW()),
(10, 'id010', '열 번째 글', '작성자10', '열 번째 글의 내용입니다.', NOW(), NOW());
