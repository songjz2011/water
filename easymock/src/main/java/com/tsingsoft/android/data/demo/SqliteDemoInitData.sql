--******备注：此文件中不需要commit;*****


-- 插入demo用户信息
INSERT INTO USER (NAME,PASSWORD,ISDEFAULT) VALUES('admin','admin','1');

-- 插入demo电网单位
INSERT INTO LF_CTRL_NET (NETID,NETNAME,UPNETID,NETLEVEL,USERNAME) VALUES('00','湖州电力局','00',0,'admin');
INSERT INTO LF_CTRL_NET (NETID,NETNAME,UPNETID,NETLEVEL,USERNAME) VALUES('03','长兴县调','00',1,'admin');
INSERT INTO LF_CTRL_NET (NETID,NETNAME,UPNETID,NETLEVEL,USERNAME) VALUES('04','德清县调','00',1,'admin');
--INSERT INTO LF_CTRL_NET (NETID,NETNAME,UPNETID,NETLEVEL,USERNAME) VALUES('05','安吉县调','00',1,'admin');
--INSERT INTO LF_CTRL_NET (NETID,NETNAME,UPNETID,NETLEVEL,USERNAME) VALUES('06','市区分调','00',1,'admin');

--插入demo口径
INSERT INTO LF_CTRL_CALIBER (CALIBERID, CALIBERNAME) VALUES ('00', '默认口径');

--插入相关因素信息
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('0','日类型','','N','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('1','平均温度','℃','Y','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('2','最高温度','℃','Y','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('3','最低温度','℃','Y','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('4','降雨量','毫米','Y','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('5','天气类型','','N','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('6','风力','','N','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('7','风向','','N','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('8','湿度','','Y','',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('9','实感温度','℃','Y','2',11);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('10','温湿指数','','Y','2',12);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('11','寒冷指数','','Y','2',13);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('12','人体舒适度指数','','Y','2',14);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('13','气压','百帕','Y','',8);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('14','风速','m/s','Y','1',5);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('15','最大风速','m/s','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('16','最小风速','m/s','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('17','最大湿度','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('18','最小湿度','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('19','实感温度(最高温度)','℃','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('20','实感温度(最低温度)','℃','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('21','舒适度指数(最高温度)','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('22','舒适度指数(最低温度)','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('23','寒湿指数(最低温度)','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('24','寒湿指数(最高温度)','','Y','3',null);
INSERT INTO ST_FACTOR (FACTORID,FACTORNAME,UNIT,ISLINEAR,TYPEID,ORDERBY) VALUES ('25','温度','℃','Y','',15);

--插入相关因素映射库信息
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',0,'星期日');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',1,'星期一');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',2,'星期二');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',3,'星期三');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',4,'星期四');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',5,'星期五');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('0',6,'星期六');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',0,'晴');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',1,'多云');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',2,'阴');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',3,'阵雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',4,'雷阵雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',5,'雷阵雨并伴有冰雹');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',6,'雨夹雪');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',7,'小雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',9,'大雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',10,'暴雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',11,'大暴雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('5',12,'特大暴雨');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',0,'小于3级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',1,'3 到4 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',2,'4到5 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',3,'5到6 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',4,'6到7 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',5,'7到8 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',6,'8到9 级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',8,'10到11级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('6',9,'11到12级');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',0,'无风向');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',1,'东北风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',2,'东风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',3,'东南风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',4,'南风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',5,'西南风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',6,'西风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',7,'西北风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',8,'北风');
INSERT INTO ST_FACTOR_MAPLIB (FACTORID,BEFOREVALUE,ITEMNAME) VALUES ('7',9,'旋转不定');
