connect igadmin/igadmin@IG;

--创建DW同义词
create or replace synonym DW_PLATFORM_LIST FOR DW_PLATForM_LIST@IG_DW_DBLINK;
create or replace synonym DW_SERVER_LIST FOR DW_SERVER_LIST@IG_DW_DBLINK;
create or replace synonym DW_SERVICE_LIST FOR DW_SERVICE_LIST@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_LIST FOR DW_MEASUREMENT_LIST@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1D FOR DW_MEASUREMENT_DATA_1D@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_6H FOR DW_MEASUREMENT_DATA_6H@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H FOR DW_MEASUREMENT_DATA_1H@IG_DW_DBLINK;
create or replace synonym DW_METRIC_DATA_1M FOR DW_METRIC_DATA_1M@IG_DW_DBLINK;
create or replace synonym DW_METRIC_DATA_2M FOR DW_METRIC_DATA_2M@IG_DW_DBLINK;
create or replace synonym DW_METRIC_DATA_3M FOR DW_METRIC_DATA_3M@IG_DW_DBLINK;
create or replace synonym DW_METRIC_DATA_4M FOR DW_METRIC_DATA_4M@IG_DW_DBLINK;
create or replace synonym DW_METRIC_DATA_VIEW FOR DW_METRIC_DATA_VIEW@IG_DW_DBLINK;
create or replace synonym DW_ALERT_LIST_DETAIL FOR DW_ALERT_LIST_DETAIL@IG_DW_DBLINK;
create or replace synonym DW_SYN_LOG FOR DW_SYN_LOG@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_01M FOR DW_MEASUREMENT_DATA_1H_01M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_02M FOR DW_MEASUREMENT_DATA_1H_02M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_03M FOR DW_MEASUREMENT_DATA_1H_03M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_04M FOR DW_MEASUREMENT_DATA_1H_04M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_05M FOR DW_MEASUREMENT_DATA_1H_05M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_06M FOR DW_MEASUREMENT_DATA_1H_06M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_07M FOR DW_MEASUREMENT_DATA_1H_07M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_08M FOR DW_MEASUREMENT_DATA_1H_08M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_09M FOR DW_MEASUREMENT_DATA_1H_09M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_10M FOR DW_MEASUREMENT_DATA_1H_10M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_11M FOR DW_MEASUREMENT_DATA_1H_11M@IG_DW_DBLINK;
create or replace synonym DW_MEASUREMENT_DATA_1H_12M FOR DW_MEASUREMENT_DATA_1H_12M@IG_DW_DBLINK;

--创建HQ同义词
create or replace synonym HQ_PLATFORM_LIST_VIEW FOR HQ.HQ_PLATFORM_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_SERVER_LIST_VIEW FOR HQ.HQ_SERVER_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_SERVICE_LIST_VIEW FOR HQ.HQ_SERVICE_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_MEASUREMENT_LIST_VIEW FOR HQ.HQ_MEASUREMENT_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_ALERT_LIST_VIEW FOR HQ.HQ_ALERT_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_ALERT_FIXED_LIST_VIEW FOR HQ.HQ_ALERT_FIXED_LIST_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_ALERT_LIST_DETAIL_VIEW FOR HQ.HQ_ALERT_LIST_DETAIL_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_PLATFORM_M_VIEW FOR HQ.HQ_PLATFORM_M_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_SERVER_M_VIEW FOR HQ.HQ_SERVER_M_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_SERVICE_M_VIEW FOR HQ.HQ_SERVICE_M_VIEW@IG_HQ_DBLINK;

create or replace synonym EAM_MEASUREMENT_DATA_1D FOR HQ.EAM_MEASUREMENT_DATA_1D@IG_HQ_DBLINK;
create or replace synonym EAM_MEASUREMENT_DATA_6H FOR HQ.EAM_MEASUREMENT_DATA_6H@IG_HQ_DBLINK;
create or replace synonym EAM_MEASUREMENT_DATA_1H FOR HQ.EAM_MEASUREMENT_DATA_1H@IG_HQ_DBLINK;
create or replace synonym EAM_MEASUREMENT_DATA FOR HQ.EAM_MEASUREMENT_DATA@IG_HQ_DBLINK;

create or replace synonym HQ_MOCHA_ALERT FOR HQ.HQ_MOCHA_ALERT@IG_HQ_DBLINK;
create or replace synonym HQ_JITONG_ALERT FOR HQ.HQ_JITONG_ALERT@IG_HQ_DBLINK;

---业务资源监控同义词 
create or replace synonym HQ_AVAILABILITY_VIEW FOR HQ.HQ_AVAILABILITY_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_GROUP_PLATFORM_VIEW FOR HQ.HQ_GROUP_PLATFORM_VIEW@IG_HQ_DBLINK;
create or replace synonym HQ_BASE_INFO_VIEW FOR HQ.HQ_BASE_INFO_VIEW@IG_HQ_DBLINK;

---创建实时监控数据表同义词
create or replace synonym HQ_METRIC_DATA_0D_0S FOR HQ.HQ_METRIC_DATA_0D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_0D_1S FOR HQ.HQ_METRIC_DATA_0D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_1D_0S FOR HQ.HQ_METRIC_DATA_1D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_1D_1S FOR HQ.HQ_METRIC_DATA_1D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_2D_0S FOR HQ.HQ_METRIC_DATA_2D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_2D_1S FOR HQ.HQ_METRIC_DATA_2D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_3D_0S FOR HQ.HQ_METRIC_DATA_3D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_3D_1S FOR HQ.HQ_METRIC_DATA_3D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_4D_0S FOR HQ.HQ_METRIC_DATA_4D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_4D_1S FOR HQ.HQ_METRIC_DATA_4D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_5D_0S FOR HQ.HQ_METRIC_DATA_5D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_5D_1S FOR HQ.HQ_METRIC_DATA_5D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_6D_0S FOR HQ.HQ_METRIC_DATA_6D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_6D_1S FOR HQ.HQ_METRIC_DATA_6D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_7D_0S FOR HQ.HQ_METRIC_DATA_7D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_7D_1S FOR HQ.HQ_METRIC_DATA_7D_1S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_8D_0S FOR HQ.HQ_METRIC_DATA_8D_0S@IG_HQ_DBLINK;
create or replace synonym HQ_METRIC_DATA_8D_1S FOR HQ.HQ_METRIC_DATA_8D_1S@IG_HQ_DBLINK;
---业务资源监控维护表同义词
create or replace synonym HQ_SUPPORT_SERVER_TYPE FOR HQ.HQ_SUPPORT_SERVER_TYPE@IG_HQ_DBLINK;
create or replace synonym EAM_SERVER_TYPE FOR HQ.EAM_SERVER_TYPE@IG_HQ_DBLINK;
create or replace synonym EAM_MEASUREMENT_TEMPL FOR HQ.EAM_MEASUREMENT_TEMPL@IG_HQ_DBLINK;
--短信平台
create or replace synonym SMS_QUEUE FOR HQ.SMS_QUEUE@IG_HQ_DBLINK;
create or replace synonym SEND_SMSLOG FOR HQ.SEND_SMSLOG@IG_HQ_DBLINK;

--IP映射
create or replace synonym HQ_IP_FILTER FOR HQ.HQ_IP_FILTER@IG_HQ_DBLINK;

--序列映射
create or replace synonym SMS_QUEUE_SEQ FOR HQ.SMS_QUEUE_SEQ@IG_HQ_DBLINK;

exit