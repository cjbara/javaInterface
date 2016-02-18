.mode column
.header on

select r.region, players  from regions r 

join (
	select s.regcode as REGION, count(*) as PLAYERS 
	from streg s 
	join roster x on s.stcode = x.stcode 
	group by s.regcode order by 2 desc, 1
     ) 

s where r.regcode=s.region";
;
