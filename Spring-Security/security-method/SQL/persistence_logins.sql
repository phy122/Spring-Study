CREATE TABLE `persistence_logins` (
	`series`	VARCHAR(255)	NOT NULL	COMMENT 'series (세션 식별키)',
	`username`	VARCHAR(64)	NOT NULL	COMMENT '아이디',
	`token`	VARCHAR(64)	NOT NULL	COMMENT '인증토큰',
	`last_used`	timestamp	NOT NULL	COMMENT '최신인증시간'
);