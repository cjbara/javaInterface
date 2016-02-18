.header on
.mode column

select b.position, 
sum(case when b.regcode = 1 then b.avgWeight end) as '1',
sum(case when b.regcode = 2 then b.avgWeight end) as '2',
sum(case when b.regcode = 3 then b.avgWeight end) as '3',
sum(case when b.regcode = 4 then b.avgWeight end) as '4',
sum(case when b.regcode = 5 then b.avgWeight end) as '5'
from (
  select position, regcode, avg(weight) as avgWeight
  from roster r, streg s
  where r.stcode = s.stcode
  group by position, regcode
  order by 2 desc, 1
) b
group by 1
order by 1
;
