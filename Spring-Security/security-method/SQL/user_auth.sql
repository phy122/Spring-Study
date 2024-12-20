CREATE TABLE `user_auth` (
	`no`	BIGINT	NOT NULL	COMMENT 'PK',
	`id`	VARCHAR(255)	NOT NULL	COMMENT 'UK',
	`user_no`	BIGINT	NOT NULL	COMMENT '회원PK',
	`username`	VARCHAR(100)	NOT NULL	COMMENT '아이디',
	`auth`	VARCHAR(100)	NULL	COMMENT '권한',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);