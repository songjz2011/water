create table T_USER  
(  
   USER_ID              VARCHAR(10)            not null,  
   USER_NAME            VARCHAR(30)            not null,  
   PASSWORD             VARCHAR(20)            not null,  
   CONTACT_TEL          VARCHAR(30),  
   EMAIL                VARCHAR(30),  
   CREATE_DATE          DATE,  
   constraint P_KEY_1 primary key (USER_ID)  
);

insert into t_user(user_id, user_name, password) values('root', '系统管理员', 'root');