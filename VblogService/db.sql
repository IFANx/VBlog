create table user
(
    id          int auto_increment,
    name        varchar(255)                     not null,
    gender      enum ('male', 'female', 'other') null,
    description text                             null,
    password    varchar(255)                     not null,
    account     varchar(255)                     not null,
    email       varchar(255)                     null,
    birthday    date                             null,
    constraint user_pk
        primary key (id)
);

create unique index user_account_uindex
    on user (account);

alter table user
    add portrait blob null;

create table article
(
    id              int auto_increment,
    user_id         int          not null,
    content         text         not null,
    comment_count   int          null,
    like_count      int          null,
    read_count      int          null,
    title           varchar(255) not null,
    tag             varchar(255) null,
    publish_time    datetime     null,
    subscribe_count int          null,
    constraint article_pk
        primary key (id),
    constraint article_user_id_fk
        foreign key (user_id) references user (id)
);

alter table article
    add cover blob null;
create table comment
(
    id           int auto_increment,
    article_id   int      not null,
    commenter_id int      not null,
    content      text     not null,
    comment_time datetime not null,
    constraint comment_pk
        primary key (id),
    constraint comment_article_id_fk
        foreign key (article_id) references article (id),
    constraint comment_user_id_fk
        foreign key (commenter_id) references user (id)
);

create table subscribe
(
    subscriber_id int not null,
    article_id    int not null,
    constraint subscribe_pk
        primary key (article_id, subscriber_id),
    constraint subscribe_article_id_fk
        foreign key (article_id) references article (id),
    constraint subscribe_user_id_fk
        foreign key (subscriber_id) references user (id)
);

create table `like`
(
    article_id int not null,
    user_id    int not null,
    constraint like_pk
        primary key (user_id, article_id),
    constraint like_article_id_fk
        foreign key (article_id) references article (id),
    constraint like_user_id_fk
        foreign key (user_id) references user (id)
);

create table notification
(
    id      int auto_increment,
    user_id int      not null,
    content text     not null,
    time    datetime not null,
    constraint notification_pk
        primary key (id),
    constraint notification_user_id_fk
        foreign key (user_id) references user (id)
);
