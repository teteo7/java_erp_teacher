-- title
insert into title values(1, '사장');
insert into title values(2, '부장');

-- department
insert into department values (1, '기획', 10);
insert into department values (2, '영업', 20);
insert into department values (3, '개발', 21);

delete from department where deptno=4;

-- employee
insert into employee values(4377, '이성래', 1, null, 4500000, 1);
insert into employee values(1004, '석주명', 2, 4377, 4000000, 2);
insert into employee values(1005, '장준화', null, null, 4000000, null);
insert into employee values(1006, '김혜인', 1, 4377, 2000000, null);


delete from employee where empno = 1004;
update employee 
   set empname = '권민성', title = 1, manager =null,salary =3000000,dno = 1
 where empno =1004;

-- Trade
insert into Trade values(1, "클라우드", "박태환", "010-9999-9999", "서울 관악구 관악로 145 봉천동");
insert into Trade values(2, "(주)사랑식품", "박치완", "010-3343-7758", "주소 시청로 땡땡구 37 설악길");
insert into Trade values(3, "미스터박스", "홍백훈", "010-3788-9988", "시청 서구구 벌나로 29 음식길");
insert into Trade values(4, "미소인력", "김민철", "010-2277-8888", "대지 강철구 빌드로 34 방루길");

select code, name, repr, number, address from trade;
select * from trade;




desc Trade;
select deptno, deptname, floor from department;
select * from employee;
select tno, tname from title;
desc employee;