/*CREATE USER*/ 
CREATE USER IF NOT EXISTS 'mtp'@'%' IDENTIFIED BY 'mtp';
/*GRANT PERMISSIONS TO A USER*/
GRANT ALL PRIVILEGES ON *.* TO 'mtp'@'%';