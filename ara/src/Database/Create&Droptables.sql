CREATE TABLE USERINFO
	(userid     INTEGER,	
	username    CHAR(20) NOT NULL,
	PRIMARY KEY (userid));

CREATE TABLE SCORE
	(scoreid    INTEGER,
	score	    INTEGER NOT NULL,
      	userid      INTEGER,
	songname    CHAR(50),
        PRIMARY KEY (scoreid,userid),
	FOREIGN KEY (userid) REFERENCES USERINFO(userid) ON DELETE CASCADE);

CREATE TABLE SONG
	(songid     INTEGER,
	songname    CHAR(50),
	songscale   CHAR(10),
	PRIMARY KEY(songid));


DROP TABLE USERINFO;

DROP TABLE SCORE;

DROP TABLE SONG;

//Show attributes
show columns from *****tablename*****;