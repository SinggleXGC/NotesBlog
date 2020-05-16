create table Essay(
    `bid` int PRIMARY KEY auto_increment ,
    `title` varchar(255) not null ,
    `content` text not null ,
    `showPicture` varchar(255),
    `createTime` datetime not null ,
    `updateTime` datetime not null ,
    `isPublish` bit not null ,
    `tid` int not null ,
    `uid` int not null,
    foreign key (`tid`) references Tag(`tid`),
    foreign key(`uid`) references User(`uid`)
)