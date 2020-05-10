create table User (
    `uid` int PRIMARY KEY auto_increment ,
    `userName` varchar(255) not null ,
    `password` varchar(255) not null ,
    `avatarUrl` varchar(255) not null
)