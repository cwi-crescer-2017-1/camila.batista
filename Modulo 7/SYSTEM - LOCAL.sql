Create tablespace CRESCER17DAT
datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\crescer17dat01.dbf'
size 100m
autoextend on
next 100m
maxsize 2048m;


Create user CRESCER2017 identified by CRESCER2017;


Alter user CRESCER2017 default tablespace CRESCER17DAT;


grant connect, resource, create view to CRESCER2017;

CREATE DIRECTORY ORACLE_DUMP AS 'C:\ORACLE\DATAPUMP';

