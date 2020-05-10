create table Essay(
    `bid` int PRIMARY KEY auto_increment ,
    `title` varchar(255) not null ,
    `content` text not null ,
    `showPicture` varchar(255),
    `createTime` datetime not null ,
    `updateTime` datetime not null ,
    `isPublish` bit not null ,
    `tid` int references Tag (`tid`) ,
    `uid` int not null references User (`uid`)
)