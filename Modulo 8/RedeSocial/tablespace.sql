Create tablespace REDEDAT
datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\rededat01.dbf'
size 100m
autoextend on
next 100m
maxsize 2048m;


Create user REDE identified by REDE;


Alter user REDE default tablespace REDEDAT;


grant connect, resource, create view to REDE;

GRANT DEBUG ANY PROCEDURE TO REDE;
GRANT DEBUG CONNECT SESSION TO REDE;