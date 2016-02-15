
/*==============================================================*/
/* Table: league_pram (参数表:保存行业、广告类型信息)                                          */
/*==============================================================*/
drop table if exists league_pram;

create table league_pram
(
   id                   bigint(20) not null comment '主键ID',
   param_name           varchar(30) comment '参数名称',
   param_type           int comment '0：行业 1：广告类型',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table league_pram comment '参数表:保存行业、广告类型信息';



/*==============================================================*/
/* Table: league_size (尺寸表)                                          */
/*==============================================================*/
drop table if exists league_size;

create table league_size
(
   id                   bigint(20) not null comment '主键ID',
   industry_id          bigint(20) comment '行业ID',
   industry_name        varchar(30) comment '行业名称',
   type_id              bigint(20) comment '类型ID',
   type_name            varchar(30) comment '类型名称',
   adv_size             varchar(128) comment '尺寸',
   size_code            varchar(128) comment '尺寸编码',
   link_status          int comment '关联状态',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table league_size comment '尺寸表';



/*==============================================================*/
/* Table: league_adv_info (广告位信息表)                                      */
/*==============================================================*/
drop table if exists league_adv_info;

create table league_adv_info
(
   id                   bigint(20) not null comment '主键ID',
   size_id              bigint(20) comment '广告位id',
   adv_name             varchar(128) comment '广告名称',
   adv_code             varchar(64) comment '根据行业、广告类型、尺寸生成的唯一标识',
   title                varchar(64) comment '标题',
   pic_name             varchar(64) comment '图片名称',
   pic_url              varchar(512) comment '图片Url',
   target_url           varchar(512) comment '目标url',
   memo                 varchar(1000) comment '备注',
   on_flag              int comment '0：过期  1：未到期 2：投放中',
   red_flag             int comment '用于文字广告的突出展示  0：不标红 1：标红',
   order_num            int comment '排序号',
   create_time          datetime comment '创建时间',
   start_time           datetime comment '创建时间',
   end_time             datetime comment '结束时间',
   primary key (id)
);

alter table league_adv_info comment '图片广告表';

drop table if exists league_adv_word;

/*==============================================================*/
/* Table: league_adv_word                                       */
/*==============================================================*/
create table league_adv_word
(
   id                   bigint(20) not null comment '主键ID',
   industry_id          bigint(20) comment '行业id',
   adv_name             varchar(64) comment '广告名称',
   title                varchar(128) comment '标题',
   target_url           varchar(512) comment '目标url',
   memo                 varchar(1000) comment '备注',
   on_flag              int comment '0：过期
            1：未到期
            2：投放中',
   red_flag             int comment '用于文字广告的突出展示
            0：不标红
            1：标红
            ',
   order_num            int comment '用于文字广告的突出展示
            0：不标红
            1：标红
            ',
   create_time          datetime comment '创建时间',
   start_time           datetime comment '创建时间',
   end_time             datetime comment '结束时间',
   primary key (id)
);

alter table league_adv_word comment '文字广告表';


drop table if exists league_ad_traffic_tab;

create table league_ad_traffic_tab
(
   id                   bigint(20) not null comment '主键ID',
   ad_id              bigint(20) comment '广告位id',
   ad_type             varchar(16) comment '广告类型   0 ：图片广告    1：文字广告',
   site_id             bigint(20) comment '站点ID',
   ip                varchar(32) comment '访问ip',
   area             varchar(64) comment '访问区域',
   visit_time              datetime comment '访问时间',
   yyzx_account_id           bigint(20) comment '广告所属账户ID',
   plw_member              varchar(64) comment '品类网会员',
   del_flag int(11) DEFAULT 0 COMMENT '删除标识  0 未删除  1 删除',
   primary key (id)
);

alter table league_ad_traffic_tab comment '广告联盟广告流量表';


DROP TABLE IF EXISTS `league_website_tab`;
CREATE TABLE `league_website_tab` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `site_url` varchar(32) DEFAULT NULL COMMENT '单品网网址',
  `site_name` varchar(64) DEFAULT NULL COMMENT '单品网名称',
  `jd_belong` varchar(64) DEFAULT NULL COMMENT '所属基地',
  `industry_id` bigint(20) DEFAULT NULL COMMENT '行业ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `opt_person` varchar(32) DEFAULT NULL COMMENT '添加人姓名',
  `del_flag` int(11) DEFAULT '0' COMMENT '删除标识  0 未删除  1 删除',
  PRIMARY KEY (`id`)
);

alter table league_website_tab comment '行业单品关系表';


/*==============================================================*/
/* Table:支付信息表                                               */
/*==============================================================*/
drop table if exists payment;

create table payment
(
   id                   bigint(20) not null comment '主键ID',
   user_id              bigint(20) comment '用户ID',
   purcher_id           int(11) comment '采购信息ID',
   adv_code             varchar(128) comment '广告位编码',
   subject              varchar(64) comment '商品名称',
   body                 varchar(512) comment '商品描述',
   goods_type           int(2) comment '商品类型：1，采购  2，广告 等',
   price                decimal(11,2) comment '单价',
   total_fee            decimal(11,2) comment '总价',
   quantity             int comment '购买数量',
   out_trade_no         varchar(64) comment '订单号',
   trade_no             varchar(64) comment '支付宝交易号',
   pay_time             datetime comment '支付时间',
   success_flag         varchar(64) comment '交易状态',
   telephone            varchar(20) comment '手机',
   start_time           datetime comment '开始时间',
   end_time             datetime comment '结束时间',
   common1              varchar(256) comment '预留字段1',
   common2              varchar(256) comment '预留字段2',
   primary key (id)
);

