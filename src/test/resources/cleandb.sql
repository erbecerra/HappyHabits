delete from user;
INSERT INTO user VALUES (1,'Joe','Coyne','jcoyne','supersecret1','1964-04-01'),(2,'Fred','Hensen','fhensen','supersecret2','1988-05-08'),(3,'Barney','Curry','bcurry','supersecret3','1947-11-11'),(4,'Karen','Mack','kmack','supersecret4','1986-07-08'),(5,'Dianne','Klein','dklein','supersecret5','1991-09-22'),(6,'Dawn','Tillman','dtillman','supersecret6','1979-08-30');
delete from role;
INSERT INTO role VALUES (1,'jcoyne','registered',1),(2,'fhensen','registered',2);
delete from goal;
INSERT INTO goal VALUES (1,'Test 1',3,1,1),(2,'Test 2',3,1,1),(3,'Test 3',3,2,1),(4,'Test 4',2,3,1),(5,'Test 5',1,3,1),(6,'Test 6',1,2,0);
delete from pokemon;
INSERT INTO pokemon VALUES (1,'Pikachu','electric pokemon',1, 1, 'something.com'),(2,'Bulbasaur','grass, poison',2,3, 'something.com');
delete from log;
INSERT INTO log VALUES (1,1,'2020-04-20',0),(2,1,'2020-04-23',0),(3,2,'2020-08-20',0);
