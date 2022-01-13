DROP TABLE IF EXISTS TRADE_LOG;
create table TRADE_LOG
(
    LOG_CODE     CHARACTER default 30 not null,
    LOG_DATE     INTEGER default 8  not null,
    LOG_NAME     CHARACTER default 30,
    LOG_SVOLUME  INTEGER   default 30,
    LOG_BVOLUME  INTEGER   default 30,
    LOG_PBVOLUME INTEGER   default 30,
    LOG_SPAYENNT INTEGER   default 30,
    LOG_BPAYMENT INTEGER   default 30,
    LOG_PSVOLUME INTEGER   default 30,
    constraint TRADE_LOG_PK
        primary key (LOG_CODE, LOG_DATE)
);