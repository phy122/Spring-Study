CREATE TABLE `files` (
	`no`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT 'PK',
	`id`	VARCHAR(255)	NOT NULL	COMMENT 'UK',
	`file_name`	TEXT	NOT NULL	COMMENT '파일명',
	`file_path`	TEXT	NOT NULL	COMMENT '파일경로',
	`file_size`	BIGINT	NULL	COMMENT '용량',
	`type`	ENUM('main','sub')	NOT NULL	DEFAULT 'main'	COMMENT '타입',
	`parent_table`	VARCHAR(100)	NOT NULL	COMMENT '부모테이블',
	`parent_no`	BIGINT	NOT NULL	COMMENT '부모PK',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);

DROP TABLE IF EXISTS files;